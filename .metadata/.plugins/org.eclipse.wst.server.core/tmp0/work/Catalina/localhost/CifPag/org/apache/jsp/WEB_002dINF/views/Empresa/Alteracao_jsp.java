/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.81
 * Generated at: 2018-03-05 19:45:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.Empresa;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.com.cifpag.uteis.ConexaoEntityFactory;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import java.util.List;
import br.com.cifpag.daoGenericos.EmpresaDaoImplementacao;
import br.com.cifpag.daoGenericos.EmpresaDao;
import br.com.cifpag.entity.Empresa;

public final class Alteracao_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/tags/master.tag", Long.valueOf(1519854977000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

EmpresaDao empresaDAO = new EmpresaDaoImplementacao();
Empresa empresa = empresaDAO.getById(Empresa.class, Integer.parseInt(request.getAttribute("id").toString()));

      out.write('\n');
      out.write('\n');
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      boolean _jspx_th_c_005fset_005f0_reused = false;
      try {
        _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fset_005f0.setParent(null);
        // /WEB-INF/views/Empresa/Alteracao.jsp(19,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fset_005f0.setVar("bodyContent");
        int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
        if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = org.apache.jasper.runtime.JspRuntimeLibrary.startBufferedBody(_jspx_page_context, _jspx_th_c_005fset_005f0);
          }
          do {
            out.write("\n");
            out.write("\n");
            out.write("\n");
            out.write("\t<div class=\"page-bar\">\n");
            out.write("\t\t<ul class=\"page-breadcrumb\">\n");
            out.write("\t\t\t<li><a href=\"/CifPag/dashboard/index\">Dashboard</a>\n");
            out.write("\t\t\t\t<i class=\"fa fa-circle\"></i></li>\n");
            out.write("\t\t\t<li><a href=\"/CifPag/Empresa/Consulta\">Empresa Consulta</a>\n");
            out.write("\t\t\t\t<i class=\"fa fa-circle\"></i></li>\n");
            out.write("\t\t\t<li><span>Alteração</span></li>\n");
            out.write("\t\t</ul>\n");
            out.write("\t\t<div class=\"page-toolbar\"></div>\n");
            out.write("\t</div>\n");
            out.write("\n");
            out.write("\t<!-- END PAGE BAR -->\n");
            out.write("\t<!-- BEGIN PAGE TITLE-->\n");
            out.write("\t<h1 class=\"page-title\">\n");
            out.write("\t\tAlteração de Empresa <small>Campos Obrigatórios (*)</small>\n");
            out.write("\t</h1>\n");
            out.write("\t<!-- END PAGE TITLE-->\n");
            out.write("\t<!-- END PAGE HEADER-->\n");
            out.write("\n");
            out.write("\t<div class=\"row\">\n");
            out.write("\t\t<div class=\"col-md-12\">\n");
            out.write("\t\t\t<!-- BEGIN VALIDATION STATES-->\n");
            out.write("\t\t\t<div class=\"portlet light portlet-fit portlet-form bordered\"\n");
            out.write("\t\t\t\tid=\"form_wizard_1\">\n");
            out.write("\n");
            out.write("\t\t\t\t<div class=\"row\">\n");
            out.write("\t\t\t\t\t<div class=\"col-md-12\">\n");
            out.write("\t\t\t\t\t\t<!-- BEGIN VALIDATION STATES-->\n");
            out.write("\t\t\t\t\t\t<div class=\"portlet light portlet-fit portlet-form bordered\">\n");
            out.write("\n");
            out.write("\t\t\t\t\t\t\t<div class=\"portlet-body\">\n");
            out.write("\t\t\t\t\t\t\t\t<!-- BEGIN FORM-->\n");
            out.write("\t\t\t\t\t\t\t\t<form action=\"/CifPag/Empresa/Salvar\"\n");
            out.write("\t\t\t\t\t\t\t\t\tid=\"form_sample_2\" class=\"form-horizontal\">\n");
            out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-body\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<div style=\"width: 90%; margin-left: 5%;\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\tclass=\"alert alert-danger display-hide\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<button class=\"close\" data-close=\"alert\"></button>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\tPor favor verifique os erros abaixo!\n");
            out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<input style=\"display: none\" type=\"text\" class=\"form-control\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
out.print(request.getAttribute("id"));
            out.write("\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\tname=\"emprId\" />\n");
            out.write("\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"form-group  margin-top-20\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label col-md-3\">Empresa <span\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"required\"> * </span>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</label>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-4\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-icon right\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa\"></i> <input type=\"text\" class=\"form-control\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
out.print(empresa.getEmprEmpresa()); 
            out.write("\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"emprEmpresa\" />\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"form-group  margin-top-20\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label col-md-3\">Inscricao Estaual <span\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"required\"> * </span>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</label>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-4\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-icon right\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa\"></i> <input type=\"text\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
out.print(empresa.getEmprInscricaoEstadual()); 
            out.write("\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"form-control\" name=\"emprInscricaoEstadual\" />\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\n");
            out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label col-md-3\">Nome Fantasia <span\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"required\"> * </span>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</label>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-4\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-icon right\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa\"></i> <input type=\"text\" class=\"form-control\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
out.print(empresa.getEmprNomeFantasia()); 
            out.write("\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"emprNomeFantasia\" />\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group  margin-top-20\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label col-md-3\">Telefone <span\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"required\"> * </span>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</label>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-4\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-icon right\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa\"></i> <input type=\"text\" class=\"form-control\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
out.print(empresa.getEmprTelefone()); 
            out.write("\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"emprTelefone\" />\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t</div>\t\n");
            out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group  margin-top-20\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label col-md-3\">CNPJ <span\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"required\"> * </span>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</label>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-4\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-icon right\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa\"></i> <input type=\"text\" class=\"form-control\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
out.print(empresa.getEmprCnpj()); 
            out.write("\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tname=\"emprCnpj\" />\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\n");
            out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-md-4\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-icon right\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa\"></i> <input style=\"display: none\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\ttype=\"text\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
out.print(empresa.getEmprEndereco()); 
            out.write("\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"form-control\" name=\"emprEndereco\" />\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"form-group margin-top-20\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<label class=\"control-label col-md-3\">Endereco\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"required\"> * </span>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</label>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-4\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"input-icon right\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t");

												EntityManager emIdEndereco = new ConexaoEntityFactory().getEntityManager();
												Query queryIdEndereco = (Query) emIdEndereco.createNativeQuery("SELECT ende_id FROM sistema.endereco INNER JOIN sistema.empresa ON ende_id = empr_endereco WHERE empr_id = " + request.getAttribute("id").toString());
												Object objIdEndereco = queryIdEndereco.getSingleResult();
												
            out.write("\n");
            out.write("\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t");
 	
												
													EntityManager em = new ConexaoEntityFactory().getEntityManager();
													Query query = (Query) em.createNativeQuery("SELECT ende_endereco, ende_bairro, cida_cidade, empr_endereco FROM sistema.empresa INNER JOIN sistema.endereco ON ende_id = empr_endereco INNER JOIN sistema.cidade ON cida_id = ende_cidade WHERE ende_id = " + objIdEndereco);
													List<Object[]> list = query.getResultList();
													for (Object[] obj : list) { 
												
            out.write("\n");
            out.write("\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa\"></i> <input readonly=\"true\" type=\"text\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
out.print(obj[0]);
            out.write("\" class=\"form-control\" /> <br />\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa\"></i> <input readonly=\"true\" type=\"text\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
out.print(obj[1]);
            out.write("\" class=\"form-control\" /> <br />\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"fa\"></i> <input readonly=\"true\" type=\"text\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\"");
out.print(obj[2]);
            out.write("\" class=\"form-control\" /> <br>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
 } 
            out.write("\n");
            out.write("\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"btn-group\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"/CifPag/Endereco/EditarPelaEmpresa?id=");
out.print(empresa.getEmprEndereco()); 
            out.write("\"\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tid=\"sample_editable_1_new\" class=\"btn sbold green\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEditar Endereco <i class=\"fa fa-plus\"></i>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</a>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"help-block with-errors\"></div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\n");
            out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-actions\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"row\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"col-md-offset-3 col-md-9\">\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn green\">Alterar</button>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t\t\t</form>\n");
            out.write("\t\t\t\t\t\t\t\t<!-- END FORM-->\n");
            out.write("\t\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t\t\t<!-- END VALIDATION STATES-->\n");
            out.write("\t\t\t\t\t</div>\n");
            out.write("\t\t\t\t</div>\n");
            out.write("\t\t\t</div>\n");
            out.write("\t\t</div>\n");
            out.write("\t</div>\n");
            out.write("\n");
            out.write("\n");
            out.write("\n");
            int evalDoAfterBody = _jspx_th_c_005fset_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.popBody();
          }
        }
        if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.reuse(_jspx_th_c_005fset_005f0);
        _jspx_th_c_005fset_005f0_reused = true;
      } finally {
        org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
      }
      out.write('\n');
      if (_jspx_meth_t_005fmaster_005f0(_jspx_page_context))
        return;
      out.write('\n');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_t_005fmaster_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  t:master
    org.apache.jsp.tag.web.master_tag _jspx_th_t_005fmaster_005f0 = new org.apache.jsp.tag.web.master_tag();
    _jsp_getInstanceManager().newInstance(_jspx_th_t_005fmaster_005f0);
    try {
      _jspx_th_t_005fmaster_005f0.setJspContext(_jspx_page_context);
      javax.servlet.jsp.tagext.JspFragment _jspx_temp0 = new Helper( 0, _jspx_page_context, _jspx_th_t_005fmaster_005f0, null);
      // /WEB-INF/views/Empresa/Alteracao.jsp(201,0) null
      _jspx_th_t_005fmaster_005f0.setScripts_css(_jspx_temp0);
      javax.servlet.jsp.tagext.JspFragment _jspx_temp1 = new Helper( 1, _jspx_page_context, _jspx_th_t_005fmaster_005f0, null);
      // /WEB-INF/views/Empresa/Alteracao.jsp(201,0) null
      _jspx_th_t_005fmaster_005f0.setScripts_js_page_level_plugins(_jspx_temp1);
      javax.servlet.jsp.tagext.JspFragment _jspx_temp2 = new Helper( 2, _jspx_page_context, _jspx_th_t_005fmaster_005f0, null);
      // /WEB-INF/views/Empresa/Alteracao.jsp(201,0) null
      _jspx_th_t_005fmaster_005f0.setScripts_js_page_level_scripts(_jspx_temp2);
      _jspx_th_t_005fmaster_005f0.setJspBody(new Helper( 3, _jspx_page_context, _jspx_th_t_005fmaster_005f0, null));
      _jspx_th_t_005fmaster_005f0.doTag();
    } finally {
      _jsp_getInstanceManager().destroyInstance(_jspx_th_t_005fmaster_005f0);
    }
    return false;
  }

  private class Helper
      extends org.apache.jasper.runtime.JspFragmentHelper
  {
    private javax.servlet.jsp.tagext.JspTag _jspx_parent;
    private int[] _jspx_push_body_count;

    public Helper( int discriminator, javax.servlet.jsp.JspContext jspContext, javax.servlet.jsp.tagext.JspTag _jspx_parent, int[] _jspx_push_body_count ) {
      super( discriminator, jspContext, _jspx_parent );
      this._jspx_parent = _jspx_parent;
      this._jspx_push_body_count = _jspx_push_body_count;
    }
    public boolean invoke0( javax.servlet.jsp.JspWriter out ) 
      throws java.lang.Throwable
    {
      return false;
    }
    public boolean invoke1( javax.servlet.jsp.JspWriter out ) 
      throws java.lang.Throwable
    {
      out.write("<script\n");
      out.write("\t\t\tsrc=\"/CifPag/assets/global/plugins/jquery-validation/js/jquery.validate.min.js\"\n");
      out.write("\t\t\ttype=\"text/javascript\"></script>\n");
      out.write("<script\n");
      out.write("\t\t\tsrc=\"/CifPag/assets/global/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js\"\n");
      out.write("\t\t\ttype=\"text/javascript\"></script>");
      return false;
    }
    public boolean invoke2( javax.servlet.jsp.JspWriter out ) 
      throws java.lang.Throwable
    {
      out.write("<script>\n");
      out.write("$(document).ready(function(){\n");
      out.write("\t$(\"#sistema_nav\").addClass('active open');\n");
      out.write("\t$(\"#empresa_li_consulta\").addClass('active open');\t\n");
      out.write("});\n");
      out.write("\t\t\t</script>\n");
      out.write("\n");
      out.write("<script\n");
      out.write("\t\t\tsrc=\"/CifPag/assets/pages/scripts/form-validation.min.js\"\n");
      out.write("\t\t\ttype=\"text/javascript\"></script>");
      return false;
    }
    public boolean invoke3( javax.servlet.jsp.JspWriter out ) 
      throws java.lang.Throwable
    {
      out.write('\n');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${bodyContent}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("    \n");
      return false;
    }
    public void invoke( java.io.Writer writer )
      throws javax.servlet.jsp.JspException
    {
      javax.servlet.jsp.JspWriter out = null;
      if( writer != null ) {
        out = this.jspContext.pushBody(writer);
      } else {
        out = this.jspContext.getOut();
      }
      try {
        Object _jspx_saved_JspContext = this.jspContext.getELContext().getContext(javax.servlet.jsp.JspContext.class);
        this.jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,this.jspContext);
        switch( this.discriminator ) {
          case 0:
            invoke0( out );
            break;
          case 1:
            invoke1( out );
            break;
          case 2:
            invoke2( out );
            break;
          case 3:
            invoke3( out );
            break;
        }
        jspContext.getELContext().putContext(javax.servlet.jsp.JspContext.class,_jspx_saved_JspContext);
      }
      catch( java.lang.Throwable e ) {
        if (e instanceof javax.servlet.jsp.SkipPageException)
            throw (javax.servlet.jsp.SkipPageException) e;
        throw new javax.servlet.jsp.JspException( e );
      }
      finally {
        if( writer != null ) {
          this.jspContext.popBody();
        }
      }
    }
  }
}
