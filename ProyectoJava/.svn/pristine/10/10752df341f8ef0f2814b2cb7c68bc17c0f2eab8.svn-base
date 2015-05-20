package com.inpartek.formacion.proyectojava.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.inpartek.formacion.proyectojava.pojo.DatoFichero;

public final class ManejadorFichero {

    private ManejadorFichero() {
    }

    /**
     *
     * @param content
     * @param dato
     */
    public static void addTexttoFile(final String content,
	    final DatoFichero dato) {
	File fichero = new File(dato.getFilePath() + dato.getFileName() + "."
		+ dato.getFileExt());
	if (!fichero.exists()) {
	    try {
		fichero.createNewFile();
	    } catch (IOException e) {
		Logger.getLogger(e.getMessage());
		// e.printStackTrace();
	    }
	}
	PrintWriter out = null;
	try {
	    out = new PrintWriter(new BufferedWriter(new FileWriter(
		    fichero.getAbsoluteFile(), true)));
	    out.println("\n" + content);
	} catch (IOException e) {
	    Logger.getLogger(e.getMessage());
	} finally {
	    if (out != null) {
		out.close();
	    }
	}

    }

    /**
     *
     * @param content
     * @param dato
     */
    public static void crearArchivoTexto(final String content,
	    final DatoFichero dato) {
	File fichero = new File(dato.getFilePath() + dato.getFileName() + "."
		+ dato.getFileExt());
	FileOutputStream fos = null;
	Writer out = null;

	if (!fichero.exists()) {
	    try {
		fichero.createNewFile();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	try {
	    fos = new FileOutputStream(fichero);
	    out = new OutputStreamWriter(fos, "UTF8");
	    out.write(content);
	} catch (FileNotFoundException e) {
	    // e.printStackTrace();
	    Logger.getLogger(e.getMessage());
	} catch (UnsupportedEncodingException e) {
	    // e.printStackTrace();
	    Logger.getLogger(e.getMessage());
	} catch (IOException e) {
	    // e.printStackTrace();
	    Logger.getLogger(e.getMessage());
	} finally {
	    try {
		out.close();
	    } catch (IOException e) {
		// e.printStackTrace();
		Logger.getLogger(e.getMessage());
	    }
	}
    }

    public static List<String> leerFichero(final DatoFichero dato) {
	File fichero = null;
	List<String> list = null;
	FileReader fr = null;
	BufferedReader br = null;
	try {
	    fichero = new File(dato.getFilePath() + dato.getFileName() + "."
		    + dato.getFileExt());
	    fr = new FileReader(fichero);
	    list = new ArrayList<String>();
	    String linea = null;

	    while ((linea = br.readLine()) != null) {
		// sb.append(linea + ";");
		list.add(linea);
	    }
	} catch (Exception e) {
	    // e.printStackTrace();
	    Logger.getLogger(e.getMessage());
	} finally {
	    try {
		if (null != fr) {
		    fr.close();
		}
	    } catch (IOException e) {
		// e.printStackTrace();
		Logger.getLogger(e.getMessage());
	    }
	}

	return list;
    }

}
