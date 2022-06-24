package br.com.alura.loja.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // define que essa classe representa uma tabela do banco de dados
@Table(name = "produtos") // caso o nome da tabela seja diferente no banco de dados
public class Produto {

	@Id // define a chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // define como é gerada a chave primaria
	private Long id;
	// @Column(name = "nome-banco") //caso o nome da coluna seja diferente no banco
	private String nome;
	private String descricao;
	private BigDecimal preco;
	private LocalDate data_cadastro = LocalDate.now(); // preenche sempre para a data atual
	
	@ManyToOne //define que se trata de um relacionamento, muitos pra um 
	private Categoria categoria;

	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(LocalDate data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
