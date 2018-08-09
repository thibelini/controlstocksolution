package br.com.srcsoftware.controlstocksolution.moduloproduto.produto.dao.testa;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model.CategoriaPO;
import br.com.srcsoftware.controlstocksolution.moduloproduto.produto.dao.ProdutoDAO;
import br.com.srcsoftware.controlstocksolution.moduloproduto.produto.model.ProdutoPO;
import br.com.srcsoftware.managers.abstracts.AbstractPO;
import br.com.srcsoftware.managers.connection.HibernateConnection;
import br.com.srcsoftware.managers.exceptions.BackendExceptions;

public class TesteDAO{

	@Test
	public void executar() throws BackendExceptions {

		HibernateConnection hibernate = new HibernateConnection();

		try {

			/** Testando o Componente de Conexão */
			ProdutoDAO dao = new ProdutoDAO();

			hibernate.iniciarTransacao();
			/** Criando Objeto PO */
			ProdutoPO po = new ProdutoPO();
			po.setNome( "Coca-cola" );
			po.setDataHoraCadastro( LocalDateTime.now() );
			po.setPreco( new BigDecimal( "10.50" ) );
			po.setUnidadeMedida( "UN" );
			po.setCategoria( criarCategotia() );

			/** Inserindo */
			po = (ProdutoPO) hibernate.inserir( po );
			System.out.println( po );
			hibernate.confirmarTransacao();

			hibernate.iniciarTransacao();
			/** Alterando PO */
			po.setNome( "Coca-cola 2" );
			hibernate.alterar( po );
			System.out.println( po );
			hibernate.confirmarTransacao();

			/** Filtrar PO por Id */
			AbstractPO encontrado = hibernate.filtrarPorId( Long.valueOf( "1" ), ProdutoPO.class );
			System.out.println( "Filtrado por Id: " + encontrado );

			/** Filtrar todos */
			ProdutoPO poFiltrar = new ProdutoPO();
			poFiltrar.setNome( "Coca-cola" );
			List< ProdutoPO > encontrados = dao.filtrar( poFiltrar );
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

	private CategoriaPO criarCategotia() throws BackendExceptions {
		HibernateConnection hibernate = new HibernateConnection();

		hibernate.iniciarTransacao();
		/** Criando Objeto PO */
		CategoriaPO po = new CategoriaPO();
		po.setNome( "Bebidas" );
		po.setDataHoraCadastro( LocalDateTime.now() );
		/** Inserindo */
		po = (CategoriaPO) hibernate.inserir( po );
		System.out.println( po );
		hibernate.confirmarTransacao();

		return po;
	}
}
