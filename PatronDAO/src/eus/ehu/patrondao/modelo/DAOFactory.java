package eus.ehu.patrondao.modelo;



import eus.ehu.patrondao.modelo.dbms.MySqlConnectionFactory;


public abstract class DAOFactory implements IConnectionFactory {
    // List of DAO types supported by the factory
    public static final int MYSQL_ALUMNOS = 1;
    public static final int ORACLE_MATRICULAS = 2;
    public static final int ACCESS = 3;
    
    public abstract IAlumnoDAO getAlumnoDAO(int whichFactory); 
    
    public static DAOFactory getDAOFactory(final int whichFactory) {
    	
		switch (whichFactory) {
			case MYSQL_ALUMNOS:
			   return MySqlConnectionFactory.getInstance();
			case ORACLE_MATRICULAS:
			    // return new OracleDAOFactory();
			case ACCESS:
			    // return new SybaseDAOFactory();
			default:
			    return null;
		}
    }
    
    
    
}
