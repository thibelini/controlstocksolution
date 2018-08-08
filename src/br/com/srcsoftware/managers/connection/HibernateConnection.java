package br.com.srcsoftware.managers.connection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import br.com.srcsoftware.managers.abstracts.AbstractPO;
import br.com.srcsoftware.managers.exceptions.BackendExceptions;
import br.com.srcsoftware.managers.utilidades.Utilidades;

/**
 * Componente.
 * Classe criada a fim de se definir um componente de Conectividade dos nossos Softwares.
 * 
 * Este componente será responsável por gerenciar as Sessoes, Transações, Commits e Rollbacks.
 * Ele possuirá todos os metodos Basicos de Persistencia e de consulta.
 *
 * @author Thiago Belini <thibelini@gmail.com.br>
 * @since 6 de ago de 2018 22:21:13
 * @version 1.0
 */

public final class HibernateConnection{

	private StandardServiceRegistry registry;
	private SessionFactory sessionFactory;
	private Session currentSession;
	private Transaction transaction;

	public void destroy() {
		if ( registry != null ) {
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}

	private SessionFactory getSessionFactory() {
		/** Usando o singleton */
		if ( sessionFactory == null ) {
			try {
				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
				/** Criando o Registry */
				registry = registryBuilder.configure( "hibernate.cfg.xml" ).build();
				/**
				 * Criando o MetadataSource
				 * Usado para informar os mapeamentos dos POS caso queira fazer pelo Java.
				 * Ex: sources.addAnnotatedClass( AbstractPO.class );
				 */
				MetadataSources sources = new MetadataSources( registry );

				/** Criando o MetaDataBuilder */
				MetadataBuilder metadataBuilder = sources.getMetadataBuilder();

				/**
				 * Especificando os Schemas padrao que sera usado para todas as tabelas
				 * PS: funciona apenas quando nao informamos explicitamente na Classe PO
				 */
				metadataBuilder.applyImplicitSchemaName( Utilidades.SCHEMA );

				Metadata metadata = metadataBuilder.build();

				/** Criando SessionFactory */
				sessionFactory = metadata.getSessionFactoryBuilder().build();

			} catch ( Throwable e ) {
				e.printStackTrace();
				destroy();
			}
		}
		return sessionFactory;
	}

	public Session getCurrentSession() throws BackendExceptions {
		if ( currentSession == null ) {
			throw new BackendExceptions( "A Sessão não esta aberta!" );
		}
		return currentSession;
	}

	private void setCurrentSession( Session currentSession ) {
		this.currentSession = currentSession;
	}

	private void abrirSessao() {
		setCurrentSession( getSessionFactory().openSession() );
	}

	private void fecharSessao() throws BackendExceptions {
		getCurrentSession().close();
		setCurrentSession( null );
	}

	public void iniciarTransacao() throws BackendExceptions {
		abrirSessao();
		transaction = getCurrentSession().beginTransaction();
	}

	public void confirmarTransacao() throws BackendExceptions {
		if ( transaction == null ) {
			throw new BackendExceptions( "A Transação não esta iniciada!" );
		}
		transaction.commit();
		fecharSessao();
		transaction = null;
	}

	public void rollbackTransacao() throws BackendExceptions {
		if ( transaction == null ) {
			throw new BackendExceptions( "A Transação não esta iniciada!" );
		}
		transaction.rollback();
		fecharSessao();
		transaction = null;
	}

	public AbstractPO inserir( AbstractPO po ) throws BackendExceptions {
		try {
			return (AbstractPO) getCurrentSession().merge( po );
		} catch ( Throwable e ) {
			throw new BackendExceptions( "Erro ao inserir ", e );
		}
	}

	public void alterar( AbstractPO po ) throws BackendExceptions {
		try {
			getCurrentSession().merge( po );
		} catch ( Throwable e ) {
			throw new BackendExceptions( "Erro ao alterar ", e );
		}
	}

	public void excluir( AbstractPO po ) throws BackendExceptions {
		try {
			getCurrentSession().delete( po );
		} catch ( Throwable e ) {
			throw new BackendExceptions( "Erro ao excluir ", e );
		}
	}

	public AbstractPO filtrarPorId( long id, Class clazz ) throws BackendExceptions {
		try {
			/** Utilizando CriteriaBuilder para a confecção de nossas Queries */
			iniciarTransacao();

			CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
			CriteriaQuery criteria = builder.createQuery( clazz );

			/** Definindo o FROM */
			Root root = criteria.from( clazz );

			/** Deixando a Criteria preparada para a Consulta */
			criteria.select( root );

			/** Definindo os parametros do WHERE */
			Predicate idParam = builder.equal( root.get( "id" ), id );

			/** Adicionando o Predicado no WHERE */
			criteria.where( idParam );

			Object encontrado = getCurrentSession().createQuery( criteria ).getSingleResult();

			confirmarTransacao();
			return (AbstractPO) encontrado;

		} catch ( javax.persistence.NoResultException e ) {
			return null;
		} catch ( Throwable e ) {
			throw new BackendExceptions( "Erro ao filtrar por Id ", e );
		}
	}

}
