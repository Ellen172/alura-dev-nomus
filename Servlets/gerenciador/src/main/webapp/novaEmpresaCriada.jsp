<!-- Código Java inserido no html (executado pelo servidor) -->
<%
	String nomeEmpresa = (String)request.getAttribute("empresa"); //atribui o valor enviado pela requisição
	System.out.println(nomeEmpresa);
%>

<!-- JSP = java server page (dinamica) -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastrada</title>
</head>
<body>
	<!-- <h4>Empresa <% out.println(nomeEmpresa); %> cadastrada com sucesso!</h4> -->
	<h4>Empresa <%= nomeEmpresa %> cadastrada com sucesso!</h4>
</body>
</html>