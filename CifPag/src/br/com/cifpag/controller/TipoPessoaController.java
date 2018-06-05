package br.com.cifpag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cifpag.daoGenericos.TipoPessoaDao;
import br.com.cifpag.daoGenericos.TipoPessoaDaoImplementacao;
import br.com.cifpag.entity.TipoPessoa;

@Controller
@RequestMapping("/TipoPessoa")
public class TipoPessoaController {

	@RequestMapping(value = "/Consulta")
	public ModelAndView ViewDashboardIndex() {
		ModelAndView view = new ModelAndView("TipoPessoa/Consulta");
		return view;

	}
	
	@RequestMapping(value = "/Editar")
	public ModelAndView ViewDashboardAlteracao(int id) {
		ModelAndView view = new ModelAndView("TipoPessoa/Alteracao");
		view.addObject("id", id);
		return view;

	}
	
	@RequestMapping(value = "/Salvar")
	public String Salvar(TipoPessoa tipoPessoa) {
		try{
			TipoPessoaDao dao = new TipoPessoaDaoImplementacao();
			dao.save(tipoPessoa);
			return "redirect:/TipoPessoa/Consulta?mensagem=sucesso";
		}catch(Exception ex){
			return "redirect:/TipoPessoa/Consulta?mensagem=falha";
		}
	}
}
