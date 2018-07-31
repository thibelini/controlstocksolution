package br.com.srcsoftware.managers.utilidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utilidades{

	public static final String SCHEMA = "control_stock_solution_t34";

	public static final LocalDate parseLocalDate( String data ) {
		if ( data == null || data.isEmpty() || !data.contains( "/" ) ) {
			return null;
		}

		LocalDate novaData = LocalDate.parse( data, DateTimeFormatter.ofPattern( "dd//MM/yyyy" ) );
		return novaData;
	}

	public static final String parseLocalDate( LocalDate data ) {
		if ( data == null ) {
			return null;
		}

		String novaData = data.format( DateTimeFormatter.ofPattern( "dd//MM/yyyy" ) );
		return novaData;
	}

	public static final BigDecimal parseBigDecimal( String valor ) {
		if ( valor == null || valor.isEmpty() ) {
			return null;
		}

		BigDecimal novoValor = new BigDecimal( valor.replace( ".", "" ).replaceAll( ",", "." ) );
		return novoValor;
	}

	public static final String parseBigDecimal( BigDecimal valor ) {
		if ( valor == null ) {
			return null;
		}

		return String.format( "%,.2f", valor ).trim();
	}

	public static final String parseBigDecimal( BigDecimal valor, String moeda ) {
		if ( valor == null ) {
			return null;
		}

		return moeda + " " + String.format( "%,.2f", valor ).trim();
	}
}
