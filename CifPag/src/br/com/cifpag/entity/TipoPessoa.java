package br.com.cifpag.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_pessoa", schema="sistema")
public class TipoPessoa implements Serializable {

	@Id
	@Column(name="tipo_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer tipoId;
	
	@Column(name="tipo_tipo_pessoa", length=30)
	private String tipoTipoPessoa;

	public Integer getTipoId() {
		return tipoId;
	}

	public void setTipoId(Integer tipoId) {
		this.tipoId = tipoId;
	}

	public String getTipoTipoPessoa() {
		return tipoTipoPessoa;
	}

	public void setTipoTipoPessoa(String tipoTipoPessoa) {
		this.tipoTipoPessoa = tipoTipoPessoa;
	}
}
