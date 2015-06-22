package eus.ehu.patrondao.main;

import java.awt.event.InputMethodListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import eus.ehu.patrondao.bean.Alumno;
import eus.ehu.patrondao.bean.Asignatura;
import eus.ehu.patrondao.xml.GenerarXML;
import eus.ehu.patrondao.xml.IXMLParser;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivo = new File("c:/alumnos.xml");
		Alumno al = new Alumno();
		List<IXMLParser> lista = null;
		lista = new ArrayList<IXMLParser>();
		
		List<IXMLParser> asignaturas = new ArrayList<IXMLParser>();
		Asignatura asig = new Asignatura();
		asignaturas.add(asig);
		
		al.setAsignaturas(asignaturas);
		lista.add(al);

		GenerarXML gen = new GenerarXML();
		gen.parseXML(lista, archivo);
		
	}

}
