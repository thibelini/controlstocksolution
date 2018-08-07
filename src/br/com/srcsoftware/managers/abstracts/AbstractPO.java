package br.com.srcsoftware.managers.abstracts;

/**
 * @MappedSuperclass: Informa ao Hibernate que esta classe não
 *                    possuira Tabela, ela é apenas uma SuperClasse
 * 
 *                    OU SEJA
 * 
 *                    Mapeia esta classe como apenas uma classe de Herança, onde todos
 *                    seu atributos serão implementados nas tabelas que representam as
 *                    classes FILHAS
 */

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 
 * Classe que representa
 *
 *
 * @author Thiago Belini <thibelini@gmail.com.br>
 * @since 27 de jul de 2018 20:16:54
 * @version 1.0
 */

@MappedSuperclass
public abstract class AbstractPO{

	@Column( name = "dataHoraCadastro", nullable = false )
	private LocalDateTime dataHoraCadastro;

	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro( LocalDateTime dataHoraCadastro ) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	@Override
	public abstract String toString();

	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals( Object obj );

}
