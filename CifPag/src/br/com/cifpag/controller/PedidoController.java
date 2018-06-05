package br.com.cifpag.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.validation.*;

import br.com.cifpag.daoGenericos.ArquivosImportadosDao;
import br.com.cifpag.daoGenericos.ArquivosImportadosDaoImplementacao;
import br.com.cifpag.daoGenericos.PedidoDao;
import br.com.cifpag.daoGenericos.PedidoDaoImplementacao;
import br.com.cifpag.entity.ArquivosImportados;
import br.com.cifpag.entity.Pedido;
import br.com.cifpag.model.PedidoModel;
import br.com.cifpag.uteis.ConexaoEntityFactory;

@Controller
@RequestMapping("/Pedido")
public class PedidoController {
	
	@RequestMapping(value = "/Consulta")
	public ModelAndView ViewDashboardAlteracao(String pedido) {
		ModelAndView view = new ModelAndView("Pedido/Consulta");
		view.addObject("pedido", pedido);
		return view;
	}
	
	@RequestMapping(value = "/Pagamento")
	public ModelAndView ViewDashboardPagamento(String pagamento) {
		ModelAndView view = new ModelAndView("Pedido/Pagamento");
		view.addObject("pagamento", pagamento);
		return view;
	}
	

	@RequestMapping(value="/pagamento")
	public String pagamento(String numeroNota, HttpServletRequest request){
		
		String usuarioLogado = (String) request.getSession().getAttribute("usuarioLogado");
		
		PagSeguroController pagSeguro = new PagSeguroController();
		String urlPagamento = pagSeguro.criaPagamento(numeroNota, usuarioLogado);
		return "redirect:"+urlPagamento+"";
	}
	
	@RequestMapping(value="/testeXml")
	public String testeXml(){
		getXMLFiles(new File("/home/michell/Documentos/ls"));
		return "redirect:/Pedido/Consulta?mensagem=sucesso";
	}
	
	public static File[] getXMLFiles(File folder) {
	    List<File> aList = new ArrayList<File>();
	    File[] files = folder.listFiles();
	    for (File pf : files) {

	      if (pf.isFile() && getFileExtensionName(pf).indexOf("xml") != -1) {
	        aList.add(pf);
	      }
	      
	      String caminho = (folder +"/"+ pf.getName());
	      
	      //SALVAR NOME DO ARQUIVO BANCO
	      ArquivosImportados nomeArquivos = new ArquivosImportados();
	      ArquivosImportadosDao arquivoDao = new ArquivosImportadosDaoImplementacao();
	      nomeArquivos.setArimNome(pf.getName());
	      arquivoDao.save(nomeArquivos);
	      
	      EntityManager em = new ConexaoEntityFactory().getEntityManager();
	      Query query = (Query) em.createNativeQuery("SELECT arim_nome FROM sistema.arquivos_importados WHERE arim_nome = "+pf.getName());
	      List<Object[]> list = query.getResultList();
	      
	      //COMPARAR SE O ARQUIVO JA FOI SALVO
	      if(list == null) {
	    	  System.out.println("NOVO ARQUIVO!");
	      }else{
	    	  System.out.println("ARQUIVO JA EXISTE!");
	      }
	      
	      
	      /*
	       * TESTE DE COMPARACAO POR NOME SEPARADO
	      int m;
	      for (m = 0; m < list.size(); m++) {
	    	  System.out.println("List " + list.get(m));
	    	  	
	    	  if (pf.getName().equals(list.get(m))){
	    		  System.out.println("Arquivo ja existe!"); 
	    	  }else{
	    		  ArquivosImportadosDao arquivosDao = new ArquivosImportadosDaoImplementacao();
	    		  ArquivosImportados arquivos_importados = new ArquivosImportados();
	    		  arquivos_importados.setArimNome(String.valueOf(list.get(m)));
	    		  arquivosDao.save(arquivos_importados);
	    		  
	    		  System.out.println("Novo Arquivo!");
	    	  }

		}	  
	    */ 	  
	      
	      
	      try {
	    	  Pedido pedido = new Pedido();
	    	  PedidoDao pedidoDao = new PedidoDaoImplementacao();
	    	  
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				
				try {
					Document doc = builder.parse(caminho);
					
					NodeList listaDeVenda = doc.getElementsByTagName("venda");
					int tamanhoDaLista = listaDeVenda.getLength();
					
					NodeList listaDeProdutos = doc.getElementsByTagName("item");
					int tamanhoDaListaDeProdutos = listaDeProdutos.getLength();
					
					for(int k = 0; k < tamanhoDaListaDeProdutos; k++){
						Node noDeProdutos = listaDeProdutos.item(k);
						
						if(noDeProdutos.getNodeType() == Node.ELEMENT_NODE){
							Element elementoProduto = (Element) noDeProdutos;
							NodeList listaNosFilhosProdutos = elementoProduto.getChildNodes();
							int tamandoListaNosFilhosProdutos = listaNosFilhosProdutos.getLength();
							
							for(int l = 0; l < tamandoListaNosFilhosProdutos; l++){
								Node nosFilhoProdutos = listaNosFilhosProdutos.item(l);
								
								if(nosFilhoProdutos.getNodeType() == Node.ELEMENT_NODE){
									Element elementoNoProduto = (Element) nosFilhoProdutos;
									
									switch(elementoNoProduto.getTagName()){
									case "VDIPRONOME":
										System.out.println("Produto: " + elementoNoProduto.getTextContent());
										pedido.setPediProduto(elementoNoProduto.getTextContent());
										break;
									case "VDIQTDE":
										System.out.println("Quantidade: " + elementoNoProduto.getTextContent());
										pedido.setPediQuantidade(Double.parseDouble(elementoNoProduto.getTextContent()));
										break;
									case "VDIVALOR":
										System.out.println("PrecoUnitario: " + elementoNoProduto.getTextContent());
										pedido.setPediPrecoUnitarioProduto(Double.parseDouble(elementoNoProduto.getTextContent()));
										break;
									}
								}
							}
						}
						
						for(int i = 0; i < tamanhoDaLista; i++ ){
							Node noDeVenda = listaDeVenda.item(i);
							
							if(noDeVenda.getNodeType() == Node.ELEMENT_NODE){
								Element elementoVenda = (Element) noDeVenda;
								NodeList listaNosFilhosVenda = elementoVenda.getChildNodes();
								int tamanhoListaNosFilhosVenda = listaNosFilhosVenda.getLength();
								
								for(int j = 0; j < tamanhoListaNosFilhosVenda; j++){
									Node noFilhosVenda = listaNosFilhosVenda.item(j);
									
									if(noFilhosVenda.getNodeType() == Node.ELEMENT_NODE){
										Element elementoNoVenda = (Element) noFilhosVenda;
										
										switch(elementoNoVenda.getTagName()){
											case "VEDCLINOME":
												System.out.println("Cliente: " + elementoNoVenda.getTextContent());
												pedido.setPediCliente(elementoNoVenda.getTextContent());
												break;
											case "VEDID":
												System.out.println("NumeroDocumento: " + elementoNoVenda.getTextContent());
												pedido.setPediNumeroDocumento(elementoNoVenda.getTextContent());
												break;
											case "VEDABERTURA":
												try{	
													System.out.println("DataDocumento: " + elementoNoVenda.getTextContent());
													String dataSemFormatacao = elementoNoVenda.getTextContent();
													Timestamp ts = Timestamp.valueOf(dataSemFormatacao);
													pedido.setPediDataDocumento(ts);
													
												} catch (Exception e) {
													e.printStackTrace();
												}
											case "CPF":
												System.out.println("CPF: " + elementoNoVenda.getTextContent());												
												pedido.setPediClienteCpf(elementoNoVenda.getTextContent());
												break;	
													
												
										}
									}								
								}							
							}				
							
							pedido.setPediNumeroDocumentoFiscal(123);
							pedido.setPediUnidade("UN");
							pedido.setPediTotalDescontoProduto(23.4);			
							pedido.setPediValorDescontoProduto(14.3);
							pedido.setPediPorcentagemDescontoProduto(14.5);
							pedido.setPediEmpresa(1);
							pedido.setPedi_vendedor(1);						
							pedido.setPediOperacao(1);
							pedidoDao.save(pedido);
							
						}//FIM DO FOR DE DADOS USUARIO
						
					}//FIM DO FOR DE PRODUTOS		
					
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}	
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}	      
	    }
	    return aList.toArray(new File[aList.size()]);
	    
	  }

	  public static String getFileExtensionName(File f) {
	    if (f.getName().indexOf(".") == -1) {
	      return "";
	    } else {
	      return f.getName().substring(f.getName().length() - 3, f.getName().length());
	    }
	  }
	
	@RequestMapping(value = "/LerPedidoXML")
	public String LerPedidoXML() {		
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			try {
				Document doc = builder.parse("/home/michell/Documentos/Softwares/CifPag/Arquivos/arquivoMichel.XML");
				
				NodeList listaDeVenda = doc.getElementsByTagName("venda");
				int tamanhoDaLista = listaDeVenda.getLength();
				
				NodeList listaDeProdutos = doc.getElementsByTagName("item");
				int tamanhoDaListaDeProdutos = listaDeProdutos.getLength();
				
				for(int k = 0; k < tamanhoDaListaDeProdutos; k++){
					Node noDeProdutos = listaDeProdutos.item(k);
					
					if(noDeProdutos.getNodeType() == Node.ELEMENT_NODE){
						Element elementoProduto = (Element) noDeProdutos;
						NodeList listaNosFilhosProdutos = elementoProduto.getChildNodes();
						int tamandoListaNosFilhosProdutos = listaNosFilhosProdutos.getLength();
						
						for(int l = 0; l < tamandoListaNosFilhosProdutos; l++){
							Node nosFilhoProdutos = listaNosFilhosProdutos.item(l);
							
							if(nosFilhoProdutos.getNodeType() == Node.ELEMENT_NODE){
								Element elementoNoProduto = (Element) nosFilhoProdutos;
								
								switch(elementoNoProduto.getTagName()){
								case "VDIPRONOME":
									System.out.println("Produto: " + elementoNoProduto.getTextContent());
									break;
								case "VDIQTDE":
									System.out.println("Quantidade: " + elementoNoProduto.getTextContent());
									break;
								case "VDIVALOR":
									System.out.println("PrecoUnitario: " + elementoNoProduto.getTextContent());
									break;
								}
							}
						}
					}
				}//FIM DO FOR DE PRODUTOS
				
				for(int i = 0; i < tamanhoDaLista; i++ ){
					Node noDeVenda = listaDeVenda.item(i);
					
					if(noDeVenda.getNodeType() == Node.ELEMENT_NODE){
						Element elementoVenda = (Element) noDeVenda;
						NodeList listaNosFilhosVenda = elementoVenda.getChildNodes();
						int tamanhoListaNosFilhosVenda = listaNosFilhosVenda.getLength();
						
						for(int j = 0; j < tamanhoListaNosFilhosVenda; j++){
							Node noFilhosVenda = listaNosFilhosVenda.item(j);
							
							if(noFilhosVenda.getNodeType() == Node.ELEMENT_NODE){
								Element elementoNoVenda = (Element) noFilhosVenda;
								
								switch(elementoNoVenda.getTagName()){
									case "VEDCLINOME":
										System.out.println("Cliente: " + elementoNoVenda.getTextContent());
										break;
									case "VEDID":
										System.out.println("NumeroDocumento: " + elementoNoVenda.getTextContent());
										break;
									case "VEDABERTURA":
										System.out.println("DataDocumento: " + elementoNoVenda.getTextContent());
										break;
								}
							}
						}
					}
				}//FIM DO FOR DE DADOS USUARIO	
				
				//FALTA CRIAR AS FK PARA VINCULACAO AGUARDANDO O CPF
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return "redirect:/Pedido/Consulta?mensagem=sucesso";
	}
	
	//CONTINUA
}
