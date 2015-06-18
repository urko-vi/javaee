package eus.ehu.patrondao.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "asignatura")
@XmlType(propOrder = {"id", "nombre"})
public class Asignatura {
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
