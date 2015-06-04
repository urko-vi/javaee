package eus.ehu.patrondao.controller;

import static java.lang.String.format;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import eus.ehu.patrondao.controller.config.ControllerConfig;
import eus.ehu.patrondao.controller.config.WebConfig;



/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static final String MAPPING_FILE = "mapping";

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

	private void dispatchRequestToView(eus.ehu.patrondao.controller.View view,
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
			eus.ehu.patrondao.controller.View view) {
		final Map<String, ?> model = view.getDatos();
		if (model != null) {
		    for (Entry<String, ?> data : model.entrySet()) {
		    	request.setAttribute(data.getKey(), data.getValue());
		    }
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
