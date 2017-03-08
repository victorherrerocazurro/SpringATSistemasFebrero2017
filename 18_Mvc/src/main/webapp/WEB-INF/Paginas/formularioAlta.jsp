<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../js/main.js"></script>
</head>
<body>

<script type="text/javascript">

muestrameUnaAlerta();

</script>
	
	<form:form modelAttribute="persona" method="POST">
		<form:errors path="*"  element="span"/>
		
		<form:label path="id"/>
		<form:input path="id"/>
		<form:errors path="id"/>
		
		<form:input path="nombre"/>
		<form:errors path="nombre"/>
		
		<form:input path="edad"/>
		<form:errors path="edad"/>
		
		<form:input path="altura"/>
		
		<form:select path="genero" items="${generos}"/>
			
		<form:button>Enviar</form:button>
	</form:form>

</body>
</html>