<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- biblioteca: java standard taglib -->
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/> <!-- retorna o caminho para novaEmpresa -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de nova empresa</title>
</head>
<body>

	<form action="${ linkServletNovaEmpresa }" method="post"> 
	
		<label for="nome">Nome:</label>
		<input type="text" name="nome"/>
		
		<input type="submit" />
		
	</form>
	
</body>
</html>