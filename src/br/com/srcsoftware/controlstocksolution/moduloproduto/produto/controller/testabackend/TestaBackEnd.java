package br.com.srcsoftware.controlstocksolution.moduloproduto.produto.controller.testabackend;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.controller.CategoriaFACADE;
import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model.CategoriaPO;
import br.com.srcsoftware.controlstocksolution.moduloproduto.produto.controller.ProdutoFACADE;
import br.com.srcsoftware.controlstocksolution.moduloproduto.produto.model.ProdutoPO;
import br.com.srcsoftware.managers.exceptions.BackendExceptions;

/**
 * 
 * Classe que representa
 *
 *
 * @author Thiago Belini <thibelini@gmail.com.br>
 * @since 31 de jul de 2018 21:52:10
 * @version 1.0
 */

public final class TestaBackEnd{

	public static void main( String[ ] args ) {

		try {
			/** Criando uma produto */
			ProdutoPO po = new ProdutoPO();
			po.setNome( "Coca Cola" );
			po.setDataHoraCadastro( LocalDateTime.now() );
			po.setPreco( new BigDecimal( "12.90" ) );
			po.setUnidadeMedida( "UN" );
			po.setCategoria( criarCategoria() );

			/** Inserir Produto */
			new ProdutoFACADE().inserir( po );

			/** Filtrando todos para saber se inseriu */
			List encontrados = new ProdutoFACADE().filtrar( null );
			System.out.println( encontrados );

			/** Filtrando por ID para alterar */
			ProdutoPO encontrado = (ProdutoPO) new ProdutoFACADE().filtrarPorId( "1" );

			/** Alterar Produto */
			encontrado.setNome( "Coca Cola Alterada" );
			new ProdutoFACADE().alterar( encontrado );

			/** Filtrando por ID para verificar alteraçao e excluir */
			encontrado = (ProdutoPO) new ProdutoFACADE().filtrarPorId( "1" );

			/** Ecluindo */
			new ProdutoFACADE().excluir( encontrado );

			/** Filtrando todos para saber se excluiu */
			encontrados = new ProdutoFACADE().filtrar( null );
			System.out.println( encontrados );

		} catch ( BackendExceptions e ) {
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getMessage() );
		} catch ( Exception e ) {
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getMessage() );
		}

	}

	private static CategoriaPO criarCategoria() throws BackendExceptions {
		CategoriaPO po = new CategoriaPO();
		po.setDataHoraCadastro( LocalDateTime.now() );
		po.setNome( "Bebidas" );
		new CategoriaFACADE().inserir( po );
		return po;
	}

}
