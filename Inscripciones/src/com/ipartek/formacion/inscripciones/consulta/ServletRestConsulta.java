package com.ipartek.formacion.inscripciones.consulta;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ipartek.formacion.inscripciones.bean.Matricula;
import com.ipartek.formacion.inscripciones.model.DAOFactory;
import com.ipartek.formacion.inscripciones.model.IMatriculaDAO;

/**
 * Servlet implementation class ServletRestConsulta
 */
public class ServletRestConsulta extends HttpServlet {
    private static final long serialVersionUID = 1L;

    DAOFactory factoria = null;
    IMatriculaDAO daoMaticula = null;

    /**
     * @see Servlet#init(ServletConfig)
     */
    @Override
    public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		factoria = DAOFactory.getDAOFactory(DAOFactory.ORACLE_ALUMNOS);
		daoMaticula = factoria.getIMatriculaDAO(DAOFactory.ORACLE_ALUMNOS);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {
	// response.setContentType("application/json");
	response.setContentType("application/json; charset=utf8");
	String yr = "";
	String jsonText = "";
	boolean error = true;
	String sError = "Fallo del servidor";
	PrintWriter out = response.getWriter();
	List<Matricula> matriculas = null;
	Gson gson = new Gson();

	try {
	    yr = request.getParameter("year");
	    if (yr != null) {
		if (yr.trim().length() == 4) {
		    error = false;
		    int year = Integer.parseInt(yr);
		    matriculas = daoMaticula.getDataByYear(year);
		    Type listOfTestObject = new TypeToken<List<Matricula>>() {
		    }.getType();
		    jsonText = gson.toJson(matriculas, listOfTestObject);
		} else {
		    sError = "Fallo en la introducción del año";
		}
	    }
	    if (error) {
		jsonText = "{\"response\":500, \"msg\":\"" + sError + "\"}";
	    }/*
	      * else { jsonText = jsonText ; }
	      */
	} catch (IllegalArgumentException e) {
	    jsonText = "{\"response\":500 \"msg\":\"" + sError + e.getMessage()
		    + "\"}";
	} catch (Exception e) {
	    jsonText = "{\"response\":500 \"msg\":\"" + sError + "\"}";
	} finally {
	    out.print(jsonText);
	    out.flush();
	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(final HttpServletRequest request,
	    final HttpServletResponse response) throws ServletException,
	    IOException {
	doGet(request, response);
    }

}
