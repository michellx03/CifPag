package br.com.cifpag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cifpag.daoGenericos.CidadeDao;
import br.com.cifpag.daoGenericos.CidadeDaoImplementacao;
import br.com.cifpag.entity.Cidade;

@Controller
@RequestMapping("/Cidade")
public class CidadeController {
	
	@RequestMapping(value = "/Consulta")
	public ModelAndView ViewDashboardIndex() {
		ModelAndView view = new ModelAndView("Cidade/Consulta");
		return view;

	}
	
	@RequestMapping(value = "/Cadastro")
	public ModelAndView Cadastro() {
		Cidade cidade = new Cidade();
		ModelAndView view = new ModelAndView("Cidade/CadastroOrEditar");
		view.addObject("cidade", cidade);
		return view;

	}
	
	@RequestMapping(value = "/Editar")
	public ModelAndView Editar(@RequestParam("id") int id) {
		CidadeDao dao = new CidadeDaoImplementacao();
		Cidade cidade = dao.getById(Cidade.class , id);
		
		ModelAndView view = new ModelAndView("Cidade/CadastroOrEditar");		
		view.addObject("cidade", cidade);
		return view;

	}
	
	@RequestMapping(value = "/Excluir")
	public String Excluir(@RequestParam("id") int id) {
		try{
			CidadeDao dao = new CidadeDaoImplementacao();
			Cidade cidade = dao.getById(Cidade.class , id);
			dao.remove(cidade);
			return "redirect:/Cidade/Consulta?mensagem=sucesso";
			
		}catch(Exception ex){
			
			return "redirect:/Cidade/Consulta?mensagem=falha";
			
		}

	}
	
	@RequestMapping(value = "/Salvar", method = RequestMethod.POST)
	public String Salvar(Cidade cidade) {
		try{
			CidadeDao dao = new CidadeDaoImplementacao();
			dao.save(cidade);
			return "redirect:/Cidade/Consulta?mensagem=sucesso";
		}catch(Exception ex){
			return "redirect:/Cidade/Consulta?mensagem=falha";
		}
	}

}
