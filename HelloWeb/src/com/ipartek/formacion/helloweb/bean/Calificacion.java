package com.ipartek.formacion.helloweb.bean;

public class Calificacion {
    public final static int ID_NULL = -1;
    private int id;
    private String nombre;

    public Calificacion() {
	this.id = ID_NULL;
	this.nombre = "";
    }

    public Calificacion(final int id, final String nombre) {
	super();
	this.id = id;
	this.nombre = nombre;
    }

    public int getId() {
	return id;
    }

    public void setId(final int id) {
	this.id = id;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }
}
