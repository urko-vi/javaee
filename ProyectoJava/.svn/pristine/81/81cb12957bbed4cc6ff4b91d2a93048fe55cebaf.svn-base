package com.inpartek.formacion.proyectojava.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inpartek.formacion.proyectojava.exception.PersonaException;
import com.inpartek.formacion.proyectojava.pojo.DatoFichero;
import com.inpartek.formacion.proyectojava.pojo.Estadistica;
import com.inpartek.formacion.proyectojava.pojo.Persona;

/**
 * Es la clase que se encarga de la lectura y de la escritura
 *
 * @author Urko Villanueva
 *
 */
public final class GeneradorInforme {
    private static final String A_PATTERN = ",";

    private static final int NOMBRE_POS = 0;
    private static final int APELLIDO_POS = 1;
    private static final int POBLACION_POS = 2;
    private static final int EDAD_POS = 3;
    private static final int EMAIL_POS = 4;
    private static final int DNI_POS = 5;
    private static final int CATEGORIA_POS = 6;
    private static final int N_CAMPOS = 7;
    private static final String FILE_PATH = new File("").getAbsolutePath()
	    + System.getProperty("file.separator") + "files"
	    + System.getProperty("file.separator");
    private static final String NOMBRE_FICHERO_DATOS = "personas";
    private static final String EXTENSION_FICHERO = "txt";
    private static final String NOMBRE_FICHERO_ERROR = "personas-error";
    private static final String NOMBRE_FICHERO_DUPLICADO = "personas-repetidas";
    private static final String NOMBRE_FICHERO_VALIDO = "personas-correctas";
    private static final String NOMBRE_FICHERO_ESTADISTICAS = "estadisticas";

    private static DatoFichero fPersona;
    private static DatoFichero fError;
    private static DatoFichero fValido;
    private static DatoFichero fDuplicado;
    private static DatoFichero fEstadistica;

    private static Estadistica estadistica;
    private static HashMap<String, Persona> datosPersonas;
    private static HashMap<String, Integer> datosRepetidos;
    private static HashMap<String, Persona> datosErroneos;
    private static HashMap<String, Persona> datosCortos;
    private static List<String> errores;

    private GeneradorInforme() {
    }

    private static void init() {
	datosPersonas = new HashMap<String, Persona>();
	datosCortos = new HashMap<String, Persona>();
	errores = new ArrayList<String>();
	datosErroneos = new HashMap<String, Persona>();
	datosRepetidos = new HashMap<String, Integer>();
	estadistica = new Estadistica();
	fPersona = new DatoFichero(FILE_PATH, NOMBRE_FICHERO_DATOS,
		EXTENSION_FICHERO);
	fError = new DatoFichero(FILE_PATH, NOMBRE_FICHERO_ERROR,
		EXTENSION_FICHERO);
	fValido = new DatoFichero(FILE_PATH, NOMBRE_FICHERO_VALIDO,
		EXTENSION_FICHERO);
	fDuplicado = new DatoFichero(FILE_PATH, NOMBRE_FICHERO_DUPLICADO,
		EXTENSION_FICHERO);
	fEstadistica = new DatoFichero(FILE_PATH, NOMBRE_FICHERO_ESTADISTICAS,
		EXTENSION_FICHERO);
	estadistica.setTiempo(System.currentTimeMillis());
    }

    public static void generarMigracion() throws NumberFormatException,
	    PersonaException {
	init();
	cargarDatos();
	generarDatos();

    }

    private static void cargarDatos() throws NumberFormatException,
	    PersonaException {

	List<String> lista = null;

	Persona p = null;
	lista = ManejadorFichero.leerFichero(fPersona);

	for (String s : lista) {
	    p = toPersona(s);
	    if (p != null) {
		if (!isRepeated(p)) {
		    if (p.isTodo()) {
			datosPersonas.put(p.getDni(), p);
		    } else {
			datosCortos.put(p.getDni(), p);
		    }
		} else {
		    int cont = 1;
		    if (datosRepetidos.get(p) != null) {
			cont = datosRepetidos.get(p);
			cont++;
		    }

		    datosRepetidos.put(p.getDni(), cont);

		}
	    }
	}
	estadistica = new Estadistica(lista.size(), datosPersonas.size(),
		datosCortos.size() + datosErroneos.size() + errores.size(),
		datosRepetidos.size());
    }

    private static void gArchivoDatosFaltan() {
	final String ENCABEZADO = "PERSONAS DE LAS QUE FALTAN DATOS:";
	Persona value = null;

	ManejadorFichero.addTexttoFile(ENCABEZADO, fError);
	for (Map.Entry<String, Persona> entry : datosCortos.entrySet()) {
	    value = entry.getValue();
	    ManejadorFichero.addTexttoFile(value.toFileString(), fError);
	}
    }

    private static void gArchivoDatosInvalido() {
	final String ENCABEZADO = "PERSONAS DE LAS QUE TIENEN LOS DATOS MAL ESCRITOS:";
	Persona value = null;

	ManejadorFichero.addTexttoFile(ENCABEZADO, fError);

	for (Map.Entry<String, Persona> entry : datosErroneos.entrySet()) {
	    value = entry.getValue();
	    ManejadorFichero.addTexttoFile(value.toFileString(), fError);
	}

    }

    private static void gArchivoDniInvalido() {
	final String ENCABEZADO = "PERSONAS CON DNI MAL INTRODUCIDO (POSICIÓN O TAMAÑO INCORRECTO):";

	ManejadorFichero.addTexttoFile(ENCABEZADO, fError);

	for (String s : errores) {
	    ManejadorFichero.addTexttoFile(s, fError);
	}

    }

    private static void gDatosArchivoCorrecto() {
	Persona value = null;

	for (Map.Entry<String, Persona> entry : datosPersonas.entrySet()) {
	    value = entry.getValue();
	    ManejadorFichero.addTexttoFile(value.toFileString(), fValido);
	}

    }

    private static void gDatosArchivoDuplicado() {

	String key = null;
	Integer value = null;
	Persona p = null;

	for (Map.Entry<String, Integer> entry : datosRepetidos.entrySet()) {
	    key = entry.getKey();
	    value = entry.getValue();
	    p = datosPersonas.get(key);
	    ManejadorFichero.addTexttoFile(p.toFileString() + "\t\t\t\t\t\t"
		    + value, fDuplicado);
	}

    }

    private static void gDatosArchivoError() {
	// datos_erroneos;

	gArchivoDniInvalido();
	gArchivoDatosFaltan();
	gArchivoDatosInvalido();
    }

    private static void gDatosArchivoEstadistica() {
	final long EXP = (long) 1e6;
	long timeEnd = System.nanoTime();
	long difference = (timeEnd - estadistica.getTiempo()) / EXP;
	estadistica.setTiempo(difference);
	ManejadorFichero.addTexttoFile(
		"Registros leidos" + "\t" + estadistica.getRegLeido(),
		fEstadistica);
	ManejadorFichero.addTexttoFile(
		"Minutos Segundos" + "\t" + estadistica.calculateTime(),
		fEstadistica);
	ManejadorFichero
		.addTexttoFile(
			"Correctos" + "\t" + estadistica.getRegCorrecto(),
			fEstadistica);
	ManejadorFichero.addTexttoFile(
		"Erroneos" + "\t" + estadistica.getRegIncorrecto(),
		fEstadistica);
	ManejadorFichero.addTexttoFile(
		"Duplicados" + "\t" + estadistica.getRegduplicado(),
		fEstadistica);
    }

    private static void gEncabezadoArchivoCorrecto() {
	final String ENCABEZADO = "PERSONAS";

	ManejadorFichero.crearArchivoTexto(ENCABEZADO, fValido);
	ManejadorFichero.addTexttoFile("", fValido);
    }

    private static void gEncabezadoArchivoDuplicado() {
	final String ENCABEZADO = "PERSONA\t\t\t\t\t\t\tN VECES";

	ManejadorFichero.crearArchivoTexto(ENCABEZADO, fDuplicado);
	ManejadorFichero.addTexttoFile("", fDuplicado);
    }

    private static void gEncabezadoArchivoError() {
	final String ENCABEZADO = "PERSONAS CON ERRORES EN SUS ARCHIVOS";
	ManejadorFichero.crearArchivoTexto(ENCABEZADO, fError);
	ManejadorFichero.addTexttoFile("", fError);
    }

    private static void gEncabezadoArchivoEstadisticas() {
	final String ENCABEZADO = "ESTADISTICAS";
	ManejadorFichero.crearArchivoTexto(ENCABEZADO, fEstadistica);
	ManejadorFichero.addTexttoFile("", fEstadistica);
    }

    private static void generarDatos() {
	gEncabezadoArchivoError();
	gDatosArchivoError();
	gEncabezadoArchivoCorrecto();
	gDatosArchivoCorrecto();
	gEncabezadoArchivoDuplicado();
	gDatosArchivoDuplicado();
	gEncabezadoArchivoEstadisticas();
	gDatosArchivoEstadistica();
    }

    private static boolean isRepeated(final Persona p) {
	boolean repeated = false;
	if (datosPersonas.containsKey(p.getDni())
		|| datosErroneos.containsKey(p.getDni())) {
	    repeated = true;
	}
	return repeated;
    }

    private static Persona toPersona(final String text) throws PersonaException {

	Persona persona = null;
	String[] list = null;
	list = text.split(A_PATTERN);

	if (UtilValidacion.validarDNI(list[DNI_POS])) {
	    if (list.length == N_CAMPOS) {
		persona = validarDatos(list);
	    } else {
		persona = new Persona(list[DNI_POS]);
	    }
	} else {
	    errores.add(text);
	}

	return persona;
    }

    private static Persona validarDatos(final String[] list)
	    throws NumberFormatException, PersonaException {
	Persona p = new Persona(list[DNI_POS]);
	p.setTodo(true);
	p.setNombre(list[NOMBRE_POS]);
	p.setApellido(list[APELLIDO_POS]);
	p.setPoblacion(list[POBLACION_POS]);
	p.setCategoria(list[CATEGORIA_POS]);
	if (UtilValidacion.edadIsValid(list[EDAD_POS])) {
	    p.setEdad(Integer.parseInt(list[EDAD_POS]));
	} else {
	    p.setTodo(false);
	}
	if (UtilValidacion.validarEmail(list[EMAIL_POS])) {
	    p.setEmail(list[EMAIL_POS]);
	} else {
	    p.setTodo(false);
	}
	return p;
    }
}
