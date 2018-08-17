<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Cadastro da Unidade do Produto</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
	
		<html:form action="unidadeAction.do" method="post" styleId="tagForm"> 
			<html:hidden property="method" value="nada" styleId="method"/>	
							<div class="row">
	
					<logic:messagesPresent message="false">
						<div class="alert alert-danger">
							<html:messages id="message" message="false">
								<bean:write name="message" filter="false" />
							</html:messages>
						</div>
					</logic:messagesPresent>
					<logic:messagesPresent message="true">
						<div class="alert alert-success">
							<html:messages id="message" message="true">
								<bean:write name="message" filter="false" />
							</html:messages>
						</div>
					</logic:messagesPresent>
			
				</div>
			<div class="panel panel-primary">
				<div class="panel-body">
					<div class="row">
						<div class="form-group col-lg-2 col-md-3 col-sm-12 col-xs-12">
							<label>Código</label>
							<html:text styleClass="form-control input-md bloqueado" name="unidadeForm" property="unidade.idToString" styleId="id"/>
						</div>
						<div class="form-group col-lg-2 col-md-3 col-sm-12 col-xs-12">
							<label>Data Cadastro</label>
							<html:text styleClass="form-control input-md bloqueado" name="unidadeForm" property="unidade.dataHoraCadastroToString" styleId="dataHoraCadastro"/>
						</div>
						<div class="form-group col-lg-7 col-md-3 col-sm-12 col-xs-12">
							<label>Nome</label>
							<html:text styleClass="form-control input-md obrigatorio" name="unidadeForm" property="unidade.nome" styleId="nome"/>
						</div>
						<div class="form-group col-lg-1 col-md-3 col-sm-12 col-xs-12">
							<label>Sigla</label>
							<html:text styleClass="form-control input-md obrigatorio" name="unidadeForm" property="unidade.sigla" styleId="sigla"/>
						</div>
					</div>
					<div class="row">
						<div class="table-responsive col-lg-12">
							<table class="table table-striped table-bordered table-hover">
								<thead>
									<tr class="bg-primary">
										<th>Código</th>
										<th>Nome</th>
										<th>Data Cadastro</th>
										<th>Sigla</th>
										<th>Ação</th>
									</tr>
								</thead>
								<tbody>
								<!-- PROPRIEDADES:
								id - Objeto corrente do FOR
								indexId - è o contador como por exemplo o (i)
								name - Nome do Form onde a lista esta
								property - Nome do atributo que representa a lista
								type = Tipo do Objeto que esta dentro(ArrayList<type>) da lista -->
									<logic:iterate id="unidadeCorrente" indexId="i" name="unidadeForm" property="unidades" type="br.com.srcsoftware.controlstocksolution.moduloproduto.unidade.model.UnidadePO">
										<tr>
											<td>${ unidadeCorrente.idToString }</td>
											<td>${ unidadeCorrente.nome }</td>
											<td>${ unidadeCorrente.dataHoraCadastroToString }</td>
											<td>${ unidadeCorrente.sigla }</td>
											<td class="text-center">
												<a href="${rootWeb }/unidadeAction.do?method=selecionar&idSelecionar=${ unidadeCorrente.idToString }">
													<i class="btn btn-xs btn-primary btn-outline glyphicon glyphicon-edit"></i>
												</a>
											</td>
										</tr>
									</logic:iterate>
								</tbody>
							</table>
						</div>
					</div>	
				</div>
				<div class="panel-footer">
					<div class="row">
						<logic:empty name="unidadeForm" property="unidade.idToString">
							<div class="form-group col-xs-12 col-sm-12 col-md-1 col-lg-1">
								<button type="submit" class="btn btn-success" id="inserir">
									<i class="glyphicon glyphicon-floppy-save"></i>
									Inserir
								</button>
							</div>
						</logic:empty>
						<logic:notEmpty name="unidadeForm" property="unidade.idToString">
							<div class="form-group col-xs-12 col-sm-12 col-md-1 col-lg-1">
								<button type="submit" class="btn btn-primary" id="alterar">
									<i class="glyphicon glyphicon-floppy-retweet"></i>
									Alterar
								</button>
							</div>
							<div class="form-group col-xs-12 col-sm-12 col-md-1 col-lg-1">
								<button type="button" class="btn btn-danger" id="excluir">
									<i class="glyphicon glyphicon-floppy-remove"></i>
									Excluir
								</button>
							</div>
						</logic:notEmpty>
						<div class="form-group col-xs-12 col-sm-12 col-md-1 col-lg-1">
							<button type="button" class="btn btn-info" id="filtrar">
								<i class="glyphicon glyphicon-zoom-out"></i>
								Filtrar
							</button>
						</div>
						<div class="form-group col-xs-12 col-sm-12 col-md-1 col-lg-1">
							<button type="button" class="btn btn-warning" id="limpar">
								<i class="glyphicon glyphicon-erase"></i>
								Limpar
							</button>
						</div>
					</div> 
				</div>
			</div>
		
		</html:form>
	</div>
</div>

<jsp:include page="../../templates/imports/imports-js.jsp"></jsp:include>

<script type="text/javascript">
	
	$("document").ready(function(){
		$("#nome")
			.focus()
			.prop('maxlength', 20)
			.prop('placeholder', 'Nome da Unidade');
		
		$("#sigla")
			.prop('maxlength', 3)
			.prop('placeholder', 'Sigla');
		
		$("#tagForm").attr('autocomplete','off');
		
		$('#inserir').on('click', function(){
			$("#method").val('inserir');
		});

		$('#alterar').on('click', function(){
			$("#method").val('alterar');
		});
		
		$('#excluir').on('click', function(){
			//alert('');
			BootstrapDialog.show({
				size  : BootstrapDialog.SIZE_LARGE,
				title : 'Atenção',
				message : 'Deseja Excluir a Unidade?',
				closable : true,
				type : BootstrapDialog.TYPE_DANGER,
				buttons:[
					{label : 'Sim', 
						action : function(dialogRef){
							$("#method").val('excluir');
							$("#tagForm").submit();
							dialogRef.close();
						} 
					},
					{label : 'Não', 
						action : function(dialogRef){
							dialogRef.close();
						} 
					}
				]
			});
		});
		
		$('#filtrar').on('click', function(){
			$('#filtrar').on('click', function(){
				$("#method").val('filtrar');
				$("#tagForm").submit();
			});
		});

		$('#limpar').on('click', function(){
			$("#method").val('limpar');
			$("#tagForm").submit();
		});
		
	});
	
</script>