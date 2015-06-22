package eus.ehu.patrondao.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import eus.ehu.patrondao.xml.IXMLParser;

@XmlRootElement(name = "alumno")
@XmlType(propOrder = {"id", "nombre","asignatura"})
public class Alumno implements IXMLParser, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int CODIGO_ALUMNO = -1;
	private int id;
	private String nombre;
	private List<Asignatura>asignaturas;

	public Alumno() {
		super();
		this.id = Alumno.CODIGO_ALUMNO;
		this.setNombre("");
		this.asignaturas = new ArrayList<Asignatura>();
	}

	public Alumno(final int id, final String nombre) {
		super();
		this.id = id;
		this.setNombre(nombre);
		this.asignaturas = new ArrayList<Asignatura>();

	}

	@Override
	public boolean equals(final Object obj) {
		boolean igual = false;
		if (obj instanceof Alumno) {
			final Alumno al = (Alumno) obj;
			if (al.getId() == this.id) {
				igual = true;
			}
		}

		return igual;
	}

	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;

	}
	
	@XmlElement(name = "asignatura")
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<? extends IXMLParser> asignaturas) {
		this.asignaturas = (List<Asignatura>) asignaturas;
	}

	
}
