package eus.ehu.patrondao.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import eus.ehu.patrondao.xml.IXMLParser;

@XmlRootElement(name = "asignatura")
@XmlType(propOrder = {"codigo", "nombre"})
public class Asignatura implements IXMLParser{
	private int codigo;
	private String nombre;
	
	public Asignatura() {
		super();
	}
	@XmlAttribute
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	@XmlElement(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
