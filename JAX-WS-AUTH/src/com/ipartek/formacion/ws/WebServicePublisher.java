package com.ipartek.formacion.ws;

import javax.xml.ws.Endpoint;

import com.ipartek.formacion.ws.WebServiceImpl;

public class WebServicePublisher{
 
	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:8069/webservice/helloworld", new WebServiceImpl());
    }
 
}