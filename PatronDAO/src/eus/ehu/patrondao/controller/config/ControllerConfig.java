package eus.ehu.patrondao.controller.config;

import static java.lang.Class.forName;



import eus.ehu.patrondao.controller.IActionController;

public class ControllerConfig {

	private String action;
	private String actionClass;
	
	public ControllerConfig(String action,String actionClass){
		super();
		this.setAction(action);
		this.setActionClass(actionClass);
	}
    public IActionController invokeController() {
    	IActionController accion = null;
		if (actionClass != null && !actionClass.isEmpty()) {
		    try {
		    	accion = (IActionController) forName(actionClass)
				.newInstance();
	
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
	return accion;
    }
	
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getActionClass() {
		return actionClass;
	}
	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}
}
