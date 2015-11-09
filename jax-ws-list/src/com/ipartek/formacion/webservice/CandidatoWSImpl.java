package com.ipartek.formacion.webservice;

import com.ipartek.formacion.pojo.Candidato;
import com.ipartek.formacion.webservice.interfaz.CandidatoWS;

import javax.jws.WebService;

@WebService(endpointInterface = "com.ipartek.formacion.webservice.interfaz.CandidatoWS")
public class CandidatoWSImpl implements CandidatoWS {

	@Override
	public String getSaludo(String name) {
		// TODO Auto-generated method stub
		return "Hola " + name;
	}

	@Override
	public Candidato getById(int id) {
		Candidato cand = new Candidato();
		cand.setNombre("Urko");
		return null;
	}

}
