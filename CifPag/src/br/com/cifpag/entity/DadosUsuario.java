package br.com.cifpag.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="dados_usuario", schema="sistema")
public class DadosUsuario implements Serializable {

	@Id
	@Column(name="clie_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer clieId;
	
	@Column(name="clie_nome", length=50)
	private String clieNome;
	
	@Column(name="clie_cnpj")
	private String clieCnpj;
	
	@Column(name="clie_cpf")
	private String clieCpf;
	
	@Column(name="clie_endereco")
	private Integer clieEndereco;
	
	@Column(name="clie_nome_fantasia", length=50)
	private String clieNomeFantasia;
	
	@Column(name="clie_telefone")
	private String clieTelefone;
	
	@Column(name="clie_celular")
	private String clieCelular;
	
	@Column(name="clie_rg")
	private String clieRg;
	
	@Column(name="clie_data_nascimento")
	private Date clieDataNascimento;
	
	@Column(name="clie_tipo_pessoa")
	private Integer clieTipoPessoa;
	
	@Column(name="clie_usuario")
	private Integer clieUsuario;

	public Integer getClieUsuario() {
		return clieUsuario;
	}

	public void setClieUsuario(Integer clieUsuario) {
		this.clieUsuario = clieUsuario;
	}

	public Date getClieDataNascimento() {
		return clieDataNascimento;
	}

	public void setClieDataNascimento(Date clieDataNascimento) {
		this.clieDataNascimento = clieDataNascimento;
	}

	public Integer getClieTipoPessoa() {
		return clieTipoPessoa;
	}

	public void setClieTipoPessoa(Integer clieTipoPessoa) {
		this.clieTipoPessoa = clieTipoPessoa;
	}

	public Integer getClieId() {
		return clieId;
	}

	public void setClieId(Integer clieId) {
		this.clieId = clieId;
	}

	public String getClieNome() {
		return clieNome;
	}

	public void setClieNome(String clieNome) {
		this.clieNome = clieNome;
	}

	public String getClieCnpj() {
		return clieCnpj;
	}

	public void setClieCnpj(String clieCnpj) {
		this.clieCnpj = clieCnpj;
	}

	public String getClieCpf() {
		return clieCpf;
	}

	public void setClieCpf(String clieCpf) {
		this.clieCpf = clieCpf;
	}

	public Integer getClieEndereco() {
		return clieEndereco;
	}

	public void setClieEndereco(Integer clieEndereco) {
		this.clieEndereco = clieEndereco;
	}

	public String getClieNomeFantasia() {
		return clieNomeFantasia;
	}

	public void setClieNomeFantasia(String clieNomeFantasia) {
		this.clieNomeFantasia = clieNomeFantasia;
	}

	public String getClieTelefone() {
		return clieTelefone;
	}

	public void setClieTelefone(String clieTelefone) {
		this.clieTelefone = clieTelefone;
	}

	public String getClieCelular() {
		return clieCelular;
	}

	public void setClieCelular(String clieCelular) {
		this.clieCelular = clieCelular;
	}

	public String getClieRg() {
		return clieRg;
	}

	public void setClieRg(String clieRg) {
		this.clieRg = clieRg;
	}

public DadosUsuario(){
	
	clieDataNascimento = Date.valueOf(LocalDate.of(1995, 02, 10));
}

}
