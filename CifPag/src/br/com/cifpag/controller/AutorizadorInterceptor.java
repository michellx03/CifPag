package br.com.cifpag.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.cifpag.model.ControleAcessoModel;
import br.com.cifpag.uteis.ConexaoEntityFactory;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {

		String uri = request.getRequestURI();

		if (uri.endsWith("login") || uri.endsWith("CifPag") || uri.contains("assets")) {
			return true;
		}

		if (request.getSession().getAttribute("usuarioLogado") != null) {

			ControleAcessoModel cam = new ControleAcessoModel();
			String controllerNome = cam.getNomeController(request);
			if (cam.usuarioLogadoTemAcesso(controllerNome, request) == false) {
				response.sendRedirect("/CifPag/ControleAcesso/AcessoNegado");
				return false;
			}
			return true;
		}

		response.sendRedirect("/CifPag");
		return false;
	}
}
