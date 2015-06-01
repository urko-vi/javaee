package eus.ehu.patrondao.bean;

import eus.ehu.patrondao.modelo.dbms.MySqlConnection;

public class Alumno {
	public  static final int CODIGO_ALUMNO = -1;
	private int id;
	private String nombre;
	
	public Alumno() {
		super();
		this.id = Alumno.CODIGO_ALUMNO;
		this.setNombre("");
	}
	public Alumno(int id, String nombre) {
		super();
		this.id = id;
		this.setNombre(nombre);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	MySqlConnection sql = MySqlConnection.getInstance();
	
	
	

}
