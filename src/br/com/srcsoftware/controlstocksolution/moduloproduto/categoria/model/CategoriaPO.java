package br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model;

import java.text.Collator;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.srcsoftware.managers.abstracts.AbstractPO;

/**
 * 
 * Classe da camada Model
 *
 * @author Thiago Belini <thibelini@gmail.com.br>
 * @since 24 de jul de 2018 21:58:11
 * @version 1.0
 */

@Entity
@Table( name = "categorias" )
public final class CategoriaPO extends AbstractPO implements Comparable< CategoriaPO >{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@Column( length = 50, nullable = false, unique = true )
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	@Transient
	public String getIdToString() {
		if ( getId() != null ) {
			return id.toString();
		}
		return null;
	}

	public void setIdToString( String id ) {
		if ( id != null && !id.isEmpty() ) {
			setId( Long.valueOf( id ) );
			return;
		}
		setId( null );
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

	@Override
	public int compareTo( CategoriaPO comparar ) {
		Collator ignoraAcentos = Collator.getInstance( new Locale( "pt", "BR" ) );
		return ignoraAcentos.compare( this.getNome(), comparar.getNome() );
	}

}
