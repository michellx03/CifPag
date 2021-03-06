package br.com.cifpag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cifpag.daoGenericos.EmpresaDao;
import br.com.cifpag.daoGenericos.EmpresaDaoImplementacao;
import br.com.cifpag.entity.Empresa;

@Controller
@RequestMapping("/Empresa")
public class EmpresaController {

	@RequestMapping(value = "/Consulta")
	public ModelAndView ViewDashboardIndex() {
		ModelAndView view = new ModelAndView("Empresa/Consulta");
		return view;

	}
	
	@RequestMapping(value = "/Editar")
	public ModelAndView ViewDashboardAlteracao(int id) {
		ModelAndView view = new ModelAndView("Empresa/Alteracao");
		view.addObject("id", id);
		return view;

	}
	
	@RequestMapping(value = "/Salvar")
	public String Salvar(Empresa empresa) {
		try{
			EmpresaDao dao = new EmpresaDaoImplementacao();
			dao.save(empresa);
			return "redirect:/Empresa/Consulta?mensagem=sucesso";
		}catch(Exception ex){
			return "redirect:/Empresa/Consulta?mensagem=falha";
		}
	}
	
}
