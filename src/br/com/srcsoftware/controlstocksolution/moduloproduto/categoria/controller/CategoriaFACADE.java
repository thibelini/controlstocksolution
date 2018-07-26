package br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.controller;

import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model.CategoriaSERVICE;

/**
 * 
 * classe que representa a ligaçao entre front-end e back-end.
 * classe responsavel por interligar a camada VIEW(Tela) com a camada MODEL(Negocio)
 * 
 * @author Thiago Belini <thibelini@gmail.com.br>
 * @since 24 de jul de 2018 22:23:08
 * @version 1.0
 */

public class CategoriaFACADE{

	/** Garante a aplicacao da associacao entre o Controller e Service */
	private CategoriaSERVICE service;

	public CategoriaFACADE(){
		service = new CategoriaSERVICE();
	}
}
