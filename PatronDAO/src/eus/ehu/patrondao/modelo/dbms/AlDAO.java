package eus.ehu.patrondao.modelo.dbms;

import java.util.ArrayList;
import java.util.List;

import eus.ehu.patrondao.bean.Alumno;
import eus.ehu.patrondao.modelo.IAlumnoDAO;
import eus.ehu.patrondao.xml.IXMLParser;

public class AlDAO implements IAlumnoDAO {
	private Alumno al;
	private final List<Alumno> alumnos;

	public AlDAO() {
		this.alumnos = new ArrayList<Alumno>();
		for (int i = 0; i < 5; i++) {
			this.al = new Alumno();
			this.al.setId(i);
			this.al.setNombre("Juan" + i);
			this.alumnos.add(this.al);
		}
	}

	@Override
	public void deleteById(final int id) {
		for (final IXMLParser al : this.alumnos) {
			Alumno alum = (Alumno) al;
			if (alum.getId() == id) {
				this.alumnos.remove(al);
			}
		}

	}

	@Override
	public List<Alumno> getAll() throws Exception {
		// TODO Auto-generated method stub
		return this.alumnos;
	}

	@Override
	public Alumno getById(final int id) {
		Alumno res = null;
		for (final IXMLParser al : this.alumnos) {
			Alumno alum = (Alumno) al;

			if (alum.getId() == id) {
				res = alum;
			}
		}
		return res;
	}

	@Override
	public Alumno updateAlumno(final Alumno alumno) {
		Alumno alum = null;
		for (final IXMLParser al : this.alumnos) {
			alum = (Alumno) al;
			if (alum.equals(alumno)) {
				this.deleteById(alum.getId());
				this.alumnos.add(alum);
			}
		}
		return alum;
	}

}
