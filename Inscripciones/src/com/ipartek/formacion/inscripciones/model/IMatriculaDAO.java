package com.ipartek.formacion.inscripciones.model;

import java.util.ArrayList;

import com.ipartek.formacion.inscripciones.bean.Matricula;
import com.ipartek.formacion.inscripciones.exception.ModelException;

public interface IMatriculaDAO {
    static final String TABLA = "user";
    static final String[] CAMPOS = { "id", "firstname", "lastname", "email",
	    "lastlogin", "lastaccess", "firstaccess" };

    // id firstname lastname email lastlogin lastaccess
    public ArrayList<Matricula> getDataByYear(final int year)
	    throws ModelException;

}
