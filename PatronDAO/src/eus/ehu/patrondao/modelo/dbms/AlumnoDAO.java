package eus.ehu.patrondao.modelo.dbms;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.util.ArrayList;
import java.util.List;









import eus.ehu.patrondao.bean.Alumno;
import eus.ehu.patrondao.modelo.DAOFactory;
import eus.ehu.patrondao.modelo.IAlumnoDAO;
import eus.ehu.patrondao.modelo.IConnection;

public class AlumnoDAO implements IAlumnoDAO{
	private Connection conection;
    private IConnection con;
    private ResultSet rs;
    private static AlumnoDAO INSTANCE = null;
    
    // Private constructor suppresses 
    private AlumnoDAO(int whichFactory){
    	con = DAOFactory.getDAOFactory(whichFactory).getIConnection();
    	conection = con.getConnection();
    	con.connect();
    }
 
    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance(int whichFactory) {
        if (INSTANCE == null) { 
            INSTANCE = new AlumnoDAO(whichFactory);
        }
    }
 
    public static AlumnoDAO getInstance(int whichFactory) {
        if (INSTANCE == null) createInstance(whichFactory);
        return INSTANCE;
    }
    
    
	@Override
	public Alumno getById(int id)  {
		Alumno al = null;
		CallableStatement cStmt = null;
		

			try {
				cStmt = conection.prepareCall("{call getById(?)}");
				//cStmt = conection.prepareCall("{call getById(?,?)}"); PARA ORACLE
				cStmt.setInt(1, id);
				//cStmt.registerOutParameter(2, OracleTypes.CURSOR); PARA ORACLE
				
			   rs= cStmt.executeQuery(); //PARA SELECT
			    //int i = cStmt.executeUpdate(); para UPDATE, INSERT; DELETE
			    
			    //rs = (ResultSet) callableStatement.getObject(2); PARA ORACLE
			   
			   
			   al = new Alumno();
			   al.setId(rs.getInt("cod_alumno"));
			   al.setNombre(rs.getString("nombre_alumno"));
			} catch (SQLException e) {
				// TODO insertar logs
				e.printStackTrace();
			}




		
		return al;
	}

	@Override
	public List<Alumno> getAll() throws Exception{
		List<Alumno> alumnos = null;
		CallableStatement cStmt = null;
		

			Alumno al = null;
			cStmt = conection.prepareCall("{call getAll()}");
			
			//cStmt = conection.prepareCall("{call getAll(?)}"); PARA ORACLE

			//cStmt.registerOutParameter(1, OracleTypes.CURSOR); PARA ORACLE
			
		   rs= cStmt.executeQuery(); //PARA SELECT
		    //int i = cStmt.executeUpdate(); para UPDATE, INSERT; DELETE
		    
		    //rs = (ResultSet) callableStatement.getObject(2); PARA ORACLE
		   alumnos = new ArrayList<Alumno>();
			while(rs.next()){
				al = new Alumno();
				al.setId(rs.getInt("cod_alumno"));
				al.setNombre(rs.getString("nombre_alumno"));
				alumnos.add(al);
			}
			

		return alumnos;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Alumno updateAlumno(Alumno al) {
		// TODO Auto-generated method stub
		return null;
	}

}
