package com.inpartek.formacion.proyectojava.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.inpartek.formacion.proyectojava.pojo.Persona;

//TODO implementar las validaciones en la clase Persona
public final class UtilValidacion {

    private final static String DNI_PATTERN = "(\\d{1,8})([A-Z])";
    private final static String NUMBER_PATTERN = "^\\d+$";
    private final static String EMAIL_PATTERN = "^[\\w\\.=-]+@[\\w\\.-]+\\.[\\w]{2,3}$";

    private UtilValidacion() {
    }

    /**
     * Valida si las edad del fichero cumple las normas de intervalos y que sea
     * numero
     *
     * @param pedad
     *            {@code String} la edad en texto
     * @return
     */
    public static boolean edadIsValid(final String pedad) {
	boolean exito = false;
	if (isNumber(pedad)) {
	    int edad = Integer.parseInt(pedad);
	    exito = edadValidRange(edad);
	}
	return exito;
    }

    /**
     * Comprueba que lad
     *
     * @param edad
     *            {@code int} la edad a validar en rango
     * @return
     */
    public static boolean edadValidRange(final int edad) {
	boolean exito = false;
	if (edad <= Persona.EDAD_MAX && edad >= Persona.EDAD_MIN) {
	    exito = true;
	}
	return exito;
    }

    /**
     * Función que valida si un texto introducido es un numero entero
     *
     * @param number
     *            {@code String} el numero a validar
     *
     * @return {@code boolean} si es cierto o no
     */
    public static boolean isNumber(final String number) {
	boolean exito = false;
	Pattern edadPattern = Pattern.compile(NUMBER_PATTERN);
	Matcher m = edadPattern.matcher(number);

	if (m.matches()) {
	    exito = true;
	}
	return exito;
    }

    /**
     * Funcion que valida el dni que se envia tiene el formato adecuado 8
     * numeros y una letra
     *
     * @param dni
     *            {@code String} el DNI a validar
     * @return {@code boolean} si es correcto o incorrecto
     */
    public static boolean validarDNI(final String dni) {
	final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";
	int nDni;
	String letra = null;
	String reference = null;
	boolean valido = false;
	Pattern dniPattern = null;
	Matcher m = null;
	dniPattern = Pattern.compile(DNI_PATTERN);
	m = dniPattern.matcher(dni.toUpperCase());

	if (m.matches()) {
	    letra = m.group(2);

	    nDni = Integer.parseInt(m.group(1));
	    // System.out.println(nDni);
	    nDni = nDni % LETRAS.length();

	    reference = LETRAS.substring(nDni, nDni + 1);
	    // System.out.println(reference + "-" + letra);
	    if (reference.equalsIgnoreCase(letra)) {
		valido = true;
	    }
	}

	return valido;
    }

    /***
     * Funcion que valida si el email tiene un formato valido
     *
     * @param email
     *            {@code String} la cadena de texto a validar
     * @return {@code boolean} si tiene un formato valido o no
     */
    public static boolean validarEmail(final String email) {
	boolean valido = false;
	Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
	Matcher m = emailPattern.matcher(email);

	if (m.matches()) {
	    valido = true;
	}
	return valido;
    }
}
