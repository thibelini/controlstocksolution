package br.com.srcsoftware.controlstocksolution.moduloproduto.produto.model;

import br.com.srcsoftware.controlstocksolution.moduloproduto.produto.dao.ProdutoDAO;

public final class ProdutoSERVICE{

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

	private final ProdutoDAO DAO;

	public ProdutoSERVICE(){
		DAO = new ProdutoDAO();
	}
}
