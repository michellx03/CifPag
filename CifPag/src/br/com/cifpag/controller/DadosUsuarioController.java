package br.com.cifpag.controller;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cifpag.entity.Cidade;
import br.com.cifpag.entity.DadosUsuario;
import br.com.cifpag.entity.Endereco;
import br.com.cifpag.entity.Usuario;
import br.com.cifpag.model.DadosUsuarioModel;
import br.com.cifpag.model.UsuarioModel;
import br.com.cifpag.uteis.ConexaoEntityFactory;
import br.com.cifpag.daoGenericos.CidadeDao;
import br.com.cifpag.daoGenericos.CidadeDaoImplementacao;
import br.com.cifpag.daoGenericos.DadosUsuarioDao;
import br.com.cifpag.daoGenericos.DadosUsuarioImplementacao;
import br.com.cifpag.daoGenericos.EnderecoDao;
import br.com.cifpag.daoGenericos.EnderecoDaoImplementacao;
import br.com.cifpag.daoGenericos.UsuarioDao;
import br.com.cifpag.daoGenericos.UsuarioDaoImplementacao;

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
	
	@RequestMapping(value = "/Consulta")
	public ModelAndView ViewDashboardIndex() {
		ModelAndView view = new ModelAndView("DadosUsuario/Consulta");
		return view;

	}
	
	@RequestMapping(value = "/Cadastro")
	public ModelAndView Cadastro() {
		DadosUsuario dadosUsuario = new DadosUsuario();
		
		ModelAndView view = new ModelAndView("DadosUsuario/Cadastrar");
		view.addObject("dadosUsuario", dadosUsuario);
		return view;

	}
	
	@RequestMapping(value = "/Editar")
	public ModelAndView Editar(@RequestParam("id") int id) {
		DadosUsuarioDao dao = new DadosUsuarioImplementacao();
		DadosUsuario dadosUsuario = dao.getById(DadosUsuario.class , id);
		
		ModelAndView view = new ModelAndView("DadosUsuario/Editar");		
		view.addObject("dadosUsuario", dadosUsuario);
		return view;

	}
	
	@RequestMapping(value = "/Excluir")
	public String Excluir(@RequestParam("id") int id) {
		try{
			DadosUsuarioDao dao = new DadosUsuarioImplementacao();
			DadosUsuario dadosUsuario = dao.getById(DadosUsuario.class , id);
			dao.remove(dadosUsuario);
			return "redirect:/DadosUsuario/Consulta?mensagem=sucesso";
			
		}catch(Exception ex){
			
			return "redirect:/DadosUsuario/Consulta?mensagem=falha";
			
		}

	}
	
	@RequestMapping(value = "/Salvar", method = RequestMethod.POST)
	public String Salvar(DadosUsuario dadosUsuario, Cidade cidade, Endereco endereco, Usuario usuario) {
		try{
			
			UsuarioDao daoUsuario = new UsuarioDaoImplementacao();
			EnderecoDao daoEndereco = new EnderecoDaoImplementacao();
			DadosUsuarioDao dao = new DadosUsuarioImplementacao();
			
			
			Usuario userSalvo = daoUsuario.save(usuario);			
			endereco.setEndeCidade(Integer.parseInt(cidade.getCidaCidade()));
			Endereco enderecoSalvo = daoEndereco.save(endereco);
			dadosUsuario.setClieUsuario(userSalvo.getUsuaId());
			dadosUsuario.setClieEndereco(enderecoSalvo.getEndeId());
			dao.save(dadosUsuario);
			
			return "redirect:/DadosUsuario/Consulta?mensagem=sucesso";
		}catch(Exception ex){
			return "redirect:/DadosUsuario/Consulta?mensagem=falha";
		}
	}
	
	@RequestMapping(value = "/Alterar")
	public String Alterar(DadosUsuario dadosUsuario) {
			
		DadosUsuarioModel usu = new DadosUsuarioModel();
			if(usu.Salvar(dadosUsuario).equals("sucesso")){
				return "redirect:/DadosUsuario/Consulta?mensagem=sucesso";
			}else{
				return "redirect:/DadosUsuario/Consulta?mensagem=falha";
		}

	}

}