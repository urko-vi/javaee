package connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import modelo.IConnection;

public class MySqlConnection implements IConnection{
	private static Connection connection = null;
    private static MySqlConnection INSTANCE = null;
    private static final String DATA_SOURCE = "java:comp/env/jdbc/Alumnos";
	
    private MySqlConnection(){
    	if(INSTANCE == null){
    		connect();
    	}
    }
    // creador sincronizado para protegerse de posibles problemas multi-hilo
    // otra prueba para evitar instanciaciÃ³n mÃºltiple
    private synchronized static void createInstance() {
		if (connection == null) {
		    INSTANCE = new MySqlConnection();
		}
    }

    public static MySqlConnection getInstance()  {
		if (connection == null) {
		    createInstance();
		}
		return INSTANCE;
    }
    
    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
	public Object clone() throws CloneNotSupportedException {
	    	throw new CloneNotSupportedException(); 
	}
	@Override
	public void connect() {
		if(connection == null){
			try {
				InitialContext ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup(DATA_SOURCE);
				connection = ds.getConnection();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void disconnect() {
		if(connection!=null){
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return connection;
	}

}
