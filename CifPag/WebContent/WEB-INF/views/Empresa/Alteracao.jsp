<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="br.com.cifpag.uteis.ConexaoEntityFactory"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="java.util.List"%>

<%@page
	import="br.com.cifpag.daoGenericos.EmpresaDaoImplementacao"%>
<%@page import="br.com.cifpag.daoGenericos.EmpresaDao"%>
<%@page import="br.com.cifpag.entity.Empresa"%>

<%
EmpresaDao empresaDAO = new EmpresaDaoImplementacao();
Empresa empresa = empresaDAO.getById(Empresa.class, Integer.parseInt(request.getAttribute("id").toString()));
%>

<c:set var="bodyContent">


	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li><a href="/CifPag/dashboard/index">Dashboard</a>
				<i class="fa fa-circle"></i></li>
			<li><a href="/CifPag/Empresa/Consulta">Empresa Consulta</a>
				<i class="fa fa-circle"></i></li>
			<li><span>Alteração</span></li>
		</ul>
		<div class="page-toolbar"></div>
	</div>

	<!-- END PAGE BAR -->
	<!-- BEGIN PAGE TITLE-->
	<h1 class="page-title">
		Alteração de Empresa <small>Campos Obrigatórios (*)</small>
	</h1>
	<!-- END PAGE TITLE-->
	<!-- END PAGE HEADER-->

	<div class="row">
		<div class="col-md-12">
			<!-- BEGIN VALIDATION STATES-->
			<div class="portlet light portlet-fit portlet-form bordered"
				id="form_wizard_1">

				<div class="row">
					<div class="col-md-12">
						<!-- BEGIN VALIDATION STATES-->
						<div class="portlet light portlet-fit portlet-form bordered">

							<div class="portlet-body">
								<!-- BEGIN FORM-->
								<form action="/CifPag/Empresa/Salvar"
									id="form_sample_2" class="form-horizontal">
									<div class="form-body">
										<div style="width: 90%; margin-left: 5%;"
											class="alert alert-danger display-hide">
											<button class="close" data-close="alert"></button>
											Por favor verifique os erros abaixo!
										</div>

										<input style="display: none" type="text" class="form-control"
											value="<%out.print(request.getAttribute("id"));%>"
											name="emprId" />

										<div class="form-group  margin-top-20">
											<label class="control-label col-md-3">Empresa <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" class="form-control"
														value="<%out.print(empresa.getEmprEmpresa()); %>"
														name="emprEmpresa" />
												</div>
											</div>
										</div>
										<div class="form-group  margin-top-20">
											<label class="control-label col-md-3">Inscricao Estaual <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text"
														value="<%out.print(empresa.getEmprInscricaoEstadual()); %>"
														class="form-control" name="emprInscricaoEstadual" />
												</div>
											</div>
										</div>
										
									<div class="form-group">
											<label class="control-label col-md-3">Nome Fantasia <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" class="form-control"
														value="<%out.print(empresa.getEmprNomeFantasia()); %>"
														name="emprNomeFantasia" />
												</div>
											</div>
									</div>
									<div class="form-group  margin-top-20">
											<label class="control-label col-md-3">Telefone <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" class="form-control"
														value="<%out.print(empresa.getEmprTelefone()); %>"
														name="emprTelefone" />
												</div>
											</div>
									</div>	
									<div class="form-group  margin-top-20">
											<label class="control-label col-md-3">CNPJ <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" class="form-control"
														value="<%out.print(empresa.getEmprCnpj()); %>"
														name="emprCnpj" />
												</div>
											</div>
									</div>
									
									<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input style="display: none"
															type="text"
															value="<%out.print(empresa.getEmprEndereco()); %>"
															class="form-control" name="emprEndereco" />
												</div>
											</div>
										<div class="form-group margin-top-20">
											<label class="control-label col-md-3">Endereco
												<span class="required"> * </span>
											</label>
											<div class="col-md-4">
													<div class="input-icon right">
												<%
												EntityManager emIdEndereco = new ConexaoEntityFactory().getEntityManager();
												Query queryIdEndereco = (Query) emIdEndereco.createNativeQuery("SELECT ende_id FROM sistema.endereco INNER JOIN sistema.empresa ON ende_id = empr_endereco WHERE empr_id = " + request.getAttribute("id").toString());
												Object objIdEndereco = queryIdEndereco.getSingleResult();
												%>

												<% 	
												
													EntityManager em = new ConexaoEntityFactory().getEntityManager();
													Query query = (Query) em.createNativeQuery("SELECT ende_endereco, ende_bairro, cida_cidade, empr_endereco FROM sistema.empresa INNER JOIN sistema.endereco ON ende_id = empr_endereco INNER JOIN sistema.cidade ON cida_id = ende_cidade WHERE ende_id = " + objIdEndereco);
													List<Object[]> list = query.getResultList();
													for (Object[] obj : list) { 
												%>

														<i class="fa"></i> <input readonly="true" type="text"
															value="<%out.print(obj[0]);%>" class="form-control" /> <br />
														<i class="fa"></i> <input readonly="true" type="text"
															value="<%out.print(obj[1]);%>" class="form-control" /> <br />
														<i class="fa"></i> <input readonly="true" type="text"
															value="<%out.print(obj[2]);%>" class="form-control" /> <br>
														<% } %>

														<div class="btn-group">
															<a href="/CifPag/Endereco/EditarPelaEmpresa?id=<%out.print(empresa.getEmprEndereco()); %>"
																id="sample_editable_1_new" class="btn sbold green">
																Editar Endereco <i class="fa fa-plus"></i>
															</a>
														</div>
													</div>

												</div>
												
												<div class="help-block with-errors"></div>
											</div>
										</div>
									</div>
									
									<div class="form-actions">
										<div class="row">
											<div class="col-md-offset-3 col-md-9">
												<button type="submit" class="btn green">Alterar</button>
											</div>
										</div>
									</div>
								</form>
								<!-- END FORM-->
							</div>
						</div>
						<!-- END VALIDATION STATES-->
					</div>
				</div>
			</div>
		</div>
	</div>



</c:set>
<t:master>

	<jsp:attribute name="scripts_css">
        
</jsp:attribute>

	<jsp:attribute name="scripts_js_page_level_plugins">

        <script
			src="/CifPag/assets/global/plugins/jquery-validation/js/jquery.validate.min.js"
			type="text/javascript"></script>
<script
			src="/CifPag/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"
			type="text/javascript"></script>
                       
</jsp:attribute>
	<jsp:attribute name="scripts_js_page_level_scripts">
	<script>
$(document).ready(function(){
	$("#sistema_nav").addClass('active open');
	$("#empresa_li_consulta").addClass('active open');	
});
			</script>

<script
			src="/CifPag/assets/pages/scripts/form-validation.min.js"
			type="text/javascript"></script>
        			
                
</jsp:attribute>
	<jsp:body>
${bodyContent}    
</jsp:body>
</t:master>

