package connection;

import dbms.AlumnoDAO;
import dbms.IAlumnoDAO;
import modelo.DAOFactory;
import modelo.IConnection;


public class MySqlConnectionFactory extends DAOFactory {

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

    public Object clone() throws CloneNotSupportedException {
    	throw new CloneNotSupportedException();
    }
	@Override
	public IConnection getIConnection() {
		// TODO Auto-generated method stub
		return MySqlConnection.getInstance();
	}
	@Override
	public IAlumnoDAO getAlumnoDAO(int whichFactory) {
		// TODO Auto-generated method stub
		return AlumnoDAO.getInstance(whichFactory);
	}

}
