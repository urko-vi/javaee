package com.ipartek.formacion.inscripciones.model;

import com.ipartek.formacion.inscripciones.model.rdbms.MySqlConnectionFactory;

public abstract class DAOFactory implements IConnectionFactory {

    // List of DAO types supported by the factory
    public static final int ORACLE_MATRICULAS = 1;
    public static final int ORACLE_ALUMNOS = 2;
    public static final int ACCESS = 3;
    public static final int ORACLE_CLASE = 4;

    // There will be a method for each DAO that can be
    // created. The concrete factories will have to
    // implement these methods.
    
    public abstract IMatriculaDAO getIMatriculaDAO(final int whichFactory);
    
    public static DAOFactory getDAOFactory(final int whichFactory) {
    	
		switch (whichFactory) {
			case ORACLE_MATRICULAS:
			    return MySqlConnectionFactory.getInstance();
			case ORACLE_ALUMNOS:
			    // return new OracleDAOFactory();
			case ACCESS:
			    // return new SybaseDAOFactory();
			default:
			    return null;
		}
    }

}
