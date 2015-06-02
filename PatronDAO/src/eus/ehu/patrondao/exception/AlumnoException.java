package eus.ehu.patrondao.exception;

public class AlumnoException extends Exception {

	public static final String MSG_LONGITUD_TEXTO = "INTRODUZCA UN TEXTO DE NOMBRE";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlumnoException() {
		super();

	}

	public AlumnoException(String msg) {
		super(msg);		
		
	}

}
