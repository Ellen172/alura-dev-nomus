package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();
		List<Empresa> empresas = banco.buscaTodasEmpresas();
		
		request.setAttribute("empresas", empresas); //add empresas como atributo para request
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp"); //enviar request para arquivo /listaEmpresas.jsp
		rd.forward(request, response); //envia para /listaEmpresas.jsp
		
	}

}
