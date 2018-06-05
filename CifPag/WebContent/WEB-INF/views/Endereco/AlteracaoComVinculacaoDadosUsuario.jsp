<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>

<%@page import="br.com.cifpag.uteis.ConexaoEntityFactory"%>
<%@page import="java.util.List"%>

<c:set var="bodyContent">


	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li><a href="/CifPag/dashboard/index">Dashboard</a>
				<i class="fa fa-circle"></i></li>				
			<li><a href="/CifPag/Endereco/Consulta">Endereco Consulta</a>
				<i class="fa fa-circle"></i></li>
			<%
				if(request.getParameter("id") == null) { 
			%>	
					<li><span>Cadastro</span></li>
			<%
				}else{
			%>		
					<li><span>Editar</span></li>
			<%	
				}
			%>
		</ul>
		<div class="page-toolbar"></div>
	</div>

	<!-- END PAGE BAR -->
	<!-- BEGIN PAGE TITLE-->
	<h1 class="page-title">
		Cadastro de Enderecos <small>Campos Obrigatórios (*)</small>
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
								<form action="/CifPag/Endereco/SalvarPeloDadosUsuario"
									id="form_sample_2" method="POST" class="form-horizontal">

									<input style="display: none" name="endeId" id="id"
										value="${endereco.endeId}">

									<div class="form-body">
										<div style="width: 90%; margin-left: 5%;"
											class="alert alert-danger display-hide">
											<button class="close" data-close="alert"></button>
											Por favor verifique os erros abaixo!
										</div>
										<div class="form-group  margin-top-20">
											<label class="control-label col-md-3">Endereco <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" class="form-control" id="endeEndereco"
														name="endeEndereco"  value="${endereco.endeEndereco}" />
												</div>
											</div>
										</div>
										<div class="form-group  margin-top-20">
											<label class="control-label col-md-3">Bairro <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" id="endeBairro"
														class="form-control" value="${endereco.endeBairro}"
														name="endeBairro" />
												</div>
											</div>
										</div>
										<div class="form-group  margin-top-20">
											<label class="control-label col-md-3">Numero <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" id="endeNumero"
														class="form-control" value="${endereco.endeNumero}"
														name="endeNumero" />
												</div>
											</div>
										</div>

										<div class="form-group margin-top-20">
											<label for="single" class="control-label col-md-3">Selecione a cidade<span 
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<%
														if(request.getParameter("id") == null) { 
													%>
															<select id="single" class="form-control select2" name="endeCidade">
																<option value="">Selecione uma cidade</option>

																<% 	
																	EntityManager em = new ConexaoEntityFactory().getEntityManager();
																	Query query = (Query) em.createNativeQuery("SELECT cida_id, cida_cidade FROM sistema.cidade");
																	List<Object[]> list = query.getResultList();
																	for (Object[] obj : list) { 
																%>
																<option value="<%out.print(obj[0]);%>"><%out.print(obj[1]);%></option>	
																<%
																	}
																%>	

															</select>
														<%
														} else { 
														%>
															<select id="singleAlter" class="form-control select2" name="endeCidade">
															
																<% 	
																	EntityManager em = new ConexaoEntityFactory().getEntityManager();
																	Query cidadeEndereco = (Query) em.createNativeQuery("SELECT ende_cidade FROM sistema.endereco WHERE ende_id = "+request.getParameter("id"));
																	Object endeCidade = cidadeEndereco.getSingleResult();
																	
																	Query query = (Query) em.createNativeQuery("SELECT cida_id, cida_cidade FROM sistema.cidade WHERE cida_id = " + endeCidade);
																	List<Object[]> list = query.getResultList();
																	for (Object[] obj : list) { 
																%>
																<option value="<%out.print(obj[0]);%>"><%out.print(obj[1]);%></option>	
																
																<%
																	Query todasCidades = (Query) em.createNativeQuery("SELECT cida_id, cida_cidade FROM sistema.cidade WHERE cida_id != " + endeCidade);
																	List<Object[]> listCidades = todasCidades.getResultList();
																	for (Object[] objCidade : listCidades) {
																%>		
																		<option value="<%out.print(objCidade[0]);%>"><%out.print(objCidade[1]);%></option>
																<%			
																	}
																%>
																														
																<%
																	}
																%>	

															</select>
														<%
														}
														%>
												</div>
											</div>	
										</div>


									<div class="form-actions">
										<div class="row">
											<div class="col-md-offset-3 col-md-9">
												<button type="submit" class="btn green">
													<%
														if (request.getParameter("id") == null) {
																out.print("Cadastrar");
															} else {
																out.print("Alterar");
															}
													%>
												</button>
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
        <link href="/CifPag/assets/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
		<link href="/CifPag/assets/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />
	</jsp:attribute>

	<jsp:attribute name="scripts_js_page_level_plugins">
	
	<script src="/CifPag/assets/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
		<script src="/CifPag/assets/pages/scripts/components-select2.min.js"type="text/javascript"></script>

        <script
			src="/CifPag/assets/global/plugins/jquery-validation/js/jquery.validate.min.js"
			type="text/javascript"></script>
<script
			src="/CifPag/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"
			type="text/javascript"></script>
                       
</jsp:attribute>
	<jsp:attribute name="scripts_js_page_level_scripts">
	
	<script>
		$(document).ready(function() {
			$("#sistema_nav").addClass('active open');
			$("#endereco_li_consulta").addClass('active open');
			
			
			if( $("#imgDaTela").attr("src") == ""){
				$("#imgDaTela").hide();
			}
			
			$("#imagem").change(function(){
				
				var file = document.querySelector('#imagem').files[0];
				getBase64(file);
				
			});

		});
		
		function getBase64(file) {
	           var reader = new FileReader();
	           reader.readAsDataURL(file);
	           reader.onload = function () {
	             console.log(reader.result.length);
	             $("#fotoParaSubir").val(reader.result);
	             $("#imgDaTela").attr("src",reader.result);
	             $("#imgDaTela").show();
	          
	           };
	           reader.onerror = function (error) {
	             console.log('Error: ', error);
	           };
	        }

	       
	
		
	</script>

		<script>
		$(document).ready(function(){	
			$("#single").select2();	
			$("#ingleAlter").select2();	
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


