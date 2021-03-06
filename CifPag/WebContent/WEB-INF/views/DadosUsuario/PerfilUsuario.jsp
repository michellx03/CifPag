<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="br.com.cifpag.uteis.ConexaoEntityFactory"%>
<%@page import="java.util.List"%>

<%@page import="br.com.cifpag.daoGenericos.UsuarioDaoImplementacao"%>
<%@page import="br.com.cifpag.daoGenericos.UsuarioDao"%>
<%@page import="br.com.cifpag.entity.Usuario"%>

<%@page import="br.com.cifpag.daoGenericos.DadosUsuarioImplementacao"%>
<%@page import="br.com.cifpag.daoGenericos.DadosUsuarioDao"%>
<%@page import="br.com.cifpag.entity.DadosUsuario"%>

<%
DadosUsuario dadosUsuario = new DadosUsuario();
Usuario usuario = new Usuario();

try{
	EntityManager emUsuario = new ConexaoEntityFactory().getEntityManager();
	Query queryUsuario = (Query) emUsuario.createNativeQuery("SELECT usua_id FROM controle_acesso.usuario WHERE usua_usuario = " + "'"+request.getSession().getAttribute("usuarioLogado")+"'");
	Object objUsuario = queryUsuario.getSingleResult();

	UsuarioDao usuarioDao = new UsuarioDaoImplementacao();
	usuario = usuarioDao.getById(Usuario.class, Integer.parseInt(objUsuario.toString()));
	
	
	EntityManager em = new ConexaoEntityFactory().getEntityManager();
	Query query = (Query) em.createNativeQuery("SELECT clie_id FROM sistema.dados_usuario INNER JOIN controle_acesso.usuario ON usua_id = clie_usuario WHERE usua_usuario = " + "'"+request.getSession().getAttribute("usuarioLogado")+"'");
	Object obj = query.getSingleResult();

	DadosUsuarioDao usuarioDAO = new DadosUsuarioImplementacao();
	dadosUsuario = usuarioDAO.getById(DadosUsuario.class, Integer.parseInt(obj.toString()));

}catch(Exception ex){
	System.out.println("ERROR: " + ex);
}
%>

<c:set var="bodyContent">
	<div class="row">
		<div class="col-md-12">
			<div class="portlet light bordered">
				<div class="portlet-title">
					<%
						try {
					%>
					<%
						if (request.getParameter("mensagem").equals("falha")) {
					%>
					<div style="width: 100%" class="alert alert-danger ">
						<button class="close" data-close="alert"></button>
						Erro ao efetuar operação!
					</div>
					<%
						}
								if (request.getParameter("mensagem").equals("sucesso")) {
					%>
					<div style="width: 100%" class="alert alert-success ">
						<button class="close" data-close="alert"></button>
						Sucesso ao efetuar operação!
					</div>
					<%
						}
					%>
					<%
						} catch (NullPointerException ex) {
							}
					%>
				</div>

				<div class="profile-sidebar">
				
					<div class="portlet light profile-sidebar-portlet">
						<div class="">
							<img id="perfilImg" src="/CifPag/assets/layouts/layout/img/avatar3_small.jpg" class="img-responsive" alt="">
						</div>
						
						<div class="profile-usertitle">
							<div class="profile-usertitle-name">Nome Usuario</div>
							<div class="profile-usertitle-job">Email</div>
						</div>
					</div>
					
					<div class="portlet light">
						<div class="row list-separated profile-stat">
							<div class="col-md-6 col-sm-6 col-xs-6">
								<div class="uppercase profile-stat-title">0</div>
								<div class="uppercase profile-stat-text">Faturas Pendetes</div>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6">
								<div class="uppercase profile-stat-title">0</div>
								<div class="uppercase profile-stat-text">Faturas Pagas</div>
							</div>
						</div>
					</div>
				</div>

				<div class="profile-content">
					<div class="row">
						<div class="col-md-12">
							<div class="portlet light ">
								<div class="portlet-title tabbable-line">
									<div class="caption caption-md">
										<i class="icon-globe theme-font hide"></i> 
										<span class="caption-subject font-blue-madison bold uppercase">Perfil</span>
									</div>
									<ul class="nav nav-tabs">
										<li class="active"><a data-target="#tab_1_1" data-toggle="tab">Dados pessoais</a></li>
										<li><a data-target="#tab_1_2" data-toggle="tab">Troque sua foto</a></li>
										<li><a data-target="#tab_1_3" data-toggle="tab">Troque sua senha</a></li>
									</ul>
								</div>
								<div class="portlet-body">
									<div class="tab-content">
										<div class="tab-pane active" id="tab_1_1" >
											<form role="form" action="/CifPag/DadosUsuario/SalvarDadosPessoais">
											
											<input style="display: none" name="clieId" id="clieId" value="<%out.print(dadosUsuario.getClieId()); %>">
											
												<div class="form-group">
													<label class="control-label">Nome Completo</label> 
													<i class="fa"></i> 
													<input type="text" class="form-control" required value="<%out.print(dadosUsuario.getClieNome()); %>" name="clieNome" />
												</div>
												
												<div class="form-group">
													<label class="control-label">Data Nascimento</label> 
													<i class="fa"></i> 
													<input type="date" class="form-control" required value="<%out.print(dadosUsuario.getClieDataNascimento()); %>" name="clieDataNascimento" />
												</div>
												
												<div class="form-group">
													<label for="single" class="control-label">Selecione o tipo de pessoa</label>
												<div class="">
													<div class="input-icon right">
															<select id="singleAlter" class="form-control select2" name="clieTipoPessoa">
															
																<% 	
																	EntityManager emTipoPessoa = new ConexaoEntityFactory().getEntityManager();
																	Query tipoPessoa = (Query) emTipoPessoa.createNativeQuery("SELECT tipo_id FROM sistema.tipo_pessoa WHERE tipo_id = " + dadosUsuario.getClieTipoPessoa());
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
												
												<div class="form-group">
													<label class="control-label">RG</label> 
													<i class="fa"></i> 
													<input type="text" class="form-control" required value="<%out.print(dadosUsuario.getClieRg()); %>" name="clieRg" />
												</div>
												
												<div class="form-group">
													<label class="control-label">CPF</label> 
													<i class="fa"></i> 
													<input type="text" class="form-control" value="<%out.print(dadosUsuario.getClieCpf()); %>" name="clieCpf" />
												</div>
												
												<div class="form-group">
													<label class="control-label">CNPJ</label> 
													<i class="fa"></i> 
													<input type="text" class="form-control" value="<%out.print(dadosUsuario.getClieCnpj()); %>" name="clieCnpj" />
												</div>
												
												<div class="form-group">
													<label class="control-label">Nome Fantasia</label> 
													<i class="fa"></i> 
													<input type="text" class="form-control" required value="<%out.print(dadosUsuario.getClieNomeFantasia()); %>" name="clieNomeFantasia" />
												</div>
												
												<div class="form-group">
													<label class="control-label">Telefone celular</label> 
													<i class="fa"></i> 
													<input type="text" class="form-control" required value="<%out.print(dadosUsuario.getClieCelular()); %>" name="clieCelular" />
												</div>
												
												<div class="form-group">
													<label class="control-label">Telefone fixo</label> 
													<i class="fa"></i> 
													<input type="text" class="form-control" required value="<%out.print(dadosUsuario.getClieTelefone()); %>" name="clieTelefone" />
												</div>
												
												<div class="form-group">
													<input style="display: none" type="text" class="form-control" required value="<%out.print(dadosUsuario.getClieEndereco()); %>" name="clieEndereco" />
												</div>
												
												<div class="form-group">
													<label class="control-label">Endereco
														<span class="required"></span>
													</label>
													
													<div class="">
														<div class="input-icon right">
												<%
												EntityManager emIdEndereco = new ConexaoEntityFactory().getEntityManager();
												Query queryIdEndereco = (Query) emIdEndereco.createNativeQuery("SELECT ende_id FROM sistema.endereco INNER JOIN sistema.dados_usuario ON ende_id = clie_endereco WHERE clie_id = " + dadosUsuario.getClieId());
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
															<a href="/CifPag/Endereco/EditarPeloDadosUsuario?id=<%out.print(dadosUsuario.getClieEndereco()); %>"
																id="sample_editable_1_new" class="btn sbold green">
																Editar Endereco <i class="fa fa-plus"></i>
															</a>
														</div>
													</div>

												</div>
												
												<div class="help-block with-errors"></div>
											</div>
												
												<div class="margiv-top-10">
													<button ng-click="AlterarDados()" type="submit" class="btn green">Alterar</button>
													<a href="javascript:;" class="btn default">Cancelar </a>
												</div>
											</form>
										</div>
										
										<div class="tab-pane" id="tab_1_2">
											<p>Selecione sua foto.</p>
											<form role="form">
												<div class="form-group">
													<div class="fileinput fileinput-new" data-provides="fileinput">
														<div class="fileinput-new thumbnail" style="width: 200px; height: 150px;">
															<img id="img" src="" alt="" />
														</div>
														
														<div class="form-group">
															<input ng-show="campo" ng-model="caminhoImagem" id="caminho" type="text" class="form-control" />
														</div>

														<div>
															<span class="btn default btn-file"> <span
																class="fileinput-new"> Selecione a imagem </span> <span
																class="fileinput-exists"> Change </span> <input
																onchange="angular.element(this).scope().uploadFile(this.files)"
																type="file" name="files[]">
															</span> <a href="javascript:;"
																class="btn default fileinput-exists"
																data-dismiss="fileinput"> Remove </a>
														</div>

														<div>
															<div class="fileinput-preview fileinput-exists thumbnail" style="max-width: 200px; max-height: 150px;"></div>
														</div>
													</div>

												</div>
												<div class="margin-top-10">
													<button ng-click="TrocarFoto()" type="submit" class="btn green">Alterar</button>
													<a href="javascript:;" class="btn default"> Cancelar </a>
												</div>
											</form>
										</div>
										
										<div class="tab-pane" id="tab_1_3">
											<form role="form" action="/CifPag/Usuario/SalvarPerfil">
											
												<input style="display: none" type="text" class="form-control" value="<%out.print(usuario.getUsuaId());%>" name="usuaId" />
												
												<input style="display: none" type="text" id="usuaUsuario" value="<%out.print(usuario.getUsuaUsuario()); %>" class="form-control" required name="usuaUsuario" />
												
												<div class="form-group">
													<label class="control-label">Nova senha</label> 
													<i class="fa"></i> 
													<input type="password" id="senha" value="<%out.print(usuario.getUsuaSenha()); %>" class="form-control" required name="usuaSenha" />
												</div>
												
												<div class="form-group">
													<label class="control-label">Repita a senha</label> 
													<i class="fa"></i> 
													<input type="password" equalTo="#senha" value="<%out.print(usuario.getUsuaSenha()); %>" class="form-control" required />
												</div>
												
												
												<div class="help-block with-errors"></div>
												
												<div class="">
													<button type="submit" class="btn green">Alterar</button>
												</div>
											</form>
										</div>	
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:set>

<t:master>

	<jsp:attribute name="scripts_css">
 		<link href="/CifPag/assets/global/plugins/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
        <link href="/CifPag/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="/CifPag/assets/global/plugins/bootstrap-datepicker/css/bootstrap-datepicker3.min.css" rel="stylesheet" type="text/css" /> 
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css" />
		<link href="/CifPag/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
		<link href="/CifPag/assets/global/plugins/simple-line-icons/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
		<link href="/CifPag/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="/CifPag/assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css" />
		<link href="/CifPag/assets/global/plugins/bootstrap-fileinput/bootstrap-fileinput.css" rel="stylesheet" type="text/css" />
		<link href="/CifPag/assets/global/css/components.min.css" rel="stylesheet" id="style_components" type="text/css" />
		<link href="/CifPag/assets/global/css/plugins.min.css" rel="stylesheet" type="text/css" />
		<link href="/CifPag/assets/pages/css/profile.min.css" rel="stylesheet" type="text/css" />
		<link href="/CifPag/assets/layouts/layout/css/layout.min.css" rel="stylesheet" type="text/css" />
		<link href="/CifPag/assets/layouts/layout/css/themes/darkblue.min.css" rel="stylesheet" type="text/css" id="style_color" />
		<link href="/CifPag/assets/layouts/layout/css/custom.min.css" rel="stylesheet" type="text/css" />
		<link href="/CifPag/assets/global/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
		<link href="/CifPag/assets/global/plugins/select2/css/select2-bootstrap.min.css" rel="stylesheet" type="text/css" />       
	</jsp:attribute>

	<jsp:attribute name="scripts_js_page_level_plugins">
		<script src="/CifPag/assets/global/scripts/datatable.js" type="text/javascript"></script>
        <script src="/CifPag/assets/global/plugins/datatables/datatables.min.js" type="text/javascript"></script>
        <script src="/CifPag/assets/global/plugins/datatables/plugins/bootstrap/datatables.bootstrap.js" type="text/javascript"></script>
        <script src="/CifPag/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
        <script src="/CifPag/assets/global/plugins/select2/js/select2.full.min.js" type="text/javascript"></script>
		<script src="/CifPag/assets/pages/scripts/components-select2.min.js"type="text/javascript"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script> 
		<script src="/CifPag/assets/global/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
	</jsp:attribute>

	<jsp:attribute name="scripts_js_page_level_scripts">
		
		<script>
			$(document).ready(function(){	
				$("#single").select2();	
				$("#singleAlter").select2();	
			});
		</script>

		<script src="/CifPag/assets/pages/scripts/table-datatables-buttons.min.js" type="text/javascript"></script>	
		<script src="/CifPag/assets/pages/scripts/form-validation.min.js" type="text/javascript"></script>					
	</jsp:attribute>

	<jsp:body>
		${bodyContent}    
	</jsp:body>
</t:master>