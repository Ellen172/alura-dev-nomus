package br.com.alura.loja.dao;

import java.math.BigDecimal;
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
	
	public List<Produto> buscarPorNome(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome"; // :nome representa um parametro
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome) //substitindo parametro	
				.getResultList();
	}
	
	public List<Produto> buscarPorNomeDaCategoria(String categoria){
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :categoria"; // :nome representa um parametro
		return em.createQuery(jpql, Produto.class)
				.setParameter("categoria", categoria) //substitindo parametro	
				.getResultList();
	}
	
	public BigDecimal buscarPrecoPeloNome(String nome){
		String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("nome", nome) 
				.getSingleResult();
	}
}
