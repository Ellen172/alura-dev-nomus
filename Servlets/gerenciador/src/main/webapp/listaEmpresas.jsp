<!-- Declarações da página -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "java.util.List, br.com.alura.gerenciador.servlet.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- biblioteca: java standard taglib -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empresas Cadastradas</title>
</head>
<body>

	<h4>Lista de Empresas cadastradas: </h4>
	<!-- usando biblioteca jstl.jar -->	
	<ul>
		<c:forEach items="${ empresas }" var="empresa"> <!-- percorre os elementos de 'empresas' (localizado no request) através da variavel 'empresa' -->
			<li>${ empresa.nome }</li> <!-- localiza nome para cada empresa (empresa.getNome()) -->
		</c:forEach>
	</ul>
	
</body>
</html>