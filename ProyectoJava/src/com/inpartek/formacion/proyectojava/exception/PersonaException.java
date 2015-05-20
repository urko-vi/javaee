package com.inpartek.formacion.proyectojava.exception;

import com.inpartek.formacion.proyectojava.pojo.Persona;

/**
 * Esta clase heredada de excepcion controla los errores en la carga de datos de
 * Persona
 *
 * @see Persona
 * @author Urko Villanueva
 *
 */
public class PersonaException extends Exception {

    /**
     *
     */
    private transient int codigo;
    private static final long serialVersionUID = 1L;
    /**
     * Codigo de error para la edad
     */
    public static final int COD_EDAD_NO_VALIDA = 0;
    /**
     * Codigo de error para la longitud de texto
     */
    public static final int COD_LONG_TEXTO_NO_VALIDA = 10;
    /**
     * Codigo de error para error en el DNI
     */
    public static final int COD_DNI_NO_VALIDO = 20;
    /**
     * Codigo de error para el EMAIL
     */
    public static final int COD_EMAIL_NO_VALIDO = 30;
    /**
     * Mensaje de texto para tamaño de texto no valido
     */
    public static final String MSG_TEXTO_NO_VALIDO = "EL TEXTO INTRODUCIDO DEBE DE TENER ALMENOS "
	    + Persona.TEXTO_LONG_MIN + " CARACTERES";
    /**
     * Mensaje de texto para el rango de edad no valida
     */
    public static final String MSG_EDAD_NO_VALIDA = "LA EDAD INTRODUCIDA DEBE DE ESTAR COMPRENDIDA ENTRE "
	    + Persona.EDAD_MIN + " Y " + Persona.EDAD_MAX;
    /**
     * Mensaje de texto para error en el DNI
     */
    public static final String MSG_DNI_NO_VALIDO = "EL TEXTO INTRODUCIDO DEBE DE CONSTAR DE 8 NUMEROS Y UNA LETRA COMO CARACTER DE CONTROL";
    /**
     * Mensaje de texto para el error del EMAIL
     */
    public static final String MSG_EMAIL_NO_VALIDA = "EL EMAIL DE CONSTAR DE UNA ID @ Y NOMBRE DE DOMINIO";

    public PersonaException() {
	super();
    }

    public PersonaException(final String message) {
	super(message);
    }

    public PersonaException(final String message, final int pcodigo) {
	super(message);
	this.codigo = pcodigo;
    }

    public PersonaException(final String message, final Throwable cause) {
	super(message, cause);
    }

    public PersonaException(final String message, final Throwable cause,
	    final boolean enableSuppression, final boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public PersonaException(final Throwable cause) {
	super(cause);
    }

    public final int getCodigo() {
	return codigo;
    }

}
