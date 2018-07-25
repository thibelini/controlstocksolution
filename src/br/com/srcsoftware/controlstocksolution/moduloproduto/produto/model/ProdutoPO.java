package br.com.srcsoftware.controlstocksolution.moduloproduto.produto.model;

import java.math.BigDecimal;

import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model.CategoriaPO;

/**
 * 
 * Classe que representa a essencia de um produto
 * Classe da camada Model que representa a parte de persistencia do produto
 *
 *
 * @author Thiago Belini <thibelini@gmail.com.br>
 * @since 24 de jul de 2018 22:01:34
 * @version 1.0
 */

public class ProdutoPO{
	private Long id;
	private String nome;
	private BigDecimal preco;
	private String unidadeMedida;
	private CategoriaPO categoria;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco( BigDecimal preco ) {
		this.preco = preco;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida( String unidadeMedida ) {
		this.unidadeMedida = unidadeMedida;
	}

	public CategoriaPO getCategoria() {
		return categoria;
	}

	public void setCategoria( CategoriaPO categoria ) {
		this.categoria = categoria;
	}

}
