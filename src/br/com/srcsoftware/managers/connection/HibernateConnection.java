package br.com.srcsoftware.managers.connection;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
}
