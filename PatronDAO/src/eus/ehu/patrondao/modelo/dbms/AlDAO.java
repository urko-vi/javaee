package eus.ehu.patrondao.modelo.dbms;

import java.util.ArrayList;
import java.util.List;

import eus.ehu.patrondao.bean.Alumno;
import eus.ehu.patrondao.modelo.IAlumnoDAO;

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
		for (final Alumno al : this.alumnos) {
			if (al.getId() == id) {
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
		Alumno alum = null;
		for (final Alumno al : this.alumnos) {
			if (al.getId() == id) {
				alum = al;
			}
		}
		return alum;
	}

	@Override
	public Alumno updateAlumno(final Alumno alum) {
		for (final Alumno al : this.alumnos) {
			if (al.equals(alum)) {
				this.deleteById(alum.getId());
				this.alumnos.add(alum);
			}
		}
		return null;
	}

}
