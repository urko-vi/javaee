<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="pojo.Alumno" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="listadoAlumnos.do">Obtener listado completo de alumnos</a>
	<%
	
	List<Alumno> datos= (List<Alumno>)request.getAttribute("datos");
	if(datos!=null){
		for(Alumno al: datos){
			out.print(al.getNombre()+"\n");
		}
	}
	%>
</body>
</html>