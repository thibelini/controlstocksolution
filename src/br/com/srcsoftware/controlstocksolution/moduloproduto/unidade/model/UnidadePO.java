package br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.model;

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

@Entity
@Table( name = "unidades" )
public final class UnidadePO extends AbstractPO implements Comparable< UnidadePO >{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@Column( length = 20, nullable = false, unique = true )
	private String nome;

	@Column( length = 3, nullable = false )
	private String sigla;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla( String sigla ) {
		this.sigla = sigla;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
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
		if ( !( obj instanceof UnidadePO ) ) {
			return false;
		}
		UnidadePO other = (UnidadePO) obj;
		if ( id == null ) {
			if ( other.id != null ) {
				return false;
			}
		} else if ( !id.equals( other.id ) ) {
			return false;
		}
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
		builder.append( "Unidade [\n\t" );
		if ( id != null ) {
			builder.append( "id=" );
			builder.append( id );
			builder.append( ", \n\t" );
		}
		if ( nome != null ) {
			builder.append( "nome=" );
			builder.append( nome );
			builder.append( ", \n\t" );
		}
		if ( sigla != null ) {
			builder.append( "sigla=" );
			builder.append( sigla );
		}
		builder.append( "]\n" );
		return builder.toString();
	}

	@Override
	public int compareTo( UnidadePO comparar ) {
		Collator ignoraAcentos = Collator.getInstance( new Locale( "pt", "BR" ) );
		return ignoraAcentos.compare( this.getNome(), comparar.getNome() );
	}

}
