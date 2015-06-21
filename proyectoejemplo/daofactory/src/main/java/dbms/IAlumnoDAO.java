package dbms;

import java.util.List;

import pojo.Alumno;

public interface IAlumnoDAO {
	public Alumno getById(int id) ;
	public List<Alumno> getAll()  throws Exception;
	public void deleteById(int id) ;
	public Alumno updateAlumno(Alumno al);
}
