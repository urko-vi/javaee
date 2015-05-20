package com.inpartek.formacion.proyectojava.pojo;

import com.inpartek.formacion.proyectojava.exception.PersonaException;
import com.inpartek.formacion.proyectojava.util.UtilValidacion;

/**
 * Clase que agrupa los datos de la personas y sus metodos
 *
 * @author Urko Villanueva
 *
 */
public class Persona {

    private String nombre;
    private String apellido;
    private String poblacion;
    private int edad;
    private String email;
    private String dni;
    private String categoria;
    private boolean todo;
    /**
     * La edad máxima admitida para una persona
     */
    public final static int EDAD_MAX = 99;
    /**
     * la edad minima admitida para una persona
     */
    public final static int EDAD_MIN = 18;
    /**
     * la longitud minima de caracteres para un texto
     */
    public final static int TEXTO_LONG_MIN = 2;

    public Persona(final String pdni) throws PersonaException {
	super();
	setDni(pdni);
	this.todo = false;
    }

    public Persona(final String pnombre, final String papellido,
	    final String ppoblacion, final int pedad, final String pemail,
	    final String pdni, final String pcategoria) throws PersonaException {
	super();
	setNombre(pnombre);
	setApellido(papellido);
	setPoblacion(ppoblacion);
	setEdad(pedad);
	setEmail(pemail);
	setDni(pdni);
	setCategoria(pcategoria);
	setTodo(true);
    }

    public final String getApellido() {
	return apellido;
    }

    public final String getCategoria() {
	return categoria;
    }

    public final String getDni() {
	return dni;
    }

    public final int getEdad() {
	return edad;
    }

    public final String getEmail() {
	return email;
    }

    public final String getNombre() {
	return nombre;
    }

    public final String getPoblacion() {
	return poblacion;
    }

    public final boolean isTodo() {
	return todo;
    }

    public final void setApellido(final String papellido)
	    throws PersonaException {
	if (papellido != null && papellido.length() >= Persona.TEXTO_LONG_MIN) {
	    this.apellido = papellido;
	} else {
	    this.todo = false;
	    throw new PersonaException(PersonaException.MSG_TEXTO_NO_VALIDO,
		    PersonaException.COD_LONG_TEXTO_NO_VALIDA);
	}
    }

    public final void setCategoria(final String pcategoria)
	    throws PersonaException {
	if (pcategoria != null && pcategoria.length() >= Persona.TEXTO_LONG_MIN) {
	    this.categoria = pcategoria;
	} else {
	    this.todo = false;
	    throw new PersonaException(PersonaException.MSG_TEXTO_NO_VALIDO,
		    PersonaException.COD_LONG_TEXTO_NO_VALIDA);
	}

    }

    public final void setDni(final String pdni) throws PersonaException {
	if (UtilValidacion.validarDNI(pdni)) {
	    this.dni = pdni;
	} else {
	    this.todo = false;
	    throw new PersonaException(PersonaException.MSG_DNI_NO_VALIDO,
		    PersonaException.COD_DNI_NO_VALIDO);
	}
    }

    public final void setEdad(final int pedad) throws PersonaException {
	if (UtilValidacion.edadValidRange(pedad)) {
	    this.edad = pedad;
	} else {
	    this.todo = false;
	    throw new PersonaException(PersonaException.MSG_EDAD_NO_VALIDA,
		    PersonaException.COD_EDAD_NO_VALIDA);
	}
    }

    public final void setEmail(final String pemail) throws PersonaException {
	if (UtilValidacion.validarEmail(pemail)) {
	    this.email = pemail;
	} else {
	    this.todo = false;
	    throw new PersonaException(PersonaException.MSG_EMAIL_NO_VALIDA,
		    PersonaException.COD_EMAIL_NO_VALIDO);
	}
    }

    public final void setNombre(final String pnombre) throws PersonaException {
	if (pnombre != null && pnombre.length() >= Persona.TEXTO_LONG_MIN) {
	    this.nombre = pnombre;
	} else {
	    this.todo = false;
	    throw new PersonaException(PersonaException.MSG_TEXTO_NO_VALIDO,
		    PersonaException.COD_LONG_TEXTO_NO_VALIDA);
	}
    }

    public final void setPoblacion(final String ppoblacion)
	    throws PersonaException {
	if (ppoblacion != null && ppoblacion.length() >= Persona.TEXTO_LONG_MIN) {
	    this.poblacion = ppoblacion;
	} else {
	    this.todo = false;
	    throw new PersonaException(PersonaException.MSG_TEXTO_NO_VALIDO,
		    PersonaException.COD_LONG_TEXTO_NO_VALIDA);
	}
    }

    public final void setTodo(final boolean ptodo) {
	this.todo = ptodo;
    }

    public final String toFileString() {

	return this.dni + " " + this.nombre + " " + this.apellido + " "
		+ this.edad + " " + this.email + " " + this.poblacion + " "
		+ this.categoria;
    }
}
