package br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.controller.UnidadeFACADE;
import br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.model.UnidadePO;
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

public class UnidadeAction extends DispatchAction{

	public ActionForward abrirTela( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		/* aplicando a Especializacao de ActionForm para UnidadeForm */
		UnidadeForm meuForm = (UnidadeForm) form;

		meuForm.limparTela();

		return filtrar( mapping, meuForm, request, response );
	}

	public ActionForward limpar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		return abrirTela( mapping, form, request, response );
	}

	public ActionForward filtrar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		try {
			/* aplicando a Especializacao de ActionForm para UnidadeForm */
			UnidadeForm meuForm = (UnidadeForm) form;

			List< UnidadePO > encontrados;

			UnidadeFACADE facade = new UnidadeFACADE();
			encontrados = facade.filtrar( meuForm.getUnidade() );

			meuForm.getUnidades().clear();
			meuForm.getUnidades().addAll( encontrados );

		} catch ( BackendExceptions e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", "Erro Desconhecido: " + e.getMessage() ) );
		}

		return mapping.findForward( "unidadeView" );
	}

	public ActionForward inserir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		try {
			/* aplicando a Especializacao de ActionForm para UnidadeForm */
			UnidadeForm meuForm = (UnidadeForm) form;

			UnidadeFACADE facade = new UnidadeFACADE();
			facade.inserir( meuForm.getUnidade() );

			meuForm.limparTela();
			this.addMessages( request, Messages.createMessages( "mensagem", "Unidade cadastrado com Sucesso!" ) );

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
			/* aplicando a Especializacao de ActionForm para UnidadeForm */
			UnidadeForm meuForm = (UnidadeForm) form;

			UnidadeFACADE facade = new UnidadeFACADE();
			facade.alterar( meuForm.getUnidade() );

			meuForm.limparTela();
			this.addMessages( request, Messages.createMessages( "mensagem", "Unidade atualizada com Sucesso!" ) );

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
			/* aplicando a Especializacao de ActionForm para UnidadeForm */
			UnidadeForm meuForm = (UnidadeForm) form;

			UnidadeFACADE facade = new UnidadeFACADE();
			facade.excluir( meuForm.getUnidade() );

			meuForm.limparTela();
			this.addMessages( request, Messages.createMessages( "mensagem", "Unidade excluida com Sucesso!" ) );

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
			/* aplicando a Especializacao de ActionForm para UnidadeForm */
			UnidadeForm meuForm = (UnidadeForm) form;

			UnidadePO encontrado;

			UnidadeFACADE facade = new UnidadeFACADE();
			encontrado = (UnidadePO) facade.filtrarPorId( meuForm.getIdSelecionar() );

			meuForm.setUnidade( encontrado );

		} catch ( BackendExceptions e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", e.getMessage() ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addErrors( request, Messages.createMessages( "erro", "Erro Desconhecido: " + e.getMessage() ) );
		}

		return mapping.findForward( "unidadeView" );
	}
}
