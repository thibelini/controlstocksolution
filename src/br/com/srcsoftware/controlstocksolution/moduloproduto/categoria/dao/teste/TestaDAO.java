package br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.dao.teste;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.dao.CategoriaDAO;
import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model.CategoriaPO;
import br.com.srcsoftware.managers.abstracts.AbstractPO;
import br.com.srcsoftware.managers.connection.HibernateConnection;
import br.com.srcsoftware.managers.exceptions.BackendExceptions;

public class TestaDAO{

	@Test
	public void executar() throws BackendExceptions {

		HibernateConnection hibernate = new HibernateConnection();

		try {

			/** Testando o Componente de Conexão */
			CategoriaDAO dao = new CategoriaDAO();

			hibernate.iniciarTransacao();
			/** Criando Objeto PO */
			CategoriaPO po = new CategoriaPO();
			po.setNome( "Bebidas" );
			po.setDataHoraCadastro( LocalDateTime.now() );
			/** Inserindo */
			po = (CategoriaPO) hibernate.inserir( po );
			System.out.println( po );
			hibernate.confirmarTransacao();

			hibernate.iniciarTransacao();
			/** Alterando PO */
			po.setNome( "Bebidas 2" );
			hibernate.alterar( po );
			System.out.println( po );
			hibernate.confirmarTransacao();

			/** Filtrar PO por Id */
			AbstractPO encontrado = hibernate.filtrarPorId( Long.valueOf( "1" ), CategoriaPO.class );
			System.out.println( "Filtrado por Id: " + encontrado );

			/** Filtrar todos */
			CategoriaPO poFiltrar = new CategoriaPO();
			poFiltrar.setNome( "teste" );
			List< CategoriaPO > encontrados = dao.filtrar( poFiltrar );
			System.out.println( "Filtrar: " + encontrados );

			hibernate.iniciarTransacao();
			/** Excluindo PO */
			hibernate.excluir( po );
			hibernate.confirmarTransacao();

		} catch ( BackendExceptions e ) {
			e.printStackTrace();
			hibernate.rollbackTransacao();
		}

	}

}
