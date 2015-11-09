package com.ipartek.formacion.webservice.interfaz;

import com.ipartek.formacion.pojo.Candidato;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public interface CandidatoWS {
	@WebMethod
	public String getSaludo(String name);

	@WebMethod
	public Candidato getById(int id);
}
