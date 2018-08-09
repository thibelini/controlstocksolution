package br.com.srcsoftware.controlstocksolution.moduloproduto.produto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model.CategoriaPO;
import br.com.srcsoftware.controlstocksolution.moduloproduto.produto.model.ProdutoPO;
import br.com.srcsoftware.managers.connection.HibernateConnection;
import br.com.srcsoftware.managers.exceptions.BackendExceptions;

public final class ProdutoDAO{

	public void inserir( HibernateConnection hibernate, ProdutoPO po ) throws BackendExceptions {
		ProdutoPO poInserido = (ProdutoPO) hibernate.inserir( po );
		po.setId( poInserido.getId() );
	}

	public void alterar( HibernateConnection hibernate, ProdutoPO po ) throws BackendExceptions {
		hibernate.alterar( po );
	}

	public void excluir( HibernateConnection hibernate, ProdutoPO po ) throws BackendExceptions {
		hibernate.excluir( po );
	}

	public ProdutoPO filtrarPorId( Long id ) throws BackendExceptions {
		return (ProdutoPO) new HibernateConnection().filtrarPorId( id, ProdutoPO.class );
	}

	public List< ProdutoPO > filtrar( ProdutoPO poFiltrar ) throws BackendExceptions {

		HibernateConnection hibernate = new HibernateConnection();

		try {
			hibernate.iniciarTransacao();

			CriteriaBuilder builder = hibernate.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery criteria = builder.createQuery( ProdutoPO.class );

			/** Definindo o FROM */
			Root root = criteria.from( ProdutoPO.class );

			/** Deixando a Criteria preparada para a Consulta */
			criteria.select( root );

			/** Definindo os parametros do Parametros para consulta (WHERE) */
			ArrayList< Predicate > predicates = new ArrayList< Predicate >();

			if ( poFiltrar != null ) {
				if ( poFiltrar.getNome() != null && !poFiltrar.getNome().isEmpty() ) {
					Predicate nomeParam = builder.like( root.get( "nome" ), poFiltrar.getNome().concat( "%" ) );
					predicates.add( nomeParam );
				}

				if ( poFiltrar.getPreco() != null ) {
					Predicate precoParam = builder.equal( root.get( "preco" ), poFiltrar.getPreco() );
					predicates.add( precoParam );
				}

				if ( poFiltrar.getUnidadeMedida() != null && !poFiltrar.getUnidadeMedida().isEmpty() ) {
					Predicate unidadeMedidaParam = builder.like( root.get( "unidadeMedida" ), poFiltrar.getUnidadeMedida().concat( "%" ) );
					predicates.add( unidadeMedidaParam );
				}

				Join< ProdutoPO, CategoriaPO > joinCategoria = root.join( "categoria", JoinType.INNER );
				if ( poFiltrar.getCategoria().getNome() != null && !poFiltrar.getCategoria().getNome().isEmpty() ) {
					Predicate nomeCategoriaParam = builder.like( joinCategoria.get( "nome" ), poFiltrar.getCategoria().getNome().concat( "%" ) );
					predicates.add( nomeCategoriaParam );
				}
			}

			/** Adicionando o Predicado no WHERE */
			criteria.where( predicates.toArray( new Predicate[ predicates.size() ] ) );

			List< ProdutoPO > encontrados = hibernate.getCurrentSession().createQuery( criteria ).getResultList();
			hibernate.confirmarTransacao();

			return encontrados;

		} catch ( BackendExceptions e ) {
			hibernate.rollbackTransacao();
			throw e;
		} catch ( Throwable e ) {
			hibernate.rollbackTransacao();
			throw new BackendExceptions( "Erro ao Filtrar Produto", e );
		}

	}

}
