package br.com.srcsoftware.managers.interfaces;

import java.util.List;

import br.com.srcsoftware.managers.abstracts.AbstractPO;

public interface Crud{

	void inserir( AbstractPO po );

	void alterar( AbstractPO po );

	void excluir( AbstractPO po );

	List filtrar( AbstractPO po );

	AbstractPO filtrarPorId( String id );

}
