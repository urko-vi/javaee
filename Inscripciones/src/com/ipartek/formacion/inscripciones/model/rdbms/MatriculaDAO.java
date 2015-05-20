package com.ipartek.formacion.inscripciones.model.rdbms;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.inscripciones.bean.Matricula;
import com.ipartek.formacion.inscripciones.exception.ModelException;
import com.ipartek.formacion.inscripciones.model.DAOFactory;
import com.ipartek.formacion.inscripciones.model.IConnection;
import com.ipartek.formacion.inscripciones.model.IMatriculaDAO;

public class MatriculaDAO implements IMatriculaDAO {
    private Connection connection;
    private IConnection con;
    private ResultSet rs;

    public MatriculaDAO(final int whichFactory) {
	try {
	    con = DAOFactory.getDAOFactory(whichFactory).getIConnection();
	    connection = con.getConnection();
	    con.connect();
	    rs = null;
	} catch (ModelException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    @Override
    public ArrayList<Matricula> getDataByYear(final int year)
	    throws ModelException {
	// TODO Auto-generated method stub
	ArrayList<Matricula> matriculas = null;
	CallableStatement cStmt = null;
	Matricula m = null;
	try {
	    cStmt = connection.prepareCall("{call getByYear(?)}");
	    cStmt.setInt(1, year);
	    rs = cStmt.executeQuery();
	    matriculas = new ArrayList<Matricula>();
	    while (rs.next()) {
		m = new Matricula();
		m.setId(rs.getInt(CAMPOS[0]));
		m.setNombre(rs.getString(CAMPOS[1]));
		m.setApellido(rs.getString(CAMPOS[2]));
		m.setEmail(rs.getString(CAMPOS[3]));
		m.setfUltimologin(rs.getLong(CAMPOS[4]));
		m.setfUltimoAcceso(rs.getLong(CAMPOS[5]));
		m.setfInscripcion(rs.getLong(CAMPOS[6]));
		matriculas.add(m);
		// System.out.println(rs.g);
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return matriculas;
    }
}
