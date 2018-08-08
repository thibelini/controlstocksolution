package br.com.srcsoftware.managers.connection.teste;

import org.junit.Test;

import br.com.srcsoftware.managers.connection.HibernateConnection;
import br.com.srcsoftware.managers.exceptions.BackendExceptions;

public class TestaConexao{

	@Test
	public void executar() throws BackendExceptions {

		HibernateConnection hibernate = new HibernateConnection();
		try {

			hibernate.iniciarTransacao();

			Object versaoBD = hibernate.getCurrentSession().createNativeQuery( "select @@version" ).getSingleResult();
			System.out.println( versaoBD );

			Object dataBD = hibernate.getCurrentSession().createNativeQuery( "select now()" ).getSingleResult();
			System.out.println( dataBD );

			Object categoriasSQL = hibernate.getCurrentSession().createNativeQuery( "Select * from categorias" ).getResultList();
			System.out.println( categoriasSQL );

			/** Categorias com HQL */
			Object categoriasHQL = hibernate.getCurrentSession().createQuery( "Select c from CategoriaPO c" ).getResultList();
			System.out.println( categoriasHQL );

			hibernate.confirmarTransacao();

		} catch ( BackendExceptions e ) {
			e.printStackTrace();
			hibernate.rollbackTransacao();
		} finally {
			hibernate.destroy();
		}

	}

}
