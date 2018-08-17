package br.com.srcsoftware.controlstocksolution.moduloproduto.produto.view;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.util.LabelValueBean;

import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.controller.CategoriaFACADE;
import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model.CategoriaPO;
import br.com.srcsoftware.controlstocksolution.moduloproduto.produto.model.ProdutoPO;
import br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.controller.UnidadeFACADE;
import br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.model.UnidadePO;
import br.com.srcsoftware.managers.exceptions.BackendExceptions;

public final class ProdutoForm extends ActionForm{

	private ProdutoPO produto;
	private ArrayList< ProdutoPO > produtos;
	private String idSelecionar;

	public ProdutoPO getProduto() {
		if ( produto == null ) {
			produto = new ProdutoPO();
		}
		return produto;
	}

	public void setProduto( ProdutoPO produto ) {
		this.produto = produto;
	}

	public ArrayList< ProdutoPO > getProdutos() {
		if ( produto == null ) {
			produtos = new ArrayList< ProdutoPO >();
		}
		return produtos;
	}

	public void setProdutos( ArrayList< ProdutoPO > produtos ) {
		this.produtos = produtos;
	}

	public String getIdSelecionar() {
		return idSelecionar;
	}

	public void setIdSelecionar( String idSelecionar ) {
		this.idSelecionar = idSelecionar;
	}

	public ArrayList< LabelValueBean > getComboCategorias() {

		ArrayList< LabelValueBean > options = new ArrayList<>();

		try {

			CategoriaFACADE facade = new CategoriaFACADE();
			List< CategoriaPO > categorias = facade.filtrar( null );

			/** Montando a lista de LabelValueBenas para enviar ao JSP */
			for ( CategoriaPO categoriaCorrente : categorias ) {
				LabelValueBean labelValue = new LabelValueBean();
				labelValue.setLabel( categoriaCorrente.getNome() );
				labelValue.setValue( categoriaCorrente.getIdToString() );
				options.add( labelValue );

			}

		} catch ( BackendExceptions e ) {
			e.printStackTrace();
		}

		return options;

	}

	public ArrayList< LabelValueBean > getComboUnidades() {

		ArrayList< LabelValueBean > options = new ArrayList<>();

		try {

			UnidadeFACADE facade = new UnidadeFACADE();
			List< UnidadePO > unidades = facade.filtrar( null );

			/** Montando a lista de LabelValueBenas para enviar ao JSP */
			for ( UnidadePO unidadeCorrente : unidades ) {
				LabelValueBean labelValue = new LabelValueBean();
				labelValue.setLabel( unidadeCorrente.getSigla() );
				labelValue.setValue( unidadeCorrente.getIdToString() );
				options.add( labelValue );

			}

		} catch ( BackendExceptions e ) {
			e.printStackTrace();
		}

		return options;

	}

	public void limparTela() {
		setIdSelecionar( null );
		setProduto( null );
		getProdutos().clear();
	}

}
