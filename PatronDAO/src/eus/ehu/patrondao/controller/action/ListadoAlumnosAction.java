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
import eus.ehu.patrondao.xml.IXMLParser;

public class ListadoAlumnosAction implements IActionController {

	@Override
	public View execute(HttpServletRequest request, HttpServletResponse response)
			 {
		View vista = null;
	    DAOFactory factoria = null;
	    IAlumnoDAO daoAmlumno = null;
		List<Alumno> alumnos = null;
		
		Map<String,List<Alumno>> datos = null;
		
		factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL_ALUMNOS);
		daoAmlumno = factoria.getAlumnoDAO(DAOFactory.MYSQL_ALUMNOS);		
		try {
			datos= new HashMap<String, List<Alumno>>();
			alumnos = daoAmlumno.getAll();
			datos.put("datos", alumnos);
			vista = new View(datos, "/index.jsp");
			
		} catch (Exception e) {
			Map<String, String> mensaje = new HashMap<String, String>();
			mensaje.put("mensaje", "No se han podido recibir datos");
			//TODO logs
			//e.printStackTrace();
			vista = new View(mensaje, "/index.jsp");
		}

		//System.out.println(alumnos.size());
		
		//datos.put("mensaje", "No se puede acceder a base de datos");

		
		return vista;
	}

}
