<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<h1>Internationalization</h1>
 
Idioma : <a href="?language=en">English</a>|<a href="?language=es">Español</a>
 
<h3>
	<h3>Mensaje desde el controlador: ${msg}</h3>
	
	<h3>MEnsaje desde el fichero properties <spring:message code="hello.world" text="Texto a mostrar en caso de no encontrar la propiedad" /></h3>
</h3>
 
Current Locale : ${pageContext.response.locale}
 
</body>
</html>