package com.ipartek.formacion.inscripciones.model;

import java.util.List;

import com.ipartek.formacion.inscripciones.bean.Matricula;
import com.ipartek.formacion.inscripciones.exception.ModelException;

public interface IMatriculaDAO {
    //static final String TABLA = "user, matricula, ......";
    static final String[] CAMPOS = { "id", "firstname", "lastname", "email",
	    "lastlogin", "lastaccess", "firstaccess" };

    // id firstname lastname email lastlogin lastaccess
    public List<Matricula> getDataByYear(final int year)
	    throws ModelException;
    public Matricula getMatriculaById(final int id)
    	    throws ModelException;

}
