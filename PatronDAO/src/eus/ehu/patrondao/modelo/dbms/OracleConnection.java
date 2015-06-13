package eus.ehu.patrondao.modelo.dbms;

import java.sql.Connection;

import eus.ehu.patrondao.modelo.IConnection;

public class OracleConnection implements IConnection{

	@Override
	public void connect() {
		// programar conexion Oracle
		
	}

	@Override
	public void disconnect() {
		// TODO programar desconexion Oracle
		
	}

	@Override
	public Connection getConnection() {
		// TODO Obtener la conexion
		return null;
	}

}
