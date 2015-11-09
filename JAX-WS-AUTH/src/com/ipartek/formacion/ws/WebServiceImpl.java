package com.ipartek.formacion.ws;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(endpointInterface = "com.ipartek.formacion.ws.WebServiceInterface")
public class WebServiceImpl implements WebServiceInterface {

	@Resource
	WebServiceContext webServiceContext;

	@Override
	public String getHelloWorldAsString(String str) {

		MessageContext messageContext = webServiceContext.getMessageContext();

		// get request headers
		Map<?,?> requestHeaders = (Map<?,?>) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
		List<?> usernameList = (List<?>) requestHeaders.get("username");
		List<?> passwordList = (List<?>) requestHeaders.get("password");

		String username = "";
		String password = "";

		if (usernameList != null) {
			username = usernameList.get(0).toString();
		}

		if (passwordList != null) {
			password = passwordList.get(0).toString();
		}

		if (username.equals("urko") && password.equals("superpassword")) {
			
			return "Usuario Valido :"+str;
			
		} else {
			
			return "Usuario desconocido!";
		}

	}

}