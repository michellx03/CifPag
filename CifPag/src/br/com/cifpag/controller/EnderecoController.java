package br.com.cifpag.controller;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cifpag.daoGenericos.CidadeDao;
import br.com.cifpag.daoGenericos.CidadeDaoImplementacao;
import br.com.cifpag.daoGenericos.EnderecoDao;
import br.com.cifpag.daoGenericos.EnderecoDaoImplementacao;
import br.com.cifpag.entity.Cidade;
import br.com.cifpag.entity.Endereco;
import br.com.cifpag.uteis.ConexaoEntityFactory;

@Controller
@RequestMapping("/Endereco")
public class EnderecoController {
	
	@RequestMapping(value = "/Consulta")
	public ModelAndView ViewDashboardIndex() {
		ModelAndView view = new ModelAndView("Endereco/Consulta");
		return view;

	}
	
	@RequestMapping(value = "/Cadastro")
	public ModelAndView Cadastro() {
		Endereco endereco = new Endereco();
		ModelAndView view = new ModelAndView("Endereco/CadastroOrEditar");
		view.addObject("endereco", endereco);
		return view;

	}
	
	@RequestMapping(value = "/Editar")
	public ModelAndView Editar(@RequestParam("id") int id) {
		EnderecoDao dao = new EnderecoDaoImplementacao();
		Endereco endereco = dao.getById(Endereco.class , id);
		ModelAndView view = new ModelAndView("Endereco/CadastroOrEditar");		
		view.addObject("endereco", endereco);
		return view;

	}
	
	@RequestMapping(value = "/Excluir")
	public String Excluir(@RequestParam("id") int id) {
		try{
			EnderecoDao dao = new EnderecoDaoImplementacao();
			Endereco endereco = dao.getById(Endereco.class , id);
			dao.remove(endereco);
			return "redirect:/Endereco/Consulta?mensagem=sucesso";
			
		}catch(Exception ex){
			
			return "redirect:/Endereco/Consulta?mensagem=falha";
			
		}

	}
	
	@RequestMapping(value = "/Salvar", method = RequestMethod.POST)
	public String Salvar(Endereco endereco) {
		try{
			EnderecoDao dao = new EnderecoDaoImplementacao();
			dao.save(endereco);
			return "redirect:/Endereco/Consulta?mensagem=sucesso";
		}catch(Exception ex){
			return "redirect:/Endereco/Consulta?mensagem=falha";
		}
	}
	
	@RequestMapping(value = "/EditarPelaEmpresa")
	public ModelAndView EditarPelaEmpresa(@RequestParam("id") int id) {
		EnderecoDao dao = new EnderecoDaoImplementacao();
		Endereco endereco = dao.getById(Endereco.class , id);
		ModelAndView view = new ModelAndView("Endereco/AlteracaoComVinculacao");		
		view.addObject("endereco", endereco);
		return view;
	}
	
	@RequestMapping(value = "/SalvarPelaEmpresa", method = RequestMethod.POST)
	public String SalvarPelaEmpresa(Endereco endereco) {
		try{
			EnderecoDao dao = new EnderecoDaoImplementacao();
			dao.save(endereco);
			
			EntityManager em = new ConexaoEntityFactory().getEntityManager();
			Query query = (Query) em.createNativeQuery("SELECT empr_id FROM sistema.endereco INNER JOIN sistema.empresa ON empr_id = ende_id WHERE ende_id = " + endereco.getEndeId());
			Object obj = query.getSingleResult();
			
			return "redirect:/Empresa/Editar?id=" + obj.toString() + "?mensagem=sucesso";
		}catch(Exception ex){
			return "redirect:/Empresa/Consulta?mensagem=falha";
		}
	}
	
	@RequestMapping(value = "/EditarPeloDadosUsuario")
	public ModelAndView EditarPeloDadosUsuario(@RequestParam("id") int id) {
		EnderecoDao dao = new EnderecoDaoImplementacao();
		Endereco endereco = dao.getById(Endereco.class , id);
		ModelAndView view = new ModelAndView("Endereco/AlteracaoComVinculacaoDadosUsuario");		
		view.addObject("endereco", endereco);
		return view;
	}
	
	@RequestMapping(value = "/SalvarPeloDadosUsuario", method = RequestMethod.POST)
	public String SalvarPeloDadosUsuario(Endereco endereco) {
		try{
			EnderecoDao dao = new EnderecoDaoImplementacao();
			dao.save(endereco);
			
			EntityManager em = new ConexaoEntityFactory().getEntityManager();
			Query query = (Query) em.createNativeQuery("SELECT empr_id FROM sistema.endereco INNER JOIN sistema.empresa ON empr_id = ende_id WHERE ende_id = " + endereco.getEndeId());
			Object obj = query.getSingleResult();
			
			return "redirect:/DadosUsuario/PerfilUsuario?mensagem=sucesso";
		}catch(Exception ex){
			return "redirect:/Empresa/Consulta?mensagem=falha";
		}
	}

}
