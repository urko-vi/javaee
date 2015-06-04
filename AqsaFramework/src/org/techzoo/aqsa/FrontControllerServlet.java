package org.techzoo.aqsa;

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

import org.techzoo.aqsa.config.ControllerConfig;
import org.techzoo.aqsa.config.WebConfig;

final public class FrontControllerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String MAPPING_FILE = "mapping";

    private ServletContext context;
    private WebConfig webConfig = null;

    @Override
    public void init(final ServletConfig config) throws ServletException {
	super.init(config);
	this.context = config.getServletContext();
	String mappingFile = null;
	String controllersProps = config.getInitParameter(MAPPING_FILE);
	mappingFile = context.getRealPath(controllersProps);
	webConfig = new WebConfig(mappingFile);
    }

    @Override
    protected void doGet(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {
	doProcess(request, response);
    }

    @Override
    protected void doPost(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {
	doProcess(request, response);
    }

    private void doProcess(final HttpServletRequest request,
	    final HttpServletResponse response) {
	final String servletPath = request.getServletPath();
	final String actionPath = servletPath.substring(1,
		servletPath.lastIndexOf("."));
	final Map<String, ControllerConfig> controllers = webConfig
		.getControllers();
	final ControllerConfig ctrConfig = controllers.get(actionPath);

	View view = null;
	if (ctrConfig != null) {
	    String actionUrl = ctrConfig.getAction();
	    System.out.println(actionUrl);
	    if (actionPath.equals(actionUrl)) {
		try {
		    final IController controller = ctrConfig.invokeController();
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

    private void dispatchRequestToView(final View view,
	    final WebConfig webConfig, final HttpServletRequest request,
	    final HttpServletResponse response) {
	try {
	    String forward = view.getForward();
	    final RequestDispatcher rd = context.getRequestDispatcher(forward);
	    rd.forward(request, response);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    private void prepareModelData(final HttpServletRequest request,
	    final View view) {
	final Map<String, ?> model = view.getModel();
	if (model != null) {
	    for (Entry<String, ?> data : model.entrySet()) {
		request.setAttribute(data.getKey(), data.getValue());
	    }
	}
    }
}