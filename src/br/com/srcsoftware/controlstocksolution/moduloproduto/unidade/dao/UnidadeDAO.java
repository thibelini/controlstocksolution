package br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.model.UnidadePO;
import br.com.srcsoftware.managers.connection.HibernateConnection;
import br.com.srcsoftware.managers.exceptions.BackendExceptions;

public final class UnidadeDAO{

	public void inserir( HibernateConnection hibernate, UnidadePO po ) throws BackendExceptions {
		UnidadePO poInserido = (UnidadePO) hibernate.inserir( po );
		po.setId( poInserido.getId() );
	}

	public void alterar( HibernateConnection hibernate, UnidadePO po ) throws BackendExceptions {
		hibernate.alterar( po );
	}

	public void excluir( HibernateConnection hibernate, UnidadePO po ) throws BackendExceptions {
		hibernate.excluir( po );
	}

	public UnidadePO filtrarPorId( Long id ) throws BackendExceptions {
		return (UnidadePO) new HibernateConnection().filtrarPorId( id, UnidadePO.class );
	}

	public List< UnidadePO > filtrar( UnidadePO poFiltrar ) throws BackendExceptions {

		HibernateConnection hibernate = new HibernateConnection();

		try {
			hibernate.iniciarTransacao();

			CriteriaBuilder builder = hibernate.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery criteria = builder.createQuery( UnidadePO.class );

			/** Definindo o FROM */
			Root root = criteria.from( UnidadePO.class );

			/** Deixando a Criteria preparada para a Consulta */
			criteria.select( root );

			/** Definindo os parametros do Parametros para consulta (WHERE) */
			ArrayList< Predicate > predicates = new ArrayList< Predicate >();
			if ( poFiltrar != null ) {
				if ( poFiltrar.getNome() != null && !poFiltrar.getNome().isEmpty() ) {
					Predicate nomeParam = builder.like( root.get( "nome" ), poFiltrar.getNome().concat( "%" ) );
					predicates.add( nomeParam );
				}
				if ( poFiltrar.getSigla() != null && !poFiltrar.getSigla().isEmpty() ) {
					Predicate siglaParam = builder.like( root.get( "sigla" ), poFiltrar.getSigla().concat( "%" ) );
					predicates.add( siglaParam );
				}
			}

			/** Adicionando o Predicado no WHERE */
			criteria.where( predicates.toArray( new Predicate[ predicates.size() ] ) );

			List< UnidadePO > encontrados = hibernate.getCurrentSession().createQuery( criteria ).getResultList();
			hibernate.confirmarTransacao();

			return encontrados;

		} catch ( BackendExceptions e ) {
			hibernate.rollbackTransacao();
			throw e;
		} catch ( Throwable e ) {
			hibernate.rollbackTransacao();
			throw new BackendExceptions( "Erro ao Filtrar Unidade", e );
		}

	}

}
