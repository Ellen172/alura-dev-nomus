package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi");
		celular.setDescricao("Muito legal");
		celular.setPreco(new BigDecimal("800"));
		
		// versão inicial
		/*
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja"); //criacao da factory de EntityManager de acordo com o name de persistence-unit do arquivo persistence.xml
		EntityManager em = factory.createEntityManager(); //EntityManager é uma interface usada para manipular o bd
		
		em.getTransaction().begin(); //para iniciar as transações com o banco de dados
		em.persist(celular); //insere o objeto no bd
		em.getTransaction().commit(); //finaliza as transações com o banco de dados
		em.close(); //fecha o entity manager	
		*/
		
		// utilizando um produto dao
		/*
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja"); //criacao da factory de EntityManager de acordo com o name de persistence-unit do arquivo persistence.xml
		EntityManager em = factory.createEntityManager(); //EntityManager é uma interface usada para manipular o bd
		ProdutoDao dao = new ProdutoDao(em);
		
		em.getTransaction().begin(); //inicia transação
		dao.cadastrar(celular); //insere o objeto
		em.getTransaction().commit(); //finaliza transcação
		em.close(); //fecha entity manager
		*/
		
		//versão com JPAUtil
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao dao = new ProdutoDao(em);
		
		em.getTransaction().begin(); //inicia transação
		dao.cadastrar(celular); //insere o objeto
		em.getTransaction().commit(); //finaliza transcação
		em.close(); //fecha entity manager
	}

}
