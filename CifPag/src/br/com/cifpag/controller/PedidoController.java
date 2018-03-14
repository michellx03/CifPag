package br.com.cifpag.controller;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Controller
@RequestMapping("/Pedido")
public class PedidoController {

	@RequestMapping(value = "/Consulta")
	public ModelAndView ViewDashboardAlteracao(String pedido) {
		ModelAndView view = new ModelAndView("Pedido/Consulta");
		view.addObject("pedido", pedido);
		return view;
	}
	
	@RequestMapping(value = "/LerPedidoXML")
	public ModelAndView LerPedidoXML() {
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			try {
				Document doc = builder.parse("CAMINHO");
				NodeList listaDeVenda = doc.getElementsByTagName("venda");
				int tamanhoDaLista = listaDeVenda.getLength();
				
				for(int i = 0; i < tamanhoDaLista; i++ ){
					Node noDeVenda = listaDeVenda.item(i);
					
					if(noDeVenda.getNodeType() == Node.ELEMENT_NODE){
						Element elementVenda = (Element) noDeVenda;
											
					}
				}	
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
