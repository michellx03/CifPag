package br.com.cifpag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cifpag.daoGenericos.OperacaoDao;
import br.com.cifpag.daoGenericos.OperacaoDaoImplementacao;
import br.com.cifpag.entity.Operacao;

@Controller
@RequestMapping("/Operacao")
public class OperacaoController {

	@RequestMapping(value = "/Consulta")
	public ModelAndView ViewDashboardIndex() {
		ModelAndView view = new ModelAndView("Operacao/Consulta");
		return view;

	}
	
	@RequestMapping(value = "/Cadastro")
	public ModelAndView Cadastro() {
		Operacao operacao = new Operacao();
		ModelAndView view = new ModelAndView("Operacao/CadastroOrEditar");
		view.addObject("operacao", operacao);
		return view;

	}
	
	@RequestMapping(value = "/Editar")
	public ModelAndView Editar(@RequestParam("id") int id) {
		OperacaoDao dao = new OperacaoDaoImplementacao();
		Operacao operacao = dao.getById(Operacao.class , id);
		ModelAndView view = new ModelAndView("Operacao/CadastroOrEditar");		
		view.addObject("operacao", operacao);
		return view;

	}
	
	@RequestMapping(value = "/Excluir")
	public String Excluir(@RequestParam("id") int id) {
		try{
			OperacaoDao dao = new OperacaoDaoImplementacao();
			Operacao operacao = dao.getById(Operacao.class , id);
			dao.remove(operacao);
			return "redirect:/Operacao/Consulta?mensagem=sucesso";
			
		}catch(Exception ex){
			
			return "redirect:/Operacao/Consulta?mensagem=falha";
			
		}

	}
	
	@RequestMapping(value = "/Salvar", method = RequestMethod.POST)
	public String Salvar(Operacao operacao) {
		try{
			OperacaoDao dao = new OperacaoDaoImplementacao();
			dao.save(operacao);
			return "redirect:/Operacao/Consulta?mensagem=sucesso";
		}catch(Exception ex){
			return "redirect:/Operacao/Consulta?mensagem=falha";
		}
	}
}
