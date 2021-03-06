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
								<form action="/CifPag/DadosUsuario/Alterar"
									id="form_sample_2" method="POST" class="form-horizontal">

									<input style="display: none" name="clieId" id="id"
										value="${dadosUsuario.clieId}">

									<div class="form-body">
										<div style="width: 90%; margin-left: 5%;"
											class="alert alert-danger display-hide">
											<button class="close" data-close="alert"></button>
											Por favor verifique os erros abaixo!
										</div>
										
										<div class="form-group  margin-top-20">
											<label class="control-label col-md-3">Nome Completo <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" class="form-control" id="clieNome"
														name="clieNome"  value="${dadosUsuario.clieNome}" />
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
														name="clieDataNascimento"  value="${dadosUsuario.clieDataNascimento}" />
												</div>
											</div>
										</div>
										
										<div class="form-group margin-top-20">
													<label for="single" class="control-label col-md-3">Selecione o tipo de pessoa</label>
												<div class="col-md-4">
													<div class="input-icon right">
															<select id="singleAlter" class="form-control select2" name="clieTipoPessoa">
															
																<% 	
																	EntityManager emTipoPessoa = new ConexaoEntityFactory().getEntityManager();
																	Query tipoPessoa = (Query) emTipoPessoa.createNativeQuery("SELECT tipo_id FROM sistema.tipo_pessoa INNER JOIN sistema.dados_usuario ON clie_tipo_pessoa = tipo_id WHERE clie_id = " + request.getParameter("id"));
																	Object tipoTipoPessoa = tipoPessoa.getSingleResult();
																	
																	Query queryListaTipoPessoa = (Query) emTipoPessoa.createNativeQuery("SELECT tipo_id, tipo_tipo_pessoa FROM sistema.tipo_pessoa WHERE tipo_id = " + tipoTipoPessoa);
																	List<Object[]> listTipoPessoa = queryListaTipoPessoa.getResultList();
																	for (Object[] obj : listTipoPessoa) { 
																%>
																<option value="<%out.print(obj[0]);%>"><%out.print(obj[1]);%></option>	
																
																<%
																	Query todasPessoas = (Query) emTipoPessoa.createNativeQuery("SELECT tipo_id, tipo_tipo_pessoa FROM sistema.tipo_pessoa WHERE tipo_id != " + tipoTipoPessoa);
																	List<Object[]> listTipos = todasPessoas.getResultList();
																	for (Object[] objTipoPessoa : listTipos) {
																%>		
																		<option value="<%out.print(objTipoPessoa[0]);%>"><%out.print(objTipoPessoa[1]);%></option>
																<%			
																	}
																%>
																														
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
														class="form-control" value="${dadosUsuario.clieRg}"
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
														class="form-control" value="${dadosUsuario.clieCpf}"
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
														class="form-control" value="${dadosUsuario.clieCnpj}"
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
														class="form-control" value="${dadosUsuario.clieNomeFantasia}"
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
														class="form-control" value="${dadosUsuario.clieCelular}"
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
														class="form-control" value="${dadosUsuario.clieTelefone}"
														name="clieTelefone" />
												</div>
											</div>
										</div>
										
										<div class="form-group  margin-top-20" style="display: none">
											<label class="control-label col-md-3">Endereco <span
												class="required"> * </span>
											</label>
											<div class="col-md-4">
												<div class="input-icon right">
													<i class="fa"></i> <input type="text" id="clieEndereco"
														class="form-control" value="${dadosUsuario.clieEndereco}"
														name="clieEndereco" />
												</div>
											</div>
										</div>
										
										<div class="form-group margin-top-20">
													<label class="control-label col-md-3">Endereco
														<span class="required"></span>
													</label>
													
													<div class="col-md-4">
														<div class="input-icon right">
												<%
												EntityManager emIdEndereco = new ConexaoEntityFactory().getEntityManager();
												Query queryIdEndereco = (Query) emIdEndereco.createNativeQuery("SELECT ende_id FROM sistema.endereco INNER JOIN sistema.dados_usuario ON clie_endereco = ende_id WHERE clie_id = " + request.getParameter("id"));
												Object objIdEndereco = queryIdEndereco.getSingleResult();
												%>

												<% 	
												
													EntityManager em = new ConexaoEntityFactory().getEntityManager();
													Query query = (Query) em.createNativeQuery("SELECT ende_endereco, ende_bairro, cida_cidade, clie_endereco FROM sistema.dados_usuario INNER JOIN sistema.endereco ON ende_id = clie_endereco INNER JOIN sistema.cidade ON cida_id = ende_cidade WHERE ende_id = " + objIdEndereco);
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
														
														<%
															EntityManager emEnderecoAlterar = new ConexaoEntityFactory().getEntityManager();
															Query queryEnderecoAlterar = (Query) emEnderecoAlterar.createNativeQuery("SELECT ende_id FROM sistema.endereco INNER JOIN sistema.dados_usuario ON clie_endereco = ende_id WHERE clie_id = " + request.getParameter("id"));
															Object objEnderecoAlterar = queryEnderecoAlterar.getSingleResult();
														%>
														
															<a href="/CifPag/Endereco/EditarPeloDadosUsuario?id=<%out.print(objEnderecoAlterar); %>"
																id="sample_editable_1_new" class="btn sbold green">
																Editar Endereco <i class="fa fa-plus"></i>
															</a>
														</div>
													</div>

												</div>
												
												<div class="help-block with-errors"></div>
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
        
</jsp:attribute>

	<jsp:attribute name="scripts_js_page_level_plugins">

        <script
			src="/CifPag/assets/global/plugins/jquery-validation/js/jquery.validate.min.js"
			type="text/javascript"></script>
<script
			src="/CifPag/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"
			type="text/javascript"></script>
			<script src="/CifPag/assets/pages/scripts/DadosUsuarioJS.js" type="text/javascript"></script>
                       
</jsp:attribute>
	<jsp:attribute name="scripts_js_page_level_scripts">
	
	<script>
			$(document).ready(function(){	
				$("#single").select2();	
				$("#singleAlter").select2();	
			});
		</script>
		
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
			alert("NADA");
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
    			alert("NADA");
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

<script
			src="/CifPag/assets/pages/scripts/form-validation.min.js"
			type="text/javascript"></script>
        			
                
</jsp:attribute>
	<jsp:body>
${bodyContent}    
</jsp:body>
</t:master>


