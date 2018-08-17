<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Cadastro de Produto</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
	
		<html:form action="produtoAction.do" method="post" styleId="tagForm"> 
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
						<div class="form-group col-lg-1 col-md-1 col-sm-12 col-xs-12">
							<label>Código</label>
							<html:text styleClass="form-control input-md bloqueado" name="produtoForm" property="produto.idToString" styleId="id"/>
						</div>
						<div class="form-group col-lg-2 col-md-2 col-sm-12 col-xs-12">
							<label>Data Cadastro</label>
							<html:text styleClass="form-control input-md bloqueado" name="produtoForm" property="produto.dataHoraCadastroToString" styleId="dataHoraCadastro"/>
						</div>
						<div class="form-group col-lg-3 col-md-3 col-sm-12 col-xs-12">
							<label>Nome</label>
							<html:text styleClass="form-control input-md obrigatorio" name="produtoForm" property="produto.nome" styleId="nome"/>
						</div>
						<div class="form-group col-lg-2 col-md-2 col-sm-12 col-xs-12">
							<label>Preço</label>
							<html:text styleClass="form-control input-md obrigatorio dinheiro" name="produtoForm" property="produto.precoToString" styleId="preco"/>
						</div>
						
						<div class="form-group col-lg-2 col-md-2 col-sm-12 col-xs-12">
							<label>Categoria</label>
							<html:select styleClass="form-control input-md obrigatorio" name="produtoForm" property="produto.categoria.idToString" styleId="categoria">
							<html:option value="">Selecione...</html:option>
							<html:optionsCollection name="produtoForm" property="comboCategorias" label="label"  value="value"  />
							</html:select>
						</div>
						<div class="form-group col-lg-2 col-md-2 col-sm-12 col-xs-12">
							<label>Unidade</label>
							<html:select styleClass="form-control input-md obrigatorio" name="produtoForm" property="produto.unidade.idToString" styleId="unidade">
							<html:option value="">Selecione...</html:option>
							<html:optionsCollection name="produtoForm" property="comboUnidades" label="label"  value="value"  />
							</html:select>
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
										<th>Preço</th>
										<th>Unidade</th>
										<th>Categoria</th>
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
									<logic:iterate id="produtoCorrente" indexId="i" name="produtoForm" property="produtos" type="br.com.srcsoftware.controlstocksolution.moduloproduto.produto.model.ProdutoPO">
										<tr>
											<td>${ produtoCorrente.idToString }</td>
											<td>${ produtoCorrente.nome }</td>
											<td>${ produtoCorrente.dataHoraCadastroToString }</td>
											<td>${ produtoCorrente.precoToString }</td>
											<td>${ produtoCorrente.unidade.sigla }</td>
											<td>${ produtoCorrente.categoria.nome }</td>
											<td class="text-center">
												<a href="${rootWeb }/produtoAction.do?method=selecionar&idSelecionar=${ produtoCorrente.idToString }">
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
						<logic:empty name="produtoForm" property="produto.idToString">
							<div class="form-group col-xs-12 col-sm-12 col-md-1 col-lg-1">
								<button type="submit" class="btn btn-success" id="inserir">
									<i class="glyphicon glyphicon-floppy-save"></i>
									Inserir
								</button>
							</div>
						</logic:empty>
						<logic:notEmpty name="produtoForm" property="produto.idToString">
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
			.prop('placeholder', 'Nome do Produto');
		
		$("#unidadeMedida")
			.prop('maxlength', 3)
			.prop('placeholder', 'Unidade');
		
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
				message : 'Deseja Excluir a Categoria?',
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