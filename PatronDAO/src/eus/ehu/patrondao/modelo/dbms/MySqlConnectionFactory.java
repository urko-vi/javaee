package eus.ehu.patrondao.modelo.dbms;


import eus.ehu.patrondao.modelo.DAOFactory;
import eus.ehu.patrondao.modelo.IAlumnoDAO;
import eus.ehu.patrondao.modelo.IConnection;
import eus.ehu.patrondao.modelo.IConnectionFactory;

public class MySqlConnectionFactory extends DAOFactory implements IConnectionFactory{

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
		return MySqlConnection.getInstance();
	}

	@Override
	public IAlumnoDAO getAlumnoDAO(int whichFactory) {
		return AlumnoDAO.getInstance(whichFactory);
	}




}
