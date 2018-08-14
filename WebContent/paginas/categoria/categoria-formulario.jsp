<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Cadastro de Categoria</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
	
		<html:form action="categoriaAction.do" method="post" styleId="tagForm"> 
			<html:hidden property="method" value="nada" styleId="method"/>	
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<div class="form-group col-lg-2 col-md-2 col-sm-12 col-xs-12">
							<label>Código</label>
							<html:text styleClass="form-control input-md" name="categoriaForm" property="categoria.idToString" styleId="id"/>
						</div>
					</div>	
					<div class="row">
						<div class="form-group col-lg-5 col-md-12 col-sm-12 col-xs-12">
							<label>Nome</label>
							<html:text styleClass="form-control input-md" name="categoriaForm" property="categoria.nome" styleId="nome"/>
						</div>
					</div>
					<div class="row">
						<div class="table-responsive col-lg-12">
							<table class="table table-striped table-bordered table-hover">
								<thead>
									<tr class="bg-primary">
										<th>Código</th>
										<th>Nome</th>
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
									<logic:iterate id="categoriaCorrente" indexId="i" name="categoriaForm" property="categorias" type="br.com.srcsoftware.controlstocksolution.moduloproduto.categoria.model.CategoriaPO">
										<tr>
											<td>${ categoriaCorrente.idToString }</td>
											<td>${ categoriaCorrente.nome }</td>
											<td class="text-center">
												<a href="${rootWeb }/categoriaAction.do?method=selecionar&idSelecionar=${ categoriaCorrente.idToString }">
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
						<logic:empty name="categoriaForm" property="categoria.idToString">
							<div class="form-group col-xs-12 col-sm-12 col-md-3 col-lg-3">
								<button type="submit" class="btn btn-success" id="inserir">
									<i class="glyphicon glyphicon-floppy-save"></i>
									Inserir
								</button>
							</div>
						</logic:empty>
						<logic:notEmpty name="categoriaForm" property="categoria.idToString">
							<div class="form-group col-xs-12 col-sm-12 col-md-3 col-lg-3">
								<button type="submit" class="btn btn-primary" id="alterar">
									<i class="glyphicon glyphicon-floppy-retweet"></i>
									Alterar
								</button>
							</div>
							<div class="form-group col-xs-12 col-sm-12 col-md-3 col-lg-3">
								<button type="button" class="btn btn-danger" id="excluir">
									<i class="glyphicon glyphicon-floppy-remove"></i>
									Excluir
								</button>
							</div>
						</logic:notEmpty>
						<div class="form-group col-xs-12 col-sm-12 col-md-3 col-lg-3">
							<button type="button" class="btn btn-info" id="filtrar">
								<i class="glyphicon glyphicon-zoom-out"></i>
								Filtrar
							</button>
						</div>
						<div class="form-group col-xs-12 col-sm-12 col-md-3 col-lg-3">
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
		$("#nome").focus();
		$("#tagForm").attr('autocomplete','off');
		$("#id").prop('disabled', true);
		
	});
	
</script>