package com.ipartek.formacion.inscripciones.model.rdbms;

import com.ipartek.formacion.inscripciones.exception.ModelException;
import com.ipartek.formacion.inscripciones.model.DAOFactory;
import com.ipartek.formacion.inscripciones.model.IConnection;
import com.ipartek.formacion.inscripciones.model.IConnectionFactory;
import com.ipartek.formacion.inscripciones.model.IMatriculaDAO;

public class MySqlConnectionFactory extends DAOFactory implements
	IConnectionFactory {
    private static MySqlConnectionFactory INSTANCE = null;

    private MySqlConnectionFactory() {
    }

    // creador sincronizado para protegerse de posibles problemas multi-hilo
    // otra prueba para evitar instanciación múltiple
    private synchronized static void createInstance() {
		if (INSTANCE == null) {
		    INSTANCE = new MySqlConnectionFactory();
		}
    }

    public static MySqlConnectionFactory getInstance() {
		if (INSTANCE == null) {
		    createInstance();
		}
		return INSTANCE;
    }

    @Override
    public IConnection getIConnection() throws ModelException {
	// MySqlConnection mysqlCon = MySqlConnection.getInstance();
	// mysqlCon.connect();
    	return MySqlConnection.getInstance();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
	throw new CloneNotSupportedException();
    }

    @Override
    public IMatriculaDAO getIMatriculaDAO(final int whichFactory) {
	// TODO Auto-generated method stub
    	return new MatriculaDAO(whichFactory);
    }

}
