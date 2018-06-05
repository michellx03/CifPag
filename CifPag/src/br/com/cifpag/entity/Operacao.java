package br.com.cifpag.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="operacao", schema="sistema")
public class Operacao implements Serializable {

	@Id
	@Column(name="oper_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer operId;
	
	@Column(name="oper_operacao", length=30)
	private String operOperacao;

	public Integer getOperId() {
		return operId;
	}

	public void setOperId(Integer operId) {
		this.operId = operId;
	}

	public String getOperOperacao() {
		return operOperacao;
	}

	public void setOperOperacao(String operOperacao) {
		this.operOperacao = operOperacao;
	}
}
