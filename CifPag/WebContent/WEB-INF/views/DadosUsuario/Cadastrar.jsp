<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>

<%@page import="br.com.cifpag.uteis.ConexaoEntityFactory"%>
<%@page import="java.util.List"%>

<%
	
%>
<c:set var="bodyContent">


	<div class="page-bar">
		<ul class="page-breadcrumb">
			<li><a href="/CifPag/dashboard/index">Dashboard</a>
				<i class="fa fa-circle"></i></li>
			<li><a href="/CifPag/DadosUsuario/Consulta">Dados Usuario Consulta</a>
				<i class="fa fa-circle"></i></li>
			<li><span>Cadastro</span></li>
		</ul>
		<div class="page-toolbar"></div>
	</div>

	<!-- END PAGE BAR -->
	<!-- BEGIN PAGE TITLE-->
	<h1 class="page-title">
		Cadastro de Dadosd do usuario <small>Campos Obrigatórios (*)</small>
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
								<form action="/CifPag/DadosUsuario/Salvar"
									id="form_sample_2" method="POST" class="form-horizontal">

									<input style="display: none" name="clieId" id="id">
									<input style="display: none" name="usaId" id="usuaId">

									<div class="form-body">
										<div style="width: 90%; margin-left: 5%;"
											class="alert alert-danger display-hide">
											<button class="close" data-close="alert"></button>
											Por favor verifique os erros abaixo!
										</div>
										
										<div class="form-group  margin-top-20">
											<label class="control-label col-md-3">Email <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" class="form-control" id="usuaUsuario"
														name="usuaUsuario"/>
												</div>
											</div>
										</div>
										
										<div class="form-group  margin-top-20">
											<label class="control-label col-md-3">Senha <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" class="form-control" id="usuaSenha"
														name="usuaSenha"/>
												</div>
											</div>
										</div>
										
										<div class="form-group  margin-top-20">
											<label class="control-label col-md-3">Nome Completo <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" class="form-control" id="clieNome"
														name="clieNome"/>
												</div>
											</div>
										</div>
										
										<div class="form-group  margin-top-20">
											<label class="control-label col-md-3">Data Nascimento <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="date" class="form-control" id="clieDataNascimento"
														name="clieDataNascimento"/>
												</div>
											</div>
										</div>
										
										<div class="form-group margin-top-20">
													<label for="single" class="control-label col-md-3">Selecione o tipo de pessoa</label>
												<div class="col-md-4">
													<div class="input-icon right">
															<select id="singleAlter" class="form-control select2" name="clieTipoPessoa">
															<option value="">Selecione uma opcao</option>	
																<% 		
																	EntityManager emTipoPessoa = new ConexaoEntityFactory().getEntityManager();
																	Query queryListaTipoPessoa = (Query) emTipoPessoa.createNativeQuery("SELECT tipo_id, tipo_tipo_pessoa FROM sistema.tipo_pessoa");
																	List<Object[]> listTipoPessoa = queryListaTipoPessoa.getResultList();
																	for (Object[] obj : listTipoPessoa) { 
																%>
																<option value="<%out.print(obj[0]);%>"><%out.print(obj[1]);%></option>	
																														
																<%
																	}
																%>	

															</select>
														</div>
													</div>	
												</div>
												
										<div class="form-group  margin-top-20" hidden id="clieRg">
											<label class="control-label col-md-3">Rg <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" 
														class="form-control"
														name="clieRg" />
												</div>
											</div>
										</div>
										
										<div class="form-group  margin-top-20" hidden id="clieCpf">
											<label class="control-label col-md-3">CPF <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" 
														class="form-control"
														name="clieCpf" />
												</div>
											</div>
										</div>
										
										<div class="form-group  margin-top-20" hidden id="clieCnpj">
											<label class="control-label col-md-3">CNPJ <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" 
														class="form-control"
														name="clieCnpj" />
												</div>
											</div>
										</div>
										
										<div class="form-group  margin-top-20" hidden id="clieNomeFantasia">
											<label class="control-label col-md-3">Nome Fantasia <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" 
														class="form-control"
														name="clieNomeFantasia" />
												</div>
											</div>
										</div>
										
										<div class="form-group  margin-top-20">
											<label class="control-label col-md-3">Celular <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" id="clieCelular"
														class="form-control"
														name="clieCelular" />
												</div>
											</div>
										</div>
										
										<div class="form-group  margin-top-20">
											<label class="control-label col-md-3">Telefone <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" id="clieTelefone"
														class="form-control"
														name="clieTelefone" />
												</div>
											</div>
										</div>
										
										<input style="display: none" name="endeId" id="endeId">
										
										<div class="form-group  margin-top-20">
											<label class="control-label col-md-3">Endereco <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" id="endeEndereco"
														class="form-control"
														name="endeEndereco" />
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
														class="form-control"
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
														class="form-control"
														name="endeNumero" />
												</div>
											</div>
										</div>
										
										<div class="form-group margin-top-20">
													<label for="singleCidade" class="control-label col-md-3">Selecione sua cidade</label>
												<div class="col-md-4">
													<div class="input-icon right">
															<select id="singleAlterCidade" class="form-control select2" name="cidaCidade">
															<option value="">Selecione uma opcao</option>	
																<% 		
																EntityManager em = new ConexaoEntityFactory().getEntityManager();
																Query query = (Query) em.createNativeQuery("SELECT * FROM sistema.cidade");
																List<Object[]> list = query.getResultList();
																for (Object[] obj : list) {  
																%>
																<option value="<%out.print(obj[0]);%>"><%out.print(obj[1]);%></option>	
																														
																<%
																	}
																%>	

															</select>
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

        <script
			src="/CifPag/assets/global/plugins/jquery-validation/js/jquery.validate.min.js"
			type="text/javascript"></script>
<script
			src="/CifPag/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"
			type="text/javascript"></script>
			<script src="/CifPag/assets/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
		<script src="/CifPag/assets/pages/scripts/components-select2.min.js"type="text/javascript"></script>
                       
</jsp:attribute>
	<jsp:attribute name="scripts_js_page_level_scripts">
		
		<script>
		var iniciar = $('#singleAlter').val();
		if(iniciar == 1){
			$("#clieCnpj").hide();
	         $("#clieNomeFantasia").hide();
	         $("#clieCpf").show();
	         $("#clieRg").show();
		}if(iniciar == 2){
			$("#clieCnpj").show();
	         $("#clieNomeFantasia").show();
	         $("#clieCpf").hide();
	         $("#clieRg").hide();
		}if(iniciar == ""){
			
		}
		
		
		$('#singleAlter').change(function(){
			var id = $('#singleAlter').val();
			if(id == 1){
				$("#clieCnpj").hide();
		         $("#clieNomeFantasia").hide();
		         $("#clieCpf").show();
		         $("#clieRg").show();
    		}if(id == 2){
    			$("#clieCnpj").show();
		         $("#clieNomeFantasia").show();
		         $("#clieCpf").hide();
		         $("#clieRg").hide();
    		}if(id == ""){
    			
    		}
		});
</script>
	
	<script>
		$(document).ready(function() {
			$("#usuarioli").addClass('active open');
			$("#dados_usuario_acesso_li_consulta").addClass('active open');
			
			
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
				$("#singleAlter").select2();
				$("#singleCidade").select2();	
				$("#singleAlterCidade").select2();
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


