package br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model.CategoriaPO;
import br.com.srcsoftware.managers.connection.HibernateConnection;
import br.com.srcsoftware.managers.exceptions.BackendExceptions;

public final class CategoriaDAO{

	public List< CategoriaPO > filtrar( CategoriaPO poFiltrar ) throws BackendExceptions {

		HibernateConnection hibernate = new HibernateConnection();

		try {
			hibernate.iniciarTransacao();

			CriteriaBuilder builder = hibernate.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery criteria = builder.createQuery( CategoriaPO.class );

			/** Definindo o FROM */
			Root root = criteria.from( CategoriaPO.class );

			/** Deixando a Criteria preparada para a Consulta */
			criteria.select( root );

			/** Definindo os parametros do Parametros para consulta (WHERE) */
			ArrayList< Predicate > predicates = new ArrayList< Predicate >();
			if ( poFiltrar == null ) {
				if ( poFiltrar.getNome() != null && !poFiltrar.getNome().isEmpty() ) {
					Predicate nomeParam = builder.like( root.get( "nome" ), poFiltrar.getNome().concat( "%" ) );
					predicates.add( nomeParam );
				}
			}

			/** Adicionando o Predicado no WHERE */
			criteria.where( predicates.toArray( new Predicate[ predicates.size() ] ) );

			List< CategoriaPO > encontrados = hibernate.getCurrentSession().createQuery( criteria ).getResultList();
			hibernate.confirmarTransacao();

			return encontrados;

		} catch ( BackendExceptions e ) {
			hibernate.rollbackTransacao();
			throw e;
		} catch ( Throwable e ) {
			hibernate.rollbackTransacao();
			throw new BackendExceptions( "Erro ao Filtrar Categoria", e );
		}

	}

}
