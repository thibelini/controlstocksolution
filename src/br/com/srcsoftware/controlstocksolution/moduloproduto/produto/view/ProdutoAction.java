package br.com.srcsoftware.controlstocksolution.moduloproduto.produto.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import br.com.srcsoftware.controlstocksolution.moduloproduto.produto.controller.ProdutoFACADE;
import br.com.srcsoftware.controlstocksolution.moduloproduto.produto.model.ProdutoPO;
import br.com.srcsoftware.managers.exceptions.BackendExceptions;
import br.com.srcsoftware.managers.utilidades.Messages;

public class ProdutoAction extends DispatchAction{

	public ActionForward abrirTela( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		/* aplicando a Especializacao de ActionForm para ProdutoForm */
		ProdutoForm meuForm = (ProdutoForm) form;

		meuForm.limparTela();

		return filtrar( mapping, meuForm, request, response );
	}

	public ActionForward limpar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		return abrirTela( mapping, form, request, response );
	}

	public ActionForward filtrar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		try {
			/* aplicando a Especializacao de ActionForm para ProdutoForm */
			ProdutoForm meuForm = (ProdutoForm) form;

			List< ProdutoPO > encontrados;

			ProdutoFACADE facade = new ProdutoFACADE();
			encontrados = facade.filtrar( meuForm.getProduto() );

			meuForm.getProdutos().clear();
			meuForm.getProdutos().addAll( encontrados );

		} catch ( BackendExceptions e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", "Erro Desconhecido: " + e.getMessage() ) );
		}

		return mapping.findForward( "produtoView" );
	}

	public ActionForward inserir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		try {
			/* aplicando a Especializacao de ActionForm para ProdutoForm */
			ProdutoForm meuForm = (ProdutoForm) form;

			ProdutoFACADE facade = new ProdutoFACADE();
			facade.inserir( meuForm.getProduto() );

			meuForm.limparTela();
			this.addMessages( request, Messages.createMessages( "mensagem", "Produto cadastrado com Sucesso!" ) );

		} catch ( BackendExceptions e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", "Erro Desconhecido: " + e.getMessage() ) );
		}

		return filtrar( mapping, form, request, response );
	}

	public ActionForward alterar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		try {
			/* aplicando a Especializacao de ActionForm para ProdutoForm */
			ProdutoForm meuForm = (ProdutoForm) form;

			ProdutoFACADE facade = new ProdutoFACADE();
			facade.alterar( meuForm.getProduto() );

			meuForm.limparTela();
			this.addMessages( request, Messages.createMessages( "mensagem", "Produto atualizado com Sucesso!" ) );

		} catch ( BackendExceptions e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", "Erro Desconhecido: " + e.getMessage() ) );
		}

		return filtrar( mapping, form, request, response );
	}

	public ActionForward excluir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		try {
			/* aplicando a Especializacao de ActionForm para ProdutoForm */
			ProdutoForm meuForm = (ProdutoForm) form;

			ProdutoFACADE facade = new ProdutoFACADE();
			facade.excluir( meuForm.getProduto() );

			meuForm.limparTela();
			this.addMessages( request, Messages.createMessages( "mensagem", "Produto excluido com Sucesso!" ) );

		} catch ( BackendExceptions e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", "Erro Desconhecido: " + e.getMessage() ) );
		}

		return filtrar( mapping, form, request, response );
	}

	public ActionForward selecionar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		try {
			/* aplicando a Especializacao de ActionForm para ProdutoForm */
			ProdutoForm meuForm = (ProdutoForm) form;

			ProdutoPO encontrado;

			ProdutoFACADE facade = new ProdutoFACADE();
			encontrado = (ProdutoPO) facade.filtrarPorId( meuForm.getIdSelecionar() );

			meuForm.setProduto( encontrado );

		} catch ( BackendExceptions e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", "Erro Desconhecido: " + e.getMessage() ) );
		}

		return mapping.findForward( "produtoView" );
	}
}
