package br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.controller.CategoriaFACADE;
import br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model.CategoriaPO;
import br.com.srcsoftware.managers.exceptions.BackendExceptions;
import br.com.srcsoftware.managers.utilidades.Messages;

/***
 * /**
 * Método responsável por abrir a tela de cadastro de aluno.
 * 
 * Todo médodo da ACTION que será acessivel da tela terá
 * o mesmo RETORNO(ActionForward), mesmos PARAMETROS(ActionMapping mapping,
 * ActionForm form, HttpServletRequest request,
 * HttpServletResponse response) e mesmo RETORNO(mapping.findForward( "nome_do_forward_aqui" ))
 *
 * @param ActionMapping mapping - Variavél que possibilita o ACESSO
 *        á TAG <action-mappings> do struts-config.xml
 * @param ActionForm form - Variavel que contem todos os dados vindos da tela setados em seus ATRIBUTOS
 * @param HttpServletRequest request - Permite recuperar dados da tela sem que seja por intermedio do Struts
 * @param HttpServletResponse response - Permite manipular a tela sem que seja por intermedio do Struts
 * @return ActionForward - Forward referente a tela que deverá ser aberta apos a execução do Metodo. O valor passado como
 *         parametro esta definido na propriedade NAME da TAG <forward> da TAG <action-mappings> do arquivo struts-config.xml.
 *
 * @author Thiago Belini <thibelini@gmail.com.br>
 * @since 10 de ago de 2018 21:57:36
 * @version 1.0
 */

public class CategoriaAction extends DispatchAction{

	public ActionForward abrirTela( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		/* aplicando a Especializacao de ActionForm para CategoriaForm */
		CategoriaForm meuForm = (CategoriaForm) form;

		meuForm.limparTela();

		return filtrar( mapping, meuForm, request, response );
	}

	public ActionForward limpar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		return abrirTela( mapping, form, request, response );
	}

	public ActionForward filtrar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		try {
			/* aplicando a Especializacao de ActionForm para CategoriaForm */
			CategoriaForm meuForm = (CategoriaForm) form;

			List< CategoriaPO > encontrados;

			CategoriaFACADE facade = new CategoriaFACADE();
			encontrados = facade.filtrar( meuForm.getCategoria() );

			meuForm.getCategorias().clear();
			meuForm.getCategorias().addAll( encontrados );

		} catch ( BackendExceptions e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", "Erro Desconhecido: " + e.getMessage() ) );
		}

		return mapping.findForward( "categoriaView" );
	}

	public ActionForward inserir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		try {
			/* aplicando a Especializacao de ActionForm para CategoriaForm */
			CategoriaForm meuForm = (CategoriaForm) form;

			CategoriaFACADE facade = new CategoriaFACADE();
			facade.inserir( meuForm.getCategoria() );

			meuForm.limparTela();
			this.addMessages( request, Messages.createMessages( "mensagem", "Categoria cadastrado com Sucesso!" ) );

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
			/* aplicando a Especializacao de ActionForm para CategoriaForm */
			CategoriaForm meuForm = (CategoriaForm) form;

			CategoriaFACADE facade = new CategoriaFACADE();
			facade.alterar( meuForm.getCategoria() );

			meuForm.limparTela();
			this.addMessages( request, Messages.createMessages( "mensagem", "Categoria atualizada com Sucesso!" ) );

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
			/* aplicando a Especializacao de ActionForm para CategoriaForm */
			CategoriaForm meuForm = (CategoriaForm) form;

			CategoriaFACADE facade = new CategoriaFACADE();
			facade.excluir( meuForm.getCategoria() );

			meuForm.limparTela();
			this.addMessages( request, Messages.createMessages( "mensagem", "Categoria excluida com Sucesso!" ) );

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
			/* aplicando a Especializacao de ActionForm para CategoriaForm */
			CategoriaForm meuForm = (CategoriaForm) form;

			CategoriaPO encontrado;

			CategoriaFACADE facade = new CategoriaFACADE();
			encontrado = (CategoriaPO) facade.filtrarPorId( meuForm.getIdSelecionar() );

			meuForm.setCategoria( encontrado );

		} catch ( BackendExceptions e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", "Erro Desconhecido: " + e.getMessage() ) );
		}

		return mapping.findForward( "categoriaView" );
	}
}
