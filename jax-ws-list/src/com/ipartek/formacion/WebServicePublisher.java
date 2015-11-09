package com.ipartek.formacion;

import com.ipartek.formacion.webservice.CandidatoWSImpl;

import javax.xml.ws.Endpoint;

public class WebServicePublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8888/webservice/helloworld",
				new CandidatoWSImpl());

	}

}
