package org.techzoo.aqsa.config;

import static java.lang.Class.forName;

import org.techzoo.aqsa.IController;

public class ControllerConfig {

    private String action;
    private String controllerClass;

    public ControllerConfig(final String action, final String controllerClass) {
    	super();
		this.action = action;
		this.controllerClass = controllerClass;
    }

    public IController invokeController() {
    	IController controller = null;
		if (controllerClass != null && !controllerClass.isEmpty()) {
		    try {
			controller = (IController) forName(controllerClass)
				.newInstance();
	
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
	return controller;
    }

    public void setAction(final String action) {
	this.action = action;
    }

    public void setControllerClass(final String controllerClass) {
	this.controllerClass = controllerClass;
    }

    public String getAction() {
	return action;
    }

    public String getControllerClass() {
	return controllerClass;
    }
}
