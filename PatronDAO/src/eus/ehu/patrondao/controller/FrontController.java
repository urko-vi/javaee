package eus.ehu.patrondao.controller;

import static java.lang.String.format;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import eus.ehu.patrondao.controller.config.ControllerConfig;
import eus.ehu.patrondao.controller.config.WebConfig;



/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static final String MAPPING_FILE = "mapping";
    public static boolean LOAD_ERROR = false;
    public static final String PATH_LOG4J = "WEB-INF/conf/log4j.properties";
    private static Logger log = Logger.getLogger(FrontController.class);
    private ServletContext context = null;
    private WebConfig webConfig = null;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.context = config.getServletContext();
		String mappingFile = null;
		String controllersProps = config.getInitParameter(MAPPING_FILE);
		mappingFile = context.getRealPath(controllersProps);
		webConfig = new WebConfig(mappingFile);
		//loadLog4j(context);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		webConfig = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) {
		

		log.info("Se pasa");
		final String servletPath = request.getServletPath();
		final String actionPath = servletPath.substring(1,
				servletPath.lastIndexOf("."));
		
		final Map<String, ControllerConfig> controllers = webConfig
				.getControllers();
		final ControllerConfig ctrConfig = controllers.get(actionPath);
		
		
		View view = null;
		if (ctrConfig != null) {
			String actionUrl = ctrConfig.getAction();

			if (actionPath.equals(actionUrl)) {
				try {
				    final IActionController controller = ctrConfig.invokeController();
				    view = controller.execute(request, response);
				    prepareModelData(request, view);
				} catch (Exception e) {
				    System.out.println(e.getMessage());
				}
				dispatchRequestToView(view, webConfig, request, response);
			    }
			} else {
			    throw new UnsupportedOperationException(format(
				    "action %s is not found in mapping file.", actionPath));
			}
		
	}

	private void dispatchRequestToView(View view,
			WebConfig webConfig2, HttpServletRequest request,
			HttpServletResponse response) {
		try {
		    String forward = view.getFoward();
		    final RequestDispatcher rd = context.getRequestDispatcher(forward);
		    rd.forward(request, response);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}

	private void prepareModelData(HttpServletRequest request,
			View view) {
		final Map<String, ?> model = view.getDatos();
		if (model != null) {
		    for (Entry<String, ?> data : model.entrySet()) {
		    	request.setAttribute(data.getKey(), data.getValue());
		    }
		}
		
	}
    private void loadLog4j(final ServletContextEvent sce) {

		try {
		    String pathReal = sce.getServletContext().getRealPath("/");
		    PropertyConfigurator.configure(pathReal + PATH_LOG4J);
		    // check configration, si no hay apender es que ha fallado
		    if (null == LogManager.exists("ACCESOS")) {
		    	LOAD_ERROR = true;
		    }
		   // log.debug("LOG cargado");
		   // log.
		} catch (Exception e) {
		    log.error(e.getMessage());
		}

    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
