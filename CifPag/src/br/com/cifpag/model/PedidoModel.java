package br.com.cifpag.model;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.cifpag.daoGenericos.PedidoDao;
import br.com.cifpag.daoGenericos.PedidoDaoImplementacao;
import br.com.cifpag.daoGenericos.UsuarioDao;
import br.com.cifpag.daoGenericos.UsuarioDaoImplementacao;
import br.com.cifpag.entity.Pedido;
import br.com.cifpag.entity.Usuario;

public class PedidoModel {
	
	protected EntityManager em;

	  public PedidoModel() {
	    this.em = em;
	  }

	public Collection<Pedido> findAll() {
	    Query query = em.createQuery("SELECT p FROM Pedido p");
	    return (Collection<Pedido>) query.getResultList();
	  }
	
	public String create(Pedido pedido) {

		try {
			PedidoDao pedidoDAO = new PedidoDaoImplementacao();
			pedidoDAO.save(pedido);
			return "sucesso";
		} catch (Exception ex) {
			return "falha";
		}
	}
}
