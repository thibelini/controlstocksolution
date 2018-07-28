package br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model;

import br.com.srcsoftware.managers.abstracts.AbstractPO;

/**
 * 
 * Classe da camada Model
 *
 * @author Thiago Belini <thibelini@gmail.com.br>
 * @since 24 de jul de 2018 21:58:11
 * @version 1.0
 */

public class CategoriaPO extends AbstractPO{

	private Long id;
	private String nome;

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

}
