<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- biblioteca java standart taglib -->
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de empresa</title>
</head>
<body>
	<form action="${ linkServletNovaEmpresa }" method="post">
	
		Nome: <input type="text" name="nome"  />
		Data de abertura: <input type="text" name="data" placeholder="dd/MM/yyyy"/>
	
		<input type="submit" />
	</form>

</body>
</html>