package eus.ehu.patrondao.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlRootElement(name = "alumno")
@XmlType(propOrder = {"id", "nombre","asinaturas"})
public class AlumnoXML {
	public static final int CODIGO_ALUMNO = -1;
	private int id;
	private String nombre;
	private List<AsignaturaXML>asignaturas;

	public AlumnoXML() {
		super();
		this.id = Alumno.CODIGO_ALUMNO;
		this.setNombre("");
		this.asignaturas = new ArrayList<AsignaturaXML>();
	}

	public AlumnoXML(final int id, final String nombre) {
		super();
		this.id = id;
		this.setNombre(nombre);
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
	@XmlElement(name = "asignaturas")
	public List<AsignaturaXML> getAsignaturasXML() {
		return asignaturas;
	}

	public void setAsignaturasXML(List<AsignaturaXML> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	@XmlRootElement(name = "asignatura")
	@XmlType(propOrder = {"id", "nombre"})
	public class AsignaturaXML {
		private int codigo;
		private String nombre;
		
		public AsignaturaXML() {
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

}
