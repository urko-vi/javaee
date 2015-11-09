package com.ipartek.formacion.webclient;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.ipartek.formacion.webservice.interfaz.CandidatoWS;

 
public class WebServiceClient{
 
	public static void main(String[] args) throws Exception {
 
	    URL wsdlUrl = new URL("http://localhost:8888/webservice/helloworld?wsdl");
        
	    //qualifier name ...
        QName qname = new QName("http://webservice.formacion.ipartek.com/", "CandidatoWSImplService");
 
        Service service = Service.create(wsdlUrl, qname);
 
        CandidatoWS helloService = service.getPort(CandidatoWS.class);
 
        System.out.println(helloService.getSaludo("Urko"));
 
    }
 
}