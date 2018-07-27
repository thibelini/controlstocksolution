package br.com.srcsoftware.managers.utilidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utilidades{

	public static String schema = "control_stock_solution_t34";

	public static LocalDate parseLocalDate( String data ) {
		if ( data == null || data.isEmpty() || !data.contains( "/" ) ) {
			return null;
		}

		LocalDate novaData = LocalDate.parse( data, DateTimeFormatter.ofPattern( "dd//MM/yyyy" ) );
		return novaData;
	}

	public static String parseLocalDate( LocalDate data ) {
		if ( data == null ) {
			return null;
		}

		String novaData = data.format( DateTimeFormatter.ofPattern( "dd//MM/yyyy" ) );
		return novaData;
	}

	public static BigDecimal parseBigDecimal( String valor ) {
		if ( valor == null || valor.isEmpty() ) {
			return null;
		}

		BigDecimal novoValor = new BigDecimal( valor.replace( ".", "" ).replaceAll( ",", "." ) );
		return novoValor;
	}

	public static String parseBigDecimal( BigDecimal valor ) {
		if ( valor == null ) {
			return null;
		}

		return String.format( "%,.2f", valor ).trim();
	}

	public static String parseBigDecimal( BigDecimal valor, String moeda ) {
		if ( valor == null ) {
			return null;
		}

		return moeda + " " + String.format( "%,.2f", valor ).trim();
	}
}
