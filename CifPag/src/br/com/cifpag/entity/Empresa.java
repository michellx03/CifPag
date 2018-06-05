package br.com.cifpag.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empresa", schema="sistema")
public class Empresa implements Serializable {

	@Id
	@Column(name="empr_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer emprId;
	
	@Column(name="empr_empresa", length=50)
	private String emprEmpresa;
	
	@Column(name="empr_inscricao_estadual")
	private String emprInscricaoEstadual;
	
	@Column(name="empr_endereco")
	private Integer emprEndereco;
	
	@Column(name="empr_nome_fantasia", length=50)
	private String emprNomeFantasia;
	
	@Column(name="empr_telefone")
	private String emprTelefone;
	
	@Column(name="empr_cnpj")
	private String emprCnpj;

	public Integer getEmprId() {
		return emprId;
	}

	public void setEmprId(Integer emprId) {
		this.emprId = emprId;
	}

	public String getEmprEmpresa() {
		return emprEmpresa;
	}

	public void setEmprEmpresa(String emprEmpresa) {
		this.emprEmpresa = emprEmpresa;
	}

	public String getEmprInscricaoEstadual() {
		return emprInscricaoEstadual;
	}

	public void setEmprInscricaoEstadual(String emprInscricaoEstadual) {
		this.emprInscricaoEstadual = emprInscricaoEstadual;
	}

	public Integer getEmprEndereco() {
		return emprEndereco;
	}

	public void setEmprEndereco(Integer emprEndereco) {
		this.emprEndereco = emprEndereco;
	}

	public String getEmprNomeFantasia() {
		return emprNomeFantasia;
	}

	public void setEmprNomeFantasia(String emprNomeFantasia) {
		this.emprNomeFantasia = emprNomeFantasia;
	}

	public String getEmprTelefone() {
		return emprTelefone;
	}

	public void setEmprTelefone(String emprTelefone) {
		this.emprTelefone = emprTelefone;
	}

	public String getEmprCnpj() {
		return emprCnpj;
	}

	public void setEmprCnpj(String emprCnpj) {
		this.emprCnpj = emprCnpj;
	}
}
