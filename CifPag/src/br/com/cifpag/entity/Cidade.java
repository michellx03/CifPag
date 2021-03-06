package br.com.cifpag.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cidade", schema="sistema")
public class Cidade implements Serializable {

	@Id
	@Column(name="cida_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer cidaId;
	
	@Column(name="cida_cidade", length=50)
	private String cidaCidade;
	
	@Column(name="cida_cep")
	private String cidaCep;

	public Integer getCidaId() {
		return cidaId;
	}

	
	
	public void setCidaId(Integer cidaId) {
		this.cidaId = cidaId;
	}

	public String getCidaCidade() {
		return cidaCidade;
	}

	public void setCidaCidade(String cidaCidade) {
		this.cidaCidade = cidaCidade;
	}

	public String getCidaCep() {
		return cidaCep;
	}

	public void setCidaCep(String cidaCep) {
		this.cidaCep = cidaCep;
	}
}
