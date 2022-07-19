<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- biblioteca java standart taglib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- biblioteca java standart taglib -->
<c:url value="/alteraEmpresa" var="servletAlteraEmpresa" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de empresa</title>
</head>
<body>
	<form action="${ servletAlteraEmpresa }" method="post">
	
		<input type="text" name="id" value="${empresa.id}" hidden/>

		<label for="nome">Nome:</label> 
		<input type="text" name="nome" value="${empresa.nome}" /> 
		
		<label for="data">Data de abertura: </label> 
		<input type="text" name="data" placeholder="dd/MM/yyyy" 
			value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyy"/>"/>
		
		<input type="submit" value="Enviar"/>
	</form>

</body>
</html>