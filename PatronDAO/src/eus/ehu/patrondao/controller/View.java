package eus.ehu.patrondao.controller;

import java.util.Map;

public class View {
	private Map<String, ?> datos;
	private String foward;

	/**
	 * {code}Map<String, ?> @param datos.
	 *
	 * @param foward
	 */
	public View(final Map<String, ?> datos, final String foward) {
		super();
		this.setFoward(foward);
		if (datos != null) {
			this.setDatos(datos);
		}

	}

	public View(final String foward) {
		super();
		this.setFoward(foward);
	}

	public void clean() {
		this.datos = null;
	}

	public final Map<String, ?> getDatos() {
		return this.datos;
	}

	public final String getFoward() {
		return this.foward;
	}

	public final void setDatos(final Map<String, ?> datos) {
		this.datos = datos;
	}

	public final void setFoward(final String foward) {
		this.foward = foward;
	}

}
