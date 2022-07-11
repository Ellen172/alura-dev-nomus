<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- biblioteca java standart taglib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> <!-- biblioteca java standart taglib -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de empresas</title>
</head>
<body>
	Lista de empresas: <br />
	<ul>
		<c:forEach items="${ empresas }" var="empresa"> <!-- para cada empresa na lista empresas -->
			<li>${ empresa.nome } -
			<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" /></li>
		</c:forEach>
	</ul>
	
</body>
</html>