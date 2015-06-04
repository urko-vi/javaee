package eus.ehu.patrondao.controller;

import java.util.Map;

public class View {
	private Map <String,?> datos;
	private String foward;
	
	public View(String foward) {
		super();
		this.setFoward(foward);
	}
	public View(Map<String, ?> datos, String foward) {
		super();
		this.setFoward(foward);
		if(datos!=null){
			this.setDatos(datos);
		}
		
	}
	public void clean(){
		this.datos = null;
	}
	public Map<String, ?> getDatos() {
		return datos;
	}
	public void setDatos(Map<String, ?> datos) {
		this.datos = datos;
	}
	public String getFoward() {
		return foward;
	}
	public void setFoward(String foward) {
		this.foward = foward;
	}
	
	
	
	
	
	
}
