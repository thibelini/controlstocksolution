package br.com.srcsoftware.managers.abstracts;

import java.time.LocalDateTime;

/**
 * 
 * Classe que representa
 *
 *
 * @author Thiago Belini <thibelini@gmail.com.br>
 * @since 27 de jul de 2018 20:16:54
 * @version 1.0
 */

public class AbstractPO{

	private LocalDateTime dataHoraCadastro;

	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro( LocalDateTime dataHoraCadastro ) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

}
