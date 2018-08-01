package br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.controller.testabackend;

import java.time.LocalDateTime;
import java.util.List;

import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.controller.CategoriaFACADE;
import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model.CategoriaPO;

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

		/** Criando uma categoria */
		CategoriaPO po = new CategoriaPO();
		po.setNome( "bebidas" );
		po.setDataHoraCadastro( LocalDateTime.now() );

		/** Inserir Categoria */
		new CategoriaFACADE().inserir( po );

		/** Filtrando todos para saber se inseriu */
		List encontrados = new CategoriaFACADE().filtrar( null );
		System.out.println( encontrados );

		/** Filtrando por ID para alterar */
		CategoriaPO encontrado = (CategoriaPO) new CategoriaFACADE().filtrarPorId( "1" );

		/** Alterar Categoria */
		encontrado.setNome( "Bebidas Alterada" );
		new CategoriaFACADE().alterar( encontrado );

		/** Filtrando por ID para verificar alteraçao e excluir */
		encontrado = (CategoriaPO) new CategoriaFACADE().filtrarPorId( "1" );

		/** Ecluindo */
		new CategoriaFACADE().excluir( encontrado );

		/** Filtrando todos para saber se excluiu */
		encontrados = new CategoriaFACADE().filtrar( null );
		System.out.println( encontrados );

	}

}
