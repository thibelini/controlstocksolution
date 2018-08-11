package br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.view;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model.CategoriaPO;

public final class CategoriaForm extends ActionForm{

	private CategoriaPO categoria;
	private ArrayList< CategoriaPO > categorias;

	public CategoriaPO getCategoria() {
		/* Singleton */
		if ( categoria == null ) {
			categoria = new CategoriaPO();
		}
		return categoria;
	}

	public void setCategoria( CategoriaPO categoria ) {
		this.categoria = categoria;
	}

	public ArrayList< CategoriaPO > getCategorias() {
		if ( categoria == null ) {
			categorias = new ArrayList< CategoriaPO >();
		}
		return categorias;
	}

	public void setCategorias( ArrayList< CategoriaPO > categorias ) {
		this.categorias = categorias;
	}

	public void limparTela() {
		setCategoria( null );
		getCategorias().clear();
	}

}