package br.com.cifpag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cifpag.daoGenericos.VendedorDao;
import br.com.cifpag.daoGenericos.VendedorDaoImplementacao;
import br.com.cifpag.entity.Vendedor;

@Controller
@RequestMapping("/Vendedor")
public class VendedorController {

	@RequestMapping(value = "/Consulta")
	public ModelAndView ViewDashboardIndex() {
		ModelAndView view = new ModelAndView("Vendedor/Consulta");
		return view;

	}
	
	@RequestMapping(value = "/Cadastro")
	public ModelAndView Cadastro() {
		Vendedor vendedor = new Vendedor();
		ModelAndView view = new ModelAndView("Vendedor/CadastroOrEditar");
		view.addObject("vendedor", vendedor);
		return view;

	}
	
	@RequestMapping(value = "/Editar")
	public ModelAndView Editar(@RequestParam("id") int id) {
		VendedorDao dao = new VendedorDaoImplementacao();
		Vendedor vendedor = dao.getById(Vendedor.class , id);	
		ModelAndView view = new ModelAndView("Vendedor/CadastroOrEditar");		
		view.addObject("vendedor", vendedor);
		return view;

	}
	
	@RequestMapping(value = "/Excluir")
	public String Excluir(@RequestParam("id") int id) {
		try{
			VendedorDao dao = new VendedorDaoImplementacao();
			Vendedor vendedor = dao.getById(Vendedor.class , id);
			dao.remove(vendedor);
			return "redirect:/Vendedor/Consulta?mensagem=sucesso";
			
		}catch(Exception ex){
			
			return "redirect:/Vendedor/Consulta?mensagem=falha";
			
		}

	}
	
	@RequestMapping(value = "/Salvar", method = RequestMethod.POST)
	public String Salvar(Vendedor vendedor) {
		try{
			VendedorDao dao = new VendedorDaoImplementacao();
			dao.save(vendedor);
			return "redirect:/Vendedor/Consulta?mensagem=sucesso";
		}catch(Exception ex){
			return "redirect:/Vendedor/Consulta?mensagem=falha";
		}
	}
}
