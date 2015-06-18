<%@page import="eus.ehu.patrondao.util.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Bienvenido a la pagina <a href="<%=Constantes.DIRECCION_SERVLET_LOGIN+"?"+Constantes.PARAMETRO_OP+"="+Constantes.OP_LOGOUT %>">Salir</a>

<%
String user = (String)request.getParameter("user");
if(user!=null){
	out.print("Hola" +user);
}

 user = (String)session.getAttribute("usuario");
if(user!=null){
	out.print("Bienvenido " +user);
}

%>
</body>
</html>