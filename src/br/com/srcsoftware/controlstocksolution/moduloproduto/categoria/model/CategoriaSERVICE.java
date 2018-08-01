package br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model;

import java.util.ArrayList;
import java.util.List;

import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.dao.CategoriaDAO;
import br.com.srcsoftware.managers.abstracts.AbstractPO;
import br.com.srcsoftware.managers.interfaces.Crud;

/**
 * 
 * Classe que representa a camada de regra de negocio da Categoria
 *
 *
 * @author Thiago Belini <thibelini@gmail.com.br>
 * @since 24 de jul de 2018 22:16:31
 * @version 1.0
 */

public final class CategoriaSERVICE implements Crud{
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

	private final CategoriaDAO DAO;

	public CategoriaSERVICE(){
		DAO = new CategoriaDAO();
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
		System.out.println( "SERVICE: filtrando" );
		return new ArrayList<>();
	}

	@Override
	public AbstractPO filtrarPorId( String id ) {
		System.out.println( "SERVICE: filtrando por Id" );
		return new CategoriaPO();
	}

}
