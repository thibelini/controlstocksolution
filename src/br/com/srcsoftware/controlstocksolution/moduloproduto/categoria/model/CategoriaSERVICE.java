package br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model;

import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.dao.CategoriaDAO;

/**
 * 
 * Classe que representa a camada de regra de negocio da Categoria
 *
 *
 * @author Thiago Belini <thibelini@gmail.com.br>
 * @since 24 de jul de 2018 22:16:31
 * @version 1.0
 */

public class CategoriaSERVICE{

	private CategoriaDAO dao;

	public CategoriaSERVICE(){
		dao = new CategoriaDAO();
	}

}
