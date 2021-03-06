package br.com.cifpag.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendedor", schema="sistema")
public class Vendedor implements Serializable {

	@Id
	@Column(name="vend_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer vendId;
	
	@Column(name="vend_vendedor", length=50)
	private String vendVendedor;
	
	@Column(name="vend_telefone")
	private String vendTelefone;

	public Integer getVendId() {
		return vendId;
	}

	public void setVendId(Integer vendId) {
		this.vendId = vendId;
	}

	public String getVendVendedor() {
		return vendVendedor;
	}

	public void setVendVendedor(String vendVendedor) {
		this.vendVendedor = vendVendedor;
	}

	public String getVendTelefone() {
		return vendTelefone;
	}

	public void setVendTelefone(String vendTelefone) {
		this.vendTelefone = vendTelefone;
	}
}
