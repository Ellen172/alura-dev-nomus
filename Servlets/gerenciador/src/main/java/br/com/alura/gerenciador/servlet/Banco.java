package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();
	
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		
		empresas.add(empresa1);
		empresas.add(empresa2);
		
	}

	public void adiciona(Empresa empresa) {
		empresas.add(empresa);
	}

	public List<Empresa> buscaTodasEmpresas() {
		return this.empresas;
	}

}
