package br.com.cifpag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cifpag.entity.DadosUsuario;
import br.com.cifpag.entity.Endereco;
import br.com.cifpag.entity.Usuario;
import br.com.cifpag.model.DadosUsuarioModel;
import br.com.cifpag.model.UsuarioModel;
import br.com.cifpag.daoGenericos.DadosUsuarioDao;
import br.com.cifpag.daoGenericos.DadosUsuarioImplementacao;
import br.com.cifpag.daoGenericos.EnderecoDao;
import br.com.cifpag.daoGenericos.EnderecoDaoImplementacao;

@Controller
@RequestMapping("/DadosUsuario")
public class DadosUsuarioController {
	
	@RequestMapping(value = "/PerfilUsuario")
	public ModelAndView ViewDashboardAlteracao(String usuario) {
		ModelAndView view = new ModelAndView("DadosUsuario/PerfilUsuario");
		view.addObject("usuario", usuario);
		return view;
	}
	
	@RequestMapping(value = "/SalvarDadosPessoais")
	public String SalvarDadosPessoais(DadosUsuario dadosUsuario) {
			
		DadosUsuarioModel usu = new DadosUsuarioModel();
			if(usu.Salvar(dadosUsuario).equals("sucesso")){
				return "redirect:/DadosUsuario/PerfilUsuario?mensagem=sucesso";
			}else{
				return "redirect:/DadosUsuario/PerfilUsuario?mensagem=falha";
		}

	}

}
