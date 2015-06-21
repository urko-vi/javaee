package eus.ehu.patrondao.controller.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eus.ehu.patrondao.bean.Alumno;
import eus.ehu.patrondao.controller.IActionController;
import eus.ehu.patrondao.controller.View;
import eus.ehu.patrondao.modelo.DAOFactory;
import eus.ehu.patrondao.modelo.IAlumnoDAO;
import eus.ehu.patrondao.modelo.dbms.AlumnoDAO;
import eus.ehu.patrondao.util.Constantes;
import eus.ehu.patrondao.xml.GenerarXML;
import eus.ehu.patrondao.xml.IXMLParser;

public class GenerarXMLAction implements IActionController {

	@Override
	public View execute(final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		View vista = null;
		// Recoger parametros para conocer que XML genera
		String tipo = (String) request.getAttribute(Constantes.PARAMETRO_XML);
		//comparamos el valor del tipo
		if(Constantes.XML_ALUMNOS.equals(tipo)){
			generateXMLAlumno();

		}

		
		// Validaer XML
		
		
		return vista;
	}

	/**
	 * @param factory
	 * @throws Exception
	 */
	private void generateXMLAlumno()  {
		// llamar a la clase Generar XML
		GenerarXML xmlgenerator;
		// llamar a la base de datos
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL_ALUMNOS);

		File archivo = new File("");
		IAlumnoDAO alumnoDAO = factory.getAlumnoDAO(DAOFactory.MYSQL_ALUMNOS);
		List<IXMLParser> alumnos;
		try {
			alumnos = alumnoDAO.getAll();
			xmlgenerator = new GenerarXML();
			xmlgenerator.parseXML(alumnos, archivo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
