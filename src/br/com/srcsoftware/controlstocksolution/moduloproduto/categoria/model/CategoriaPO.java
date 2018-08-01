package br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model;

import br.com.srcsoftware.managers.abstracts.AbstractPO;

/**
 * 
 * Classe da camada Model
 *
 * @author Thiago Belini <thibelini@gmail.com.br>
 * @since 24 de jul de 2018 21:58:11
 * @version 1.0
 */

public final class CategoriaPO extends AbstractPO{

	private Long id;
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( nome == null ) ? 0 : nome.hashCode() );
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj ) {
			return true;
		}
		if ( obj == null ) {
			return false;
		}
		if ( !( obj instanceof CategoriaPO ) ) {
			return false;
		}
		CategoriaPO other = (CategoriaPO) obj;
		if ( nome == null ) {
			if ( other.nome != null ) {
				return false;
			}
		} else if ( !nome.equals( other.nome ) ) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( "CategoriaPO [\n\tid=" );
		builder.append( id );
		builder.append( ", \n\tnome=" );
		builder.append( nome );
		builder.append( ", \n\tgetDataHoraCadastro()=" );
		builder.append( getDataHoraCadastro() );
		builder.append( "]\n" );
		return builder.toString();
	}

}
