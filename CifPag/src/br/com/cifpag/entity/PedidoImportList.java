package br.com.cifpag.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class PedidoImportList {
	
	private List<Pedido> pedidoImport;

	public PedidoImportList() {
		super();
	}
	
	public PedidoImportList(List<Pedido> pedidoImport) {
	
		super();
		this.pedidoImport = pedidoImport;
	}

	public List<Pedido> getPedidoImport() {
		return pedidoImport;
	}

	@XmlElement(name = "pedido")
	public void setPedido(List<Pedido> pedidoImport) {
		this.pedidoImport = pedidoImport;
	}
}
