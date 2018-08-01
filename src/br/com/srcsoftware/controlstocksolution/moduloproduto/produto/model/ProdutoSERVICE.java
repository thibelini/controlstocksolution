package br.com.srcsoftware.controlstocksolution.moduloproduto.produto.model;

import java.util.List;

import br.com.srcsoftware.controlstocksolution.moduloproduto.produto.dao.ProdutoDAO;
import br.com.srcsoftware.managers.abstracts.AbstractPO;
import br.com.srcsoftware.managers.interfaces.Crud;

public final class ProdutoSERVICE implements Crud{

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

	@Override
	public void inserir( AbstractPO po ) {
		System.out.println( "SERVICE: inserindo" );
	}

	@Override
	public void alterar( AbstractPO po ) {
		System.out.println( "SERVICE: alterando" );
	}

	@Override
	public void excluir( AbstractPO po ) {
		System.out.println( "SERVICE: excluindo" );
	}

	@Override
	public List filtrar( AbstractPO po ) {
		System.out.println( "SERVICE: listando" );
		return null;
	}

	@Override
	public AbstractPO filtrarPorId( String id ) {
		System.out.println( "SERVICE: filtrando por Id" );
		return null;
	}
}
