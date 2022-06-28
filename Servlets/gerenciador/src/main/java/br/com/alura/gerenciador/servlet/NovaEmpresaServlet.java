package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) //executa apenas requisição post
			throws ServletException, IOException {

		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa = request.getParameter("nome"); //lê parametro enviado pelo metodo get
		
		//cria um objeto do tipo empresa
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		
		//inserindo em banco ficticio
		Banco banco = new Banco();		
		banco.adiciona(empresa);
	
		//chamar o jsp 
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp"); //cria despachante
		request.setAttribute("empresa", empresa.getNome()); //atributo a ser enviado para proxima pagina
		rd.forward(request, response); //envia despache
	}

}
