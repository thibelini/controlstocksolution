package br.com.srcsoftware.managers.utilidades.teste;

import java.math.BigDecimal;

import br.com.srcsoftware.managers.utilidades.Utilidades;

public class TesteUtilidade{

	public static void main( String[ ] args ) {

		Utilidades util = new Utilidades();

		System.out.println( Utilidades.parseBigDecimal( new BigDecimal( "1987.96" ), "R$" ) );

	}

}
