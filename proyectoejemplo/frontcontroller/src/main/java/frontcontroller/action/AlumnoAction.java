package frontcontroller.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import dbms.IAlumnoDAO;
import modelo.DAOFactory;
import pojo.Alumno;
import frontcontroller.IActionController;
import frontcontroller.View;

public class AlumnoAction implements IActionController{

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
		
		datos.put("datos", alumnos);
		vista = new View("/index.jsp");
		vista.setDatos(datos);
		return vista;
	}

}
