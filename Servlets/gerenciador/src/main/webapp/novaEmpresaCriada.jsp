<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- biblioteca: java standard taglib -->

<!-- JSP = java server page (dinamica) -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Empresa Cadastrada</title>
</head>
<body>
	<c:if test="${ not empty empresa }"> <!-- verifica variavel -->
		<h4>Empresa ${ empresa } cadastrada com sucesso!</h4> <!-- busca na requisição o atributo "empresa" -->
	</c:if>
	<c:if test="${ empty empresa }">
		<h4>Nenhuma empresa cadastrada!</h4>
	</c:if>
</body>
</html>