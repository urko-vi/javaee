<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="eus.ehu.patrondao.bean.Alumno" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Usuarios</title>
</head>
<body>
	<form action="" method="post">
		<input type="text" name="user" placeholder="Introduzca su nombre de usuario">
		<input type="password" name="pass" placeholder="Introduzca su contraseña">
		<input type="submit" value="Enviar">
	</form>
	
	
	<a href="/PatronDAO/LoginServlet?user=urko&pass=urko">Login</a>
	<% 
	String mensaje = (String)request.getAttribute("mensaje");
	if(mensaje !=null){
	%>
	
	
	<%
	}
	%>
	<!-- 
	<a href="listadoAlumnos.do">Pincha para obtener la lista de alumnos</a>
	
	<%
	
	List<Alumno> datos= (List<Alumno>)request.getAttribute("datos");
	if(datos!=null){
		for(Alumno al: datos){
			out.print(al.getNombre()+"\n");
		}
	}
	%>
	 -->
</body>
</html>