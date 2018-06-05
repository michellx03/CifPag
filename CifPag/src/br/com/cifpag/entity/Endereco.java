package br.com.cifpag.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="endereco", schema="sistema")
public class Endereco implements Serializable {

	@Id
	@Column(name="ende_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer endeId;
	
	@Column(name="ende_endereco", length=40)
	private String endeEndereco;
	
	@Column(name="ende_bairro", length=30)
	private String endeBairro;
	
	@Column(name="ende_numero")
	private Integer endeNumero;
	
	@Column(name="ende_cidade")
	private Integer endeCidade;

	public Integer getEndeId() {
		return endeId;
	}

	public void setEndeId(Integer endeId) {
		this.endeId = endeId;
	}

	public String getEndeEndereco() {
		return endeEndereco;
	}

	public void setEndeEndereco(String endeEndereco) {
		this.endeEndereco = endeEndereco;
	}

	public String getEndeBairro() {
		return endeBairro;
	}

	public void setEndeBairro(String endeBairro) {
		this.endeBairro = endeBairro;
	}

	public Integer getEndeNumero() {
		return endeNumero;
	}

	public void setEndeNumero(Integer endeNumero) {
		this.endeNumero = endeNumero;
	}

	public Integer getEndeCidade() {
		return endeCidade;
	}

	public void setEndeCidade(Integer endeCidade) {
		this.endeCidade = endeCidade;
	}
}
