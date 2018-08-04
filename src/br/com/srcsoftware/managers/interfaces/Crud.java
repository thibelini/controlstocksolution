package br.com.srcsoftware.managers.interfaces;

import java.util.List;

import br.com.srcsoftware.managers.abstracts.AbstractPO;
import br.com.srcsoftware.managers.exceptions.BackendExceptions;

public interface Crud{

	void inserir( AbstractPO po ) throws BackendExceptions;

	void alterar( AbstractPO po ) throws BackendExceptions;

	void excluir( AbstractPO po ) throws BackendExceptions;

	List filtrar( AbstractPO po ) throws BackendExceptions;

	AbstractPO filtrarPorId( String id ) throws BackendExceptions;

}
