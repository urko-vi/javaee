package eus.ehu.patrondao.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eus.ehu.patrondao.bean.Alumno;
import eus.ehu.patrondao.modelo.DAOFactory;
import eus.ehu.patrondao.modelo.IAlumnoDAO;

/**
 * Servlet implementation class ServletAlumnos
 */
public class ServletAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAlumnos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    DAOFactory factoria = null;
	    IAlumnoDAO daoAmlumno = null;
		factoria = DAOFactory.getDAOFactory(DAOFactory.MYSQL_ALUMNOS);
		daoAmlumno = factoria.getAlumnoDAO(DAOFactory.MYSQL_ALUMNOS);
		List<Alumno> alumnos = daoAmlumno.getAll();
		
		for(Alumno al: alumnos){
			System.out.println("Id:"+ al.getId() +" Nombre: "+al.getNombre() );
		}
	}

}
