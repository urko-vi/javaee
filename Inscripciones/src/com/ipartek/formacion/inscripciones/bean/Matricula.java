package com.ipartek.formacion.inscripciones.bean;

public class Matricula {

    private int id;
    private long fInscripcion;
    private String nombre;
    private String apellido;
    private String email;
    private long fUltimoAcceso;
    private long fUltimologin;
    public static final int COD_MATRICULA_ID = -1;
    
    public Matricula() {
    	super();
		this.id = Matricula.COD_MATRICULA_ID;
    }

    public int getId() {
    	return id;
    }

    public void setId(final int id) {
	this.id = id;
    }

    public long getfInscripcion() {
	return fInscripcion;
    }

    public void setfInscripcion(final long fInscripcion) {
	this.fInscripcion = fInscripcion;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

    public String getApellido() {
	return apellido;
    }

    public void setApellido(final String apellido) {
	this.apellido = apellido;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(final String email) {
	this.email = email;
    }

    public long getfUltimoAcceso() {
	return fUltimoAcceso;
    }

    public void setfUltimoAcceso(final long fUltimoAcceso) {
	this.fUltimoAcceso = fUltimoAcceso;
    }

    public long getfUltimologin() {
	return fUltimologin;
    }

    public void setfUltimologin(final long fUltimologin) {
	this.fUltimologin = fUltimologin;
    }

}
