package br.com.cifpag.controller;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cifpag.uteis.ConexaoEntityFactory;
import br.com.cifpag.uteis.GetSessionIDPagSeguro;
import br.com.uol.pagseguro.domain.AccountCredentials;
import br.com.uol.pagseguro.domain.Address;
import br.com.uol.pagseguro.domain.Credentials;
import br.com.uol.pagseguro.domain.Item;
import br.com.uol.pagseguro.domain.Phone;
import br.com.uol.pagseguro.domain.Sender;
import br.com.uol.pagseguro.domain.Shipping;
import br.com.uol.pagseguro.domain.Transaction;
import br.com.uol.pagseguro.domain.checkout.Checkout;
import br.com.uol.pagseguro.domain.PaymentRequest;
import br.com.uol.pagseguro.enums.Currency;
import br.com.uol.pagseguro.enums.DocumentType;
import br.com.uol.pagseguro.enums.MetaDataItemKey;
import br.com.uol.pagseguro.enums.ShippingType;
import br.com.uol.pagseguro.service.NotificationService;
import br.com.uol.pagseguro.exception.PagSeguroServiceException;
import br.com.uol.pagseguro.properties.PagSeguroConfig;

@Controller
@Scope(value = "request")
public class PagSeguroController {
	
	@RequestMapping(value = "/pagseguro-criapagamento")
	public @ResponseBody
	String criaPagamento(String numeroNota, String usuarioLogado) {
		
		String urlPagamento = "";
		
		Checkout checkout = new Checkout();
		
		 EntityManager em = new ConexaoEntityFactory().getEntityManager();
	      Query query = (Query) em.createNativeQuery("SELECT pedi_produto, pedi_quantidade, pedi_preco_unidade_produto FROM sistema.pedido WHERE pedi_numero_documento = '"+numeroNota+"'");
	      List<Object[]> list = query.getResultList();
	      for (Object[] obj : list) {
	    	  
	    	  String produto = (String) obj[0];
	    	  
	    	  Double quantidade = (Double) obj[1];
	    	  Double precoUnitario = (Double) obj[2];	
	    	  
	    	  Double total = quantidade * precoUnitario;	    	   
	    	  DecimalFormat fmt = new DecimalFormat("0.00");  
	  	      String string = fmt.format(total);
	  	      String[] part = string.split("[,]");
	  	      String preco = part[0]+"."+part[1];
	    	  
	    	  checkout.addItem("0001" , produto , Integer.valueOf(1), new BigDecimal(preco), new Long(1000), null);
	      }
	      
	      try{
	    	  
	    	  //ID USUARIO
		      EntityManager emIdDausUsuario = new ConexaoEntityFactory().getEntityManager();
		      Query queryIdDausUsuario = (Query) emIdDausUsuario.createNativeQuery("SELECT clie_id FROM sistema.dados_usuario INNER JOIN controle_acesso.usuario ON clie_usuario = usua_id WHERE usua_usuario  = '"+usuarioLogado+"'");
		      Object idDausUsuario = queryIdDausUsuario.getSingleResult();
		      System.out.println("idUsuario: " + idDausUsuario);
	      
	      //ENDERECO USUARIO
	      EntityManager emEndereco = new ConexaoEntityFactory().getEntityManager();
	      Query queryEndereco = (Query) emEndereco.createNativeQuery("SELECT ende_endereco, ende_bairro, ende_numero, ende_cidade, cida_cidade, cida_cep FROM sistema.endereco INNER JOIN sistema.cidade ON ende_cidade = cida_id INNER JOIN sistema.dados_usuario ON clie_endereco = ende_id WHERE clie_id = "+idDausUsuario);
	      Object endereco = queryEndereco.getResultList();
	      System.out.println("Endereco: " + endereco);

	      checkout.setShippingAddress("BRA", "SP", "Sao Paulo", "Jardim Paulistano", "01452002", "Av. Brig. Faria Lima", "1384", "5o andar");
	      
	      //PUXAR DADOS USUARIO
	      EntityManager emDadosUsuario = new ConexaoEntityFactory().getEntityManager();
	      Query queryDadosUsuario = (Query) emDadosUsuario.createNativeQuery("SELECT ende_endereco, ende_bairro, ende_numero, ende_cidade, cida_cidade, cida_cep FROM sistema.endereco INNER JOIN sistema.cidade ON ende_cidade = cida_id INNER JOIN sistema.dados_usuario ON clie_endereco = ende_id WHERE clie_id = "+idDausUsuario);
	      Object dadosUsuario = queryDadosUsuario.getResultList();
	      
	      checkout.setSender("João Comprador", "comprador@uol.com.br", "11", "56273440", DocumentType.CPF, "000.000.001-91");
	      
	      //FAZER IF para saber se e CPF ou CNPJ
	      
	      }catch(Exception ex) {
	    	  ex.printStackTrace();
	    	  System.out.println("AQUI: " + ex);
	      }
		checkout.setShippingType(ShippingType.PAC);
		checkout.setShippingCost(new BigDecimal("0.00"));

		checkout.setCurrency(Currency.BRL);
		checkout.setReference("REF1234");
		checkout.setNotificationURL("http://www.meusite.com.br/notification");
		checkout.setRedirectURL("http://www.meusite.com.br/redir");

		try {

			Boolean onlyCheckoutCode = false;			
			
			String checkoutURL = checkout.register(PagSeguroConfig.getAccountCredentials(), onlyCheckoutCode);

			System.out.println(checkoutURL);
			urlPagamento = checkoutURL;

		} catch (PagSeguroServiceException e) {
			System.err.println(e.getMessage());
		}	
		
		return urlPagamento;
	}
	
	
	/*
	//NOTIFICACAO
	@RequestMapping(value = "/pagseguro-notificacao", method = RequestMethod.POST)
	public @ResponseBody String registrarNotificacao(@RequestParam(value = "notificationCode") String nCode, @RequestParam(value = "notificationType") String nType) {
		try{
			Transaction transaction = NotificationService.checkTransaction(getCredentials(), nCode);
			
			switch (transaction.getStatus()){
			case PAID:
				//TRANSACAO PAGA
				break;
			case CANCELLED:
				//TRANSACAO CANCELADA
				break;
			case WAITING_PAYMENT:
				//TRANSACAO AGUARDANDO PAGAMENTO
			case IN_ANALYSIS:
				//TRANSACAO EM ANALISE
				break;
			}
		} catch (PagSeguroServiceException ex) {
			Logger.getLogger(PagSeguroController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return "1";
	}	
	*/
	
	public static String converterDoubleString(double precoDouble) {
	    /*Transformando um double em 2 casas decimais*/
	    DecimalFormat fmt = new DecimalFormat("0.00");   //limita o número de casas decimais    
	    String string = fmt.format(precoDouble);
	    String[] part = string.split("[,]");
	    String preco = part[0]+"."+part[1];
	    return preco;
	}
}




class SessionID {
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
}
