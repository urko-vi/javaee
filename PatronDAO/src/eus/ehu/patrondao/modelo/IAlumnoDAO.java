package eus.ehu.patrondao.modelo;

import java.util.List;

import eus.ehu.patrondao.bean.Alumno;

public interface IAlumnoDAO {
	public Alumno getById(int id);
	public List<Alumno> getAll();
	public void deleteById(int id);
	public Alumno updateAlumno(Alumno al);
}
