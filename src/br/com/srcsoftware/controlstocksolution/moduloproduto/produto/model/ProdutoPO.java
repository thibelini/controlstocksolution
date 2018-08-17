package br.com.srcsoftware.controlstocksolution.moduloproduto.produto.model;

import java.math.BigDecimal;
import java.text.Collator;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model.CategoriaPO;
import br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.model.UnidadePO;
import br.com.srcsoftware.managers.abstracts.AbstractPO;
import br.com.srcsoftware.managers.utilidades.Utilidades;

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
@Entity
@Table( name = "produtos", uniqueConstraints = @UniqueConstraint( columnNames = { "nome", "idUnidade", "idCategoria" }, name = "PK_produtos_id" ) )
public final class ProdutoPO extends AbstractPO implements Comparable< ProdutoPO >{

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@Column( length = 50, nullable = false )
	private String nome;

	@Column( precision = 8, scale = 2 )
	private BigDecimal preco;

	@ManyToOne( fetch = FetchType.EAGER, optional = false ) //Padrão quando for ManyToOne
	@JoinColumn( name = "idCategoria", foreignKey = @ForeignKey( name = "FK_produto_idCategoria" ) ) //ToOne VEM
	private CategoriaPO categoria;

	@ManyToOne( fetch = FetchType.EAGER, optional = false ) //Padrão quando for ManyToOne
	@JoinColumn( name = "idUnidade", foreignKey = @ForeignKey( name = "FK_produto_idUnidade" ) ) //ToOne VEM
	private UnidadePO unidade;

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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco( BigDecimal preco ) {
		this.preco = preco;
	}

	@Transient
	public String getPrecoToString() {
		if ( getPreco() != null ) {
			return Utilidades.parseBigDecimal( preco );
		}
		return null;
	}

	public void setPrecoToString( String preco ) {
		if ( preco != null && !preco.isEmpty() ) {
			setPreco( Utilidades.parseBigDecimal( preco ) );
			return;
		}
		setPreco( null );
	}

	public CategoriaPO getCategoria() {
		if ( categoria == null ) {
			categoria = new CategoriaPO();
		}
		return categoria;
	}

	public void setCategoria( CategoriaPO categoria ) {
		this.categoria = categoria;
	}

	public UnidadePO getUnidade() {
		if ( unidade == null ) {
			unidade = new UnidadePO();
		}
		return unidade;
	}

	public void setUnidade( UnidadePO unidade ) {
		this.unidade = unidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( categoria == null ) ? 0 : categoria.hashCode() );
		result = prime * result + ( ( nome == null ) ? 0 : nome.hashCode() );
		result = prime * result + ( ( preco == null ) ? 0 : preco.hashCode() );
		result = prime * result + ( ( unidade == null ) ? 0 : unidade.hashCode() );
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
		if ( preco == null ) {
			if ( other.preco != null ) {
				return false;
			}
		} else if ( !preco.equals( other.preco ) ) {
			return false;
		}
		if ( unidade == null ) {
			if ( other.unidade != null ) {
				return false;
			}
		} else if ( !unidade.equals( other.unidade ) ) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append( "ProdutoPO [\n\t" );
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
		if ( preco != null ) {
			builder.append( "preco=" );
			builder.append( preco );
			builder.append( ", \n\t" );
		}
		if ( getCategoria() != null ) {
			builder.append( "getCategoria()=" );
			builder.append( getCategoria() );
			builder.append( ", \n\t" );
		}
		if ( getUnidade() != null ) {
			builder.append( "getUnidade()=" );
			builder.append( getUnidade() );
		}
		builder.append( "]\n" );
		return builder.toString();
	}

	@Override
	public int compareTo( ProdutoPO comparar ) {
		Collator ignoraAcentos = Collator.getInstance( new Locale( "pt", "BR" ) );
		return ignoraAcentos.compare( this.getNome(), comparar.getNome() );
	}

}
