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

public final class CategoriaFACADE{

	/** Garante a aplicacao da associacao entre o Service e o DAO */
	/**
	 * Toda constante deve possuir um valor definido
	 * Os unicos lugares possiveis de inicializacao de uma constante sao:
	 * - No ato da DECLARAÇÃO;
	 * -- Ex: final ProdutoDAO DAO = new ProdutoDAO();
	 * - Na PRIMEIRA LINHA DO CONSTRUTOR
	 * -- Ex public ProdutoSERVICE(){
	 * ------------DAO = new ProdutoDAO();
	 * ------}
	 * - Em um BLOCO ESTATICO
	 * -- Ex: static{
	 * ---------DAO = new ProdutoDAO();
	 * -------}
	 */

	/** Garante a aplicacao da associacao entre o Controller e Service */
	private final CategoriaSERVICE SERVICE;

	public CategoriaFACADE(){
		SERVICE = new CategoriaSERVICE();
	}
}
