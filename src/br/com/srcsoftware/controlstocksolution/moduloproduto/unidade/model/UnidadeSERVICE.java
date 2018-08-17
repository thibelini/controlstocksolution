package br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.model;

import java.util.List;

import br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.dao.UnidadeDAO;
import br.com.srcsoftware.managers.abstracts.AbstractPO;
import br.com.srcsoftware.managers.connection.HibernateConnection;
import br.com.srcsoftware.managers.exceptions.BackendExceptions;
import br.com.srcsoftware.managers.interfaces.Crud;
import br.com.srcsoftware.managers.utilidades.Utilidades;

/**
 * 
 * Classe que representa a camada de regra de negocio da Unidade
 *
 *
 * @author Thiago Belini <thibelini@gmail.com.br>
 * @since 24 de jul de 2018 22:16:31
 * @version 1.0
 */

public final class UnidadeSERVICE implements Crud{
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

	private final UnidadeDAO DAO;

	public UnidadeSERVICE(){
		DAO = new UnidadeDAO();
	}

	@Override
	public void inserir( final AbstractPO PO ) throws BackendExceptions {

		HibernateConnection hibernate = new HibernateConnection();

		try {
			hibernate.iniciarTransacao();

			if ( PO == null ) {
				throw new BackendExceptions( "Objeto nulo passado como paramentro" );
			}

			UnidadePO unidade = null;

			if ( PO instanceof UnidadePO ) {
				unidade = (UnidadePO) PO;
			} else {
				throw new BackendExceptions( "Objeto PO Passado nao condiz com o contexto" );
			}

			if ( !unidade.getNome().matches( Utilidades.REGEX_SOMENTE_LETRAS_E_ESPACOS ) ) {
				throw new BackendExceptions( "O Nome nao sao permitidos caracteres numericos" );
			}

			DAO.inserir( hibernate, unidade );
			hibernate.confirmarTransacao();

			System.out.println( "SERVICE: inserindo" );
		} catch ( BackendExceptions e ) {
			hibernate.rollbackTransacao();
			throw e;
		} catch ( Exception e ) {
			hibernate.rollbackTransacao();
			throw new BackendExceptions( "Erro desconhecido ao inserir", e );
		}
	}

	@Override
	public void alterar( final AbstractPO PO ) throws BackendExceptions {

		HibernateConnection hibernate = new HibernateConnection();

		try {
			hibernate.iniciarTransacao();

			if ( PO == null ) {
				throw new BackendExceptions( "Objeto nulo passado como paramentro" );
			}

			UnidadePO unidade = null;

			if ( PO instanceof UnidadePO ) {
				unidade = (UnidadePO) PO;
			} else {
				throw new BackendExceptions( "Objeto PO Passado nao condiz com o contexto" );
			}

			if ( !unidade.getNome().matches( Utilidades.REGEX_SOMENTE_LETRAS_E_ESPACOS ) ) {
				throw new BackendExceptions( "O Nome nao sao permitidos caracteres numericos" );
			}

			DAO.alterar( hibernate, unidade );
			hibernate.confirmarTransacao();

			System.out.println( "SERVICE: alterando" );
		} catch ( BackendExceptions e ) {
			hibernate.rollbackTransacao();
			throw e;
		} catch ( Exception e ) {
			hibernate.rollbackTransacao();
			throw new BackendExceptions( "Erro desconhecido ao alterar", e );
		}
	}

	@Override
	public void excluir( final AbstractPO PO ) throws BackendExceptions {

		HibernateConnection hibernate = new HibernateConnection();

		try {
			hibernate.iniciarTransacao();

			if ( PO == null ) {
				throw new BackendExceptions( "Objeto nulo passado como paramentro" );
			}

			UnidadePO unidade = null;

			if ( PO instanceof UnidadePO ) {
				unidade = (UnidadePO) PO;
			} else {
				throw new BackendExceptions( "Objeto PO Passado nao condiz com o contexto" );
			}

			DAO.excluir( hibernate, unidade );
			hibernate.confirmarTransacao();

			System.out.println( "SERVICE: excluindo" );
		} catch ( BackendExceptions e ) {
			hibernate.rollbackTransacao();
			throw e;
		} catch ( Exception e ) {
			hibernate.rollbackTransacao();
			throw new BackendExceptions( "Erro desconhecido ao excluir", e );
		}
	}

	@Override
	public List filtrar( final AbstractPO PO ) throws BackendExceptions {
		try {

			UnidadePO unidade = null;

			if ( PO != null ) {
				if ( PO instanceof UnidadePO ) {
					unidade = (UnidadePO) PO;
				} else {
					throw new BackendExceptions( "Objeto PO Passado nao condiz com o contexto" );
				}
			}

			System.out.println( "SERVICE: filtrando" );

			return DAO.filtrar( unidade );

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

			return DAO.filtrarPorId( Long.valueOf( ID ) );

		} catch ( BackendExceptions e ) {
			throw e;
		} catch ( Exception e ) {
			throw new BackendExceptions( "Erro desconhecido ao filtrar", e );
		}

	}

}
