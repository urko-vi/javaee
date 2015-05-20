package com.inpartek.formacion.proyectojava.pojo;

/**
 * Clase que agrupa los datos necesarios para cargar las estadisticas del
 * proyecto
 *
 * @author Urko Villanueva
 *
 */
public class Estadistica {
    private int regLeido;
    private long tiempo;
    private int regCorrecto;
    private int regIncorrecto;
    private int regduplicado;

    public Estadistica() {
	super();
	this.regLeido = 0;
	this.regCorrecto = 0;
	this.regIncorrecto = 0;
	this.regduplicado = 0;
	this.tiempo = 0;
    }

    /**
     *
     * @param pregLeido
     * @param pregCorrecto
     * @param pregIncorrecto
     * @param pregduplicado
     */
    public Estadistica(final int pregLeido, final int pregCorrecto,
	    final int pregIncorrecto, final int pregduplicado) {
	super();
	this.regLeido = pregLeido;
	this.regCorrecto = pregCorrecto;
	this.regIncorrecto = pregIncorrecto;
	this.regduplicado = pregduplicado;
	this.tiempo = 0;
    }

    /**
     *
     * @param pregLeido
     * @param ptiempo
     * @param pregCorrecto
     * @param pregIncorrecto
     * @param pregEstadistica
     */
    public Estadistica(final int pregLeido, final long ptiempo,
	    final int pregCorrecto, final int pregIncorrecto,
	    final int pregEstadistica) {
	super();
	this.regLeido = pregLeido;
	this.tiempo = ptiempo;
	this.regCorrecto = pregCorrecto;
	this.regIncorrecto = pregIncorrecto;
	this.regduplicado = pregEstadistica;
    }

    /**
     * función que se encarga de calcular el tiempo en milisengundos en el
     * formato hh:mm
     *
     * @return el tiempo {@code String} en el formato deseado
     */
    public final String calculateTime() {
	final int DECIMAL = 1000;
	final int GRADE = 60;
	final int minutes = (int) (tiempo / (GRADE * DECIMAL));
	final int seconds = (int) (tiempo / DECIMAL % GRADE);
	final String str = String.format("%d:%02d", minutes, seconds);

	return str;
    }

    public final int getRegCorrecto() {
	return regCorrecto;
    }

    public final int getRegduplicado() {
	return regduplicado;
    }

    public final int getRegIncorrecto() {
	return regIncorrecto;
    }

    public final int getRegLeido() {
	return regLeido;
    }

    public final long getTiempo() {
	return tiempo;
    }

    public final void setRegCorrecto(final int pregCorrecto) {
	this.regCorrecto = pregCorrecto;
    }

    public final void setRegduplicado(final int pregduplicado) {
	this.regduplicado = pregduplicado;
    }

    public final void setRegIncorrecto(final int pregIncorrecto) {
	this.regIncorrecto = pregIncorrecto;
    }

    public final void setRegLeido(final int pregLeido) {
	this.regLeido = pregLeido;
    }

    public final void setTiempo(final long ptiempo) {
	this.tiempo = ptiempo;
    }

}
