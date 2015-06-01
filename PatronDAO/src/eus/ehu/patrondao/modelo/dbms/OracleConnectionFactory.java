package eus.ehu.patrondao.modelo.dbms;

import eus.ehu.patrondao.modelo.DAOFactory;
import eus.ehu.patrondao.modelo.IAlumnoDAO;
import eus.ehu.patrondao.modelo.IConnection;
import eus.ehu.patrondao.modelo.IConnectionFactory;

public class OracleConnectionFactory extends DAOFactory implements IConnectionFactory{

	@Override
	public IConnection getIConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAlumnoDAO getAlumnoDAO(int whichFactory) {
		// TODO Auto-generated method stub
		return null;
	}

}
