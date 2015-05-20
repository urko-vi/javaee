package com.ipartek.formacion.inscripciones.model;

import com.ipartek.formacion.inscripciones.model.rdbms.MySqlConnectionFactory;

public abstract class DAOFactory implements IConnectionFactory {

    // List of DAO types supported by the factory
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int ACCESS = 3;

    // There will be a method for each DAO that can be
    // created. The concrete factories will have to
    // implement these methods.
    public abstract IMatriculaDAO getIMatriculaDAO(int whichFactory);

    public static DAOFactory getDAOFactory(final int whichFactory) {

	switch (whichFactory) {
	case MYSQL:
	    return MySqlConnectionFactory.getInstance();
	case ORACLE:
	    // return new OracleDAOFactory();
	case ACCESS:
	    // return new SybaseDAOFactory();
	default:
	    return null;
	}
    }

}
