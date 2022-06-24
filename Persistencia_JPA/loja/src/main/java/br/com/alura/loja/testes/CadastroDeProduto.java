package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		
		
		Categoria celulares = new Categoria("CELULARES");
		//Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		//CategoriaDao categoriaDao = new CategoriaDao(em);
		//ProdutoDao produtoDao = new ProdutoDao(em);
		
		em.getTransaction().begin(); //inicia transação
		
		//categoriaDao.cadastrar(celulares); //salva a categoria celulares no bd
		//produtoDao.cadastrar(celular); //salva produto celular no bd
		
		em.persist(celulares); //envia do estado transient para o estado managed
		
		celulares.setNome("XTP"); //update nome
		em.flush(); //envia do estado managed para o banco, mas não finaliza
		em.clear(); //limpa o manager, envia para o estado detached
				
		celulares = em.merge(celulares); //busca no estado detached, envia para managed
		celulares.setNome("ABC"); //update nome
		em.flush(); // envia para o banco
		//em.clear(); //dá erro, pois não será possivel remover da classe detached
		em.remove(celulares); //deleta no banco, buscando no managed
		em.flush();

		//em.getTransaction().commit(); //finaliza transcação, envia para o banco
		em.close(); //finaliza entity manager, limpa detached
		
		 
	}

}
