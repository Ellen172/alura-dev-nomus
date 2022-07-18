package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String dataAberturaStr = request.getParameter("data");
		
		// convertendo String para Date
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataAberturaStr);
		} catch (ParseException e) {
			throw new ServletException(); //caso a data não possa ser convertida, ocorre erro, não continua com cadastro.
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
//		//chamar o JPS (server side)
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas"); //chama o servlet ListaEmpresaServlet
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
		
		request.setAttribute("empresa", empresa.getNome());
		response.sendRedirect("listaEmpresas"); //envia resposta com redirecionamento de pagina
		
	}

}
