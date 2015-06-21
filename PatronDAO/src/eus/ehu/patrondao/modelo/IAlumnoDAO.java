package eus.ehu.patrondao.modelo;

import java.util.List;

import eus.ehu.patrondao.bean.Alumno;
import eus.ehu.patrondao.xml.IXMLParser;

public interface IAlumnoDAO {
	public Alumno getById(int id) ;
	public List<IXMLParser> getAll()  throws Exception;
	public void deleteById(int id) ;
	public Alumno updateAlumno(Alumno al);
}
