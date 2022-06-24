package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {		
		cadastrarProdutoTeste();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p1 = produtoDao.buscarPorId(1l); //select de um elemento da tabela
		System.out.println(p1.getPreco());
		
		List<Produto> todos = produtoDao.buscarTodos(); //select de todos os elementos de uma tabela
		todos.forEach(p -> System.out.println(p.getNome()));
	}

	private static void cadastrarProdutoTeste() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		Produto celular2 = new Produto("LG K11+", "Celular lg", new BigDecimal("700"), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		em.getTransaction().begin(); //inicia transação
		
		//create - insert 
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular); 
		produtoDao.cadastrar(celular2);
		
		//em.persist(celulares); //envia do estado transient para o estado managed
		
		//celulares.setNome("XTP"); //update nome
		//em.flush(); //envia do estado managed para o banco, mas não finaliza
		//em.clear(); //limpa o manager, envia para o estado detached
				
		//celulares = em.merge(celulares); //busca no estado detached, envia para managed
		//celulares.setNome("ABC"); //update nome
		//em.flush(); // envia para o banco
		//em.clear(); //dá erro, pois não será possivel remover da classe detached
		//em.remove(celulares); //deleta no banco, buscando no managed
		//em.flush();

		em.getTransaction().commit(); //finaliza transcação, envia para o banco
		em.close(); //finaliza entity manager, limpa detached
	}

}
