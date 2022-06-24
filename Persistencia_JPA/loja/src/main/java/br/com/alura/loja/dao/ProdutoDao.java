package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Produto;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrar(Produto produto) {
		this.em.persist(produto); // cadastra produto, insere no bd
	}

	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}

	public void remover(Produto produto) {
		produto = this.em.merge(produto);
		this.em.remove(produto);
	}
	
	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id); //retorna o elemento da tabela 'Produto.class' com id 'id'
	}

	public List<Produto> buscarTodos(){
		String jpql = "SELECT p FROM Produto p"; // no SQL -> "SELECT * FROM produtos"
		//return em.createQuery(jpql).getResultList(); // retorna o resultado da query
		return em.createQuery(jpql, Produto.class).getResultList(); //informa o jpql e a classe que será buscada
	}
}
