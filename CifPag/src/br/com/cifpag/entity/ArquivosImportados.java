package br.com.cifpag.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="arquivos_importados", schema="sistema")
public class ArquivosImportados {

	@Id
	@Column(name="arim_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long arimId;
	 
	@Column(name="arim_nome")
	private String arimNome;

	public Long getArimId() {
		return arimId;
	}

	public void setArimId(Long arimId) {
		this.arimId = arimId;
	}

	public String getArimNome() {
		return arimNome;
	}

	public void setArimNome(String arimNome) {
		this.arimNome = arimNome;
	}
	  
}
