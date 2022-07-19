package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//busca parametros
		
		String idParam = request.getParameter("id");
		String nome = request.getParameter("nome");
		String dataParam = request.getParameter("data");
		
		//conversão de tipo
		
		Integer id = Integer.valueOf(idParam);
		
		Date data = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			data = sdf.parse(dataParam);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		//busca empresa que será alterada
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(id);
		
		//altera atributos
		empresa.setNome(nome);
		empresa.setDataAbertura(data);
		
		//envia de volta para a listagem
		response.sendRedirect("listaEmpresas"); 
		
	}

}
