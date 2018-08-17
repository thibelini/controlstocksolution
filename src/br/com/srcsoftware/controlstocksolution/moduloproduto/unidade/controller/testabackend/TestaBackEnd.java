package br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.controller.testabackend;

import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.controller.UnidadeFACADE;
import br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.model.UnidadePO;
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
			/** Criando uma unidade */
			UnidadePO po = new UnidadePO();
			po.setNome( "Unidade" );
			po.setSigla( "UN" );
			po.setDataHoraCadastro( LocalDateTime.now() );

			/** Inserir Unidade */
			new UnidadeFACADE().inserir( po );

			/** Filtrando todos para saber se inseriu */
			List encontrados = new UnidadeFACADE().filtrar( null );
			System.out.println( encontrados );

			/** Filtrando por ID para alterar */
			UnidadePO encontrado = (UnidadePO) new UnidadeFACADE().filtrarPorId( "1" );

			/** Alterar Unidade */
			encontrado.setNome( "Unidade Alterada" );
			new UnidadeFACADE().alterar( encontrado );

			/** Filtrando por ID para verificar alteraçao e excluir */
			encontrado = (UnidadePO) new UnidadeFACADE().filtrarPorId( "1" );

			/** Ecluindo */
			new UnidadeFACADE().excluir( encontrado );

			/** Filtrando todos para saber se excluiu */
			encontrados = new UnidadeFACADE().filtrar( null );
			System.out.println( encontrados );
		} catch ( BackendExceptions e ) {
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getMessage() );
		} catch ( Exception e ) {
			e.printStackTrace();
			JOptionPane.showMessageDialog( null, e.getMessage() );
		}

	}

}
