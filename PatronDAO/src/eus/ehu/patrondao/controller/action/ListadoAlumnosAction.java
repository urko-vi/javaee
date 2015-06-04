package eus.ehu.patrondao.controller.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eus.ehu.patrondao.bean.Alumno;
import eus.ehu.patrondao.controller.IActionController;
import eus.ehu.patrondao.controller.View;
import eus.ehu.patrondao.modelo.DAOFactory;
import eus.ehu.patrondao.modelo.IAlumnoDAO;

public class ListadoAlumnosAction implements IActionController {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		View vista = null;
	    DAOFactory factoria = null;
	    IAlumnoDAO daoAmlumno = null;
		List<Alumno> alumnos = null;
		Map<String,List<Alumno>> datos = new HashMap<String, List<Alumno>>();
		factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL_ALUMNOS);
		daoAmlumno = factoria.getAlumnoDAO(DAOFactory.MYSQL_ALUMNOS);		
		alumnos = daoAmlumno.getAll();
		//System.out.println(alumnos.size());
		datos.put("datos", alumnos);
		vista = new View(datos, "/index.jsp");
		
		return vista;
	}

}
