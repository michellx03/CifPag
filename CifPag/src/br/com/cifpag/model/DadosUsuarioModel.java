package br.com.cifpag.model;

import br.com.cifpag.daoGenericos.DadosUsuarioDao;
import br.com.cifpag.daoGenericos.DadosUsuarioImplementacao;
import br.com.cifpag.entity.DadosUsuario;

public class DadosUsuarioModel {
	
	public String Salvar(DadosUsuario dadosUsuario) {

		try {
			DadosUsuarioDao dadosUsuarioDAO = new DadosUsuarioImplementacao();
			dadosUsuarioDAO.save(dadosUsuario);
			return "sucesso";
		} catch (Exception ex) {
			return "falha";
		}
	}

}
