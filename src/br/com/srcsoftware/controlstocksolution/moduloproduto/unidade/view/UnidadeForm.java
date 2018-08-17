package br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.view;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.model.UnidadePO;

public final class UnidadeForm extends ActionForm{

	private String idSelecionar;
	private UnidadePO unidade;
	private ArrayList< UnidadePO > unidades;

	public UnidadePO getUnidade() {
		/* Singleton */
		if ( unidade == null ) {
			unidade = new UnidadePO();
		}
		return unidade;
	}

	public void setUnidade( UnidadePO unidade ) {
		this.unidade = unidade;
	}

	public ArrayList< UnidadePO > getUnidades() {
		if ( unidade == null ) {
			unidades = new ArrayList< UnidadePO >();
		}
		return unidades;
	}

	public void setUnidades( ArrayList< UnidadePO > unidades ) {
		this.unidades = unidades;
	}

	public String getIdSelecionar() {
		return idSelecionar;
	}

	public void setIdSelecionar( String idSelecionar ) {
		this.idSelecionar = idSelecionar;
	}

	public void limparTela() {
		setIdSelecionar( null );
		setUnidade( null );
		getUnidades().clear();
	}

}
