/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.81
 * Generated at: 2018-03-12 13:51:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<!-- \n");
      out.write("Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 3.3.7\n");
      out.write("Version: 4.7.5\n");
      out.write("Author: KeenThemes\n");
      out.write("Website: http://www.keenthemes.com/\n");
      out.write("Contact: support@keenthemes.com\n");
      out.write("Follow: www.twitter.com/keenthemes\n");
      out.write("Dribbble: www.dribbble.com/keenthemes\n");
      out.write("Like: www.facebook.com/keenthemes\n");
      out.write("Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes\n");
      out.write("Renew Support: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes\n");
      out.write("License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.\n");
      out.write("-->\n");
      out.write("<!--[if IE 8]> <html lang=\"en\" class=\"ie8 no-js\"> <![endif]-->\n");
      out.write("<!--[if IE 9]> <html lang=\"en\" class=\"ie9 no-js\"> <![endif]-->\n");
      out.write("<!--[if !IE]><!-->\n");
      out.write("<html lang=\"en\">\n");
      out.write("<!--<![endif]-->\n");
      out.write("<!-- BEGIN HEAD -->\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\" />\n");
      out.write("<title>Metronic Admin Theme #1 | User Login 1</title>\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("<meta content=\"width=device-width, initial-scale=1\" name=\"viewport\" />\n");
      out.write("<meta content=\"Preview page of Metronic Admin Theme #1 for \"\n");
      out.write("\tname=\"description\" />\n");
      out.write("<meta content=\"\" name=\"author\" />\n");
      out.write("<!-- BEGIN GLOBAL MANDATORY STYLES -->\n");
      out.write("<link\n");
      out.write("\thref=\"http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all\"\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<link\n");
      out.write("\thref=\"assets/global/plugins/font-awesome/css/font-awesome.min.css\"\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<link\n");
      out.write("\thref=\"assets/global/plugins/simple-line-icons/simple-line-icons.min.css\"\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<link\n");
      out.write("\thref=\"assets/global/plugins/bootstrap/css/bootstrap.min.css\"\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<link\n");
      out.write("\thref=\"assets/global/plugins/bootstrap-switch/css/bootstrap-switch.min.css\"\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<!-- END GLOBAL MANDATORY STYLES -->\n");
      out.write("<!-- BEGIN PAGE LEVEL PLUGINS -->\n");
      out.write("<link href=\"assets/global/plugins/select2/css/select2.min.css\"\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<link\n");
      out.write("\thref=\"assets/global/plugins/select2/css/select2-bootstrap.min.css\"\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<!-- END PAGE LEVEL PLUGINS -->\n");
      out.write("<!-- BEGIN THEME GLOBAL STYLES -->\n");
      out.write("<link href=\"assets/global/css/components.min.css\"\n");
      out.write("\trel=\"stylesheet\" id=\"style_components\" type=\"text/css\" />\n");
      out.write("<link href=\"assets/global/css/plugins.min.css\"\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<!-- END THEME GLOBAL STYLES -->\n");
      out.write("<!-- BEGIN PAGE LEVEL STYLES -->\n");
      out.write("<link href=\"assets/pages/css/login.min.css\" rel=\"stylesheet\"\n");
      out.write("\ttype=\"text/css\" />\n");
      out.write("<!-- END PAGE LEVEL STYLES -->\n");
      out.write("<!-- BEGIN THEME LAYOUT STYLES -->\n");
      out.write("<!-- END THEME LAYOUT STYLES -->\n");
      out.write("<link rel=\"shortcut icon\" href=\"favicon.ico\" />\n");
      out.write("</head>\n");
      out.write("<!-- END HEAD -->\n");
      out.write("\n");
      out.write("<body class=\" login\">\n");
      out.write("\t<!-- BEGIN LOGO -->\n");
      out.write("\t<div class=\"logo\">\n");
      out.write("\t\t<a href=\"index.html\"> <img\n");
      out.write("\t\t\tsrc=\"assets/pages/img/logo-big.png\" alt=\"\" />\n");
      out.write("\t\t</a>\n");
      out.write("\t</div>\n");
      out.write("\t<!-- END LOGO -->\n");
      out.write("\t<!-- BEGIN LOGIN -->\n");
      out.write("\t<div class=\"content\">\n");
      out.write("\t\t<!-- BEGIN LOGIN FORM -->\n");
      out.write("\t\t<form class=\"login-form\" action=\"sistema/login\" method=\"post\">\n");
      out.write("\t\t\t<h3 class=\"form-title font-green\">Login</h3>\n");
      out.write("\t\t\t<div class=\"alert alert-danger display-hide\">\n");
      out.write("\t\t\t\t<button class=\"close\" data-close=\"alert\"></button>\n");
      out.write("\t\t\t\t<span> Por favor digite Usuário e Senha. </span>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t");

				try {
					if (request.getParameter("login").equals("incorreto")) {
			
      out.write("\n");
      out.write("\t\t\t<div class=\"alert alert-danger\">\n");
      out.write("\t\t\t\t<button class=\"close\" data-close=\"alert\"></button>\n");
      out.write("\t\t\t\t<span> Login Incorreto! </span>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t");

				}
				} catch (NullPointerException ex) {
				}
			
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->\n");
      out.write("\t\t\t\t<label class=\"control-label visible-ie8 visible-ie9\">Usuario</label>\n");
      out.write("\t\t\t\t<input class=\"form-control form-control-solid placeholder-no-fix\"\n");
      out.write("\t\t\t\t\ttype=\"text\" autocomplete=\"off\" placeholder=\"Usuario\"\n");
      out.write("\t\t\t\t\tname=\"username\" />\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"form-group\">\n");
      out.write("\t\t\t\t<label class=\"control-label visible-ie8 visible-ie9\">Senha</label> <input\n");
      out.write("\t\t\t\t\tclass=\"form-control form-control-solid placeholder-no-fix\"\n");
      out.write("\t\t\t\t\ttype=\"password\" autocomplete=\"off\" placeholder=\"Senha\"\n");
      out.write("\t\t\t\t\tname=\"password\" />\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"form-actions\">\n");
      out.write("\t\t\t\t<button type=\"submit\" id=\"btnLogar\" class=\"btn green uppercase\">Login</button>\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t</form>\n");
      out.write("\n");
      out.write("\t\t<!-- END REGISTRATION FORM -->\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"copyright\">2014 © Metronic. Admin Dashboard Template.\n");
      out.write("\t</div>\n");
      out.write("\t<!--[if lt IE 9]>\n");
      out.write("<script src=\"assets/global/plugins/respond.min.js\"></script>\n");
      out.write("<script src=\"assets/global/plugins/excanvas.min.js\"></script> \n");
      out.write("<script src=\"assets/global/plugins/ie8.fix.min.js\"></script> \n");
      out.write("<![endif]-->\n");
      out.write("\t<!-- BEGIN CORE PLUGINS -->\n");
      out.write("\t<script src=\"assets/global/plugins/jquery.min.js\"\n");
      out.write("\t\ttype=\"text/javascript\"></script>\n");
      out.write("\t<script\n");
      out.write("\t\tsrc=\"assets/global/plugins/bootstrap/js/bootstrap.min.js\"\n");
      out.write("\t\ttype=\"text/javascript\"></script>\n");
      out.write("\t<script src=\"assets/global/plugins/js.cookie.min.js\"\n");
      out.write("\t\ttype=\"text/javascript\"></script>\n");
      out.write("\t<script\n");
      out.write("\t\tsrc=\"assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js\"\n");
      out.write("\t\ttype=\"text/javascript\"></script>\n");
      out.write("\t<script src=\"assets/global/plugins/jquery.blockui.min.js\"\n");
      out.write("\t\ttype=\"text/javascript\"></script>\n");
      out.write("\t<script\n");
      out.write("\t\tsrc=\"assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js\"\n");
      out.write("\t\ttype=\"text/javascript\"></script>\n");
      out.write("\t<!-- END CORE PLUGINS -->\n");
      out.write("\t<!-- BEGIN PAGE LEVEL PLUGINS -->\n");
      out.write("\t<script\n");
      out.write("\t\tsrc=\"assets/global/plugins/jquery-validation/js/jquery.validate.min.js\"\n");
      out.write("\t\ttype=\"text/javascript\"></script>\n");
      out.write("\t<script\n");
      out.write("\t\tsrc=\"assets/global/plugins/jquery-validation/js/additional-methods.min.js\"\n");
      out.write("\t\ttype=\"text/javascript\"></script>\n");
      out.write("\t<script\n");
      out.write("\t\tsrc=\"assets/global/plugins/select2/js/select2.full.min.js\"\n");
      out.write("\t\ttype=\"text/javascript\"></script>\n");
      out.write("\t<!-- END PAGE LEVEL PLUGINS -->\n");
      out.write("\t<!-- BEGIN THEME GLOBAL SCRIPTS -->\n");
      out.write("\t<script src=\"assets/global/scripts/app.min.js\"\n");
      out.write("\t\ttype=\"text/javascript\"></script>\n");
      out.write("\t<!-- END THEME GLOBAL SCRIPTS -->\n");
      out.write("\t<!-- BEGIN PAGE LEVEL SCRIPTS -->\n");
      out.write("\t<script src=\"assets/pages/scripts/login.min.js\"\n");
      out.write("\t\ttype=\"text/javascript\"></script>\n");
      out.write("\t<!-- END PAGE LEVEL SCRIPTS -->\n");
      out.write("\t<!-- BEGIN THEME LAYOUT SCRIPTS -->\n");
      out.write("\t<!-- END THEME LAYOUT SCRIPTS -->\n");
      out.write("\t<script>\n");
      out.write("\t\t$(document).ready(function() {\n");
      out.write("\t\t\t$('#clickmewow').click(function() {\n");
      out.write("\t\t\t\t$('#radio1003').attr('checked', 'checked');\n");
      out.write("\t\t\t});\n");
      out.write("\t\t})\n");
      out.write("\t</script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
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
}
