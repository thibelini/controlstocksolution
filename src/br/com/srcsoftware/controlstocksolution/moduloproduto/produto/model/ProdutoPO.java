package br.com.srcsoftware.controlstocksolution.moduloproduto.produto.model;

import java.math.BigDecimal;
import java.text.Collator;
import java.util.Locale;

import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model.CategoriaPO;
import br.com.srcsoftware.managers.abstracts.AbstractPO;

/**
 * 
 * Classe que representa a essencia de um produto
 * Classe da camada Model que representa a parte de persistencia do produto
 *
 *
 * @author Thiago Belini <thibelini@gmail.com.br>
 * @since 24 de jul de 2018 22:01:34
 * @version 1.0
 */

public final class ProdutoPO extends AbstractPO implements Comparable< ProdutoPO >{
	private Long id;
	private String nome;
	private BigDecimal preco;
	private String unidadeMedida;
	private CategoriaPO categoria;

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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco( BigDecimal preco ) {
		this.preco = preco;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida( String unidadeMedida ) {
		this.unidadeMedida = unidadeMedida;
	}

	public CategoriaPO getCategoria() {
		return categoria;
	}

	public void setCategoria( CategoriaPO categoria ) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( categoria == null ) ? 0 : categoria.hashCode() );
		result = prime * result + ( ( nome == null ) ? 0 : nome.hashCode() );
		result = prime * result + ( ( unidadeMedida == null ) ? 0 : unidadeMedida.hashCode() );
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
		if ( !( obj instanceof ProdutoPO ) ) {
			return false;
		}
		ProdutoPO other = (ProdutoPO) obj;
		if ( categoria == null ) {
			if ( other.categoria != null ) {
				return false;
			}
		} else if ( !categoria.equals( other.categoria ) ) {
			return false;
		}
		if ( nome == null ) {
			if ( other.nome != null ) {
				return false;
			}
		} else if ( !nome.equals( other.nome ) ) {
			return false;
		}
		if ( unidadeMedida == null ) {
			if ( other.unidadeMedida != null ) {
				return false;
			}
		} else if ( !unidadeMedida.equals( other.unidadeMedida ) ) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( "ProdutoPO [\n\tid=" );
		builder.append( id );
		builder.append( ", \n\tnome=" );
		builder.append( nome );
		builder.append( ", \n\tpreco=" );
		builder.append( preco );
		builder.append( ", \n\tunidadeMedida=" );
		builder.append( unidadeMedida );
		builder.append( ", \n\tcategoria=" );
		builder.append( categoria );
		builder.append( ", \n\tgetDataHoraCadastro()=" );
		builder.append( getDataHoraCadastro() );
		builder.append( "]\n" );
		return builder.toString();
	}

	@Override
	public int compareTo( ProdutoPO comparar ) {
		Collator ignoraAcentos = Collator.getInstance( new Locale( "pt", "BR" ) );
		return ignoraAcentos.compare( this.getNome(), comparar.getNome() );
	}

}
