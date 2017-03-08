<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<link rel="stylesheet" href="<spring:theme code="css"/>" type="text/css"/>
</head>
<body>
	<h1>Temas</h1>

	<h3>Mensaje desde el controlador: ${msg}</h3>
	
	<span style="float: left">
    	<a href="?theme=default">default</a> 
    	| 
    	<a href="?theme=red">red</a>
	</span>
</body>
</html>