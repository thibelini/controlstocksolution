package br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model;

import java.util.ArrayList;
import java.util.List;

import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.dao.CategoriaDAO;
import br.com.srcsoftware.managers.abstracts.AbstractPO;
import br.com.srcsoftware.managers.exceptions.BackendExceptions;
import br.com.srcsoftware.managers.interfaces.Crud;
import br.com.srcsoftware.managers.utilidades.Utilidades;

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
	public void inserir( final AbstractPO PO ) throws BackendExceptions {
		try {
			if ( PO == null ) {
				throw new BackendExceptions( "Objeto nulo passado como paramentro" );
			}

			CategoriaPO categoria = null;

			if ( PO instanceof CategoriaPO ) {
				categoria = (CategoriaPO) PO;
			} else {
				throw new BackendExceptions( "Objeto PO Passado nao condiz com o contexto" );
			}

			if ( !categoria.getNome().matches( Utilidades.REGEX_SOMENTE_LETRAS_E_ESPACOS ) ) {
				throw new BackendExceptions( "O Nome nao sao permitidos caracteres numericos" );
			}

			System.out.println( "SERVICE: inserindo" );
		} catch ( BackendExceptions e ) {
			throw e;
		} catch ( Exception e ) {
			throw new BackendExceptions( "Erro desconhecido ao inserir", e );
		}
	}

	@Override
	public void alterar( final AbstractPO PO ) throws BackendExceptions {
		try {
			if ( PO == null ) {
				throw new BackendExceptions( "Objeto nulo passado como paramentro" );
			}

			CategoriaPO categoria = null;

			if ( PO instanceof CategoriaPO ) {
				categoria = (CategoriaPO) PO;
			} else {
				throw new BackendExceptions( "Objeto PO Passado nao condiz com o contexto" );
			}

			if ( !categoria.getNome().matches( Utilidades.REGEX_SOMENTE_LETRAS_E_ESPACOS ) ) {
				throw new BackendExceptions( "O Nome nao sao permitidos caracteres numericos" );
			}

			System.out.println( "SERVICE: alterando" );
		} catch ( BackendExceptions e ) {
			throw e;
		} catch ( Exception e ) {
			throw new BackendExceptions( "Erro desconhecido ao alterar", e );
		}
	}

	@Override
	public void excluir( final AbstractPO PO ) throws BackendExceptions {
		try {
			if ( PO == null ) {
				throw new BackendExceptions( "Objeto nulo passado como paramentro" );
			}

			CategoriaPO categoria = null;

			if ( PO instanceof CategoriaPO ) {
				categoria = (CategoriaPO) PO;
			} else {
				throw new BackendExceptions( "Objeto PO Passado nao condiz com o contexto" );
			}

			System.out.println( "SERVICE: excluindo" );
		} catch ( BackendExceptions e ) {
			throw e;
		} catch ( Exception e ) {
			throw new BackendExceptions( "Erro desconhecido ao excluir", e );
		}
	}

	@Override
	public List filtrar( final AbstractPO PO ) throws BackendExceptions {
		try {

			CategoriaPO categoria = null;

			if ( PO != null ) {
				if ( PO instanceof CategoriaPO ) {
					categoria = (CategoriaPO) PO;
				} else {
					throw new BackendExceptions( "Objeto PO Passado nao condiz com o contexto" );
				}
			}

			System.out.println( "SERVICE: filtrando" );

			return new ArrayList<>();

		} catch ( BackendExceptions e ) {
			throw e;
		} catch ( Exception e ) {
			throw new BackendExceptions( "Erro desconhecido ao filtrar", e );
		}

	}

	@Override
	public AbstractPO filtrarPorId( final String ID ) throws BackendExceptions {
		try {
			if ( ID == null ) {
				throw new BackendExceptions( "Objeto nulo passado como paramentro" );
			}

			System.out.println( "SERVICE: filtrando por Id" );

			return new CategoriaPO();

		} catch ( BackendExceptions e ) {
			throw e;
		} catch ( Exception e ) {
			throw new BackendExceptions( "Erro desconhecido ao filtrar", e );
		}

	}

}
