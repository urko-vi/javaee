package eus.ehu.patrondao.modelo;

import java.sql.Connection;

public interface IConnection {

	public void connect();
	public void disconnect();
	public Connection getConnection();
}
