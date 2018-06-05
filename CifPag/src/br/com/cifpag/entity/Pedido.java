package br.com.cifpag.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="pedido", schema="sistema")
public class Pedido implements Serializable {
	
	@Id
	@Column(name="pedi_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer pediId;
	
	@Column(name="pedi_numero_documento")
	private String pediNumeroDocumento;
	
	@Column(name="pedi_cliente_cpf")
	private String pediClienteCpf;
	
	@Column(name="pedi_data_documento")
	private Timestamp pediDataDocumento;
	
	@Column(name="pedi_numero_documento_fiscal")
	private Integer pediNumeroDocumentoFiscal;
	
	@Column(name="pedi_produto", length=50)
	private String pediProduto;
	
	@Column(name="pedi_cliente", length=150)
	private String pediCliente;
	
	@Column(name="pedi_quantidade")
	private Double pediQuantidade;
	
	@Column(name="pedi_unidade", length=2)
	private String pediUnidade;
	
	@Column(name="pedi_preco_unidade_produto")
	private Double pediPrecoUnitarioProduto;
	
	@Column(name="pedi_total_desconto_produto")
	private Double pediTotalDescontoProduto;
	
	@Column(name="pedi_valor_desconto_produto")
	private Double pediValorDescontoProduto;
	
	@Column(name="pedi_porcetagem_desconto_produto")
	private Double pediPorcentagemDescontoProduto;
	
	@Column(name="pedi_empresa")
	private Integer pediEmpresa;
	
	@Column(name="pedi_vendedor")
	private Integer pedi_vendedor; 
	
	@Column(name="pedi_operacao")
	private Integer pediOperacao;

	public String getPediCliente() {
		return pediCliente;
	}

	public void setPediCliente(String pediCliente) {
		this.pediCliente = pediCliente;
	}

	public String getPediClienteCpf() {
		return pediClienteCpf;
	}

	public void setPediClienteCpf(String pediClienteCpf) {
		this.pediClienteCpf = pediClienteCpf;
	}

	public Timestamp getPediDataDocumento() {
		return pediDataDocumento;
	}

	public void setPediDataDocumento(Timestamp pediDataDocumento) {
		this.pediDataDocumento = pediDataDocumento;
	}

	public Integer getPediId() {
		return pediId;
	}

	public void setPediId(Integer pediId) {
		this.pediId = pediId;
	}

	public String getPediNumeroDocumento() {
		return pediNumeroDocumento;
	}

	public void setPediNumeroDocumento(String pediNumeroDocumento) {
		this.pediNumeroDocumento = pediNumeroDocumento;
	}

	public Integer getPediNumeroDocumentoFiscal() {
		return pediNumeroDocumentoFiscal;
	}

	public void setPediNumeroDocumentoFiscal(Integer pediNumeroDocumentoFiscal) {
		this.pediNumeroDocumentoFiscal = pediNumeroDocumentoFiscal;
	}

	public String getPediProduto() {
		return pediProduto;
	}

	public void setPediProduto(String pediProduto) {
		this.pediProduto = pediProduto;
	}

	public Double getPediQuantidade() {
		return pediQuantidade;
	}

	public void setPediQuantidade(Double pediQuantidade) {
		this.pediQuantidade = pediQuantidade;
	}

	public String getPediUnidade() {
		return pediUnidade;
	}

	public void setPediUnidade(String pediUnidade) {
		this.pediUnidade = pediUnidade;
	}

	public Double getPediPrecoUnitarioProduto() {
		return pediPrecoUnitarioProduto;
	}

	public void setPediPrecoUnitarioProduto(Double pediPrecoUnitarioProduto) {
		this.pediPrecoUnitarioProduto = pediPrecoUnitarioProduto;
	}

	public Double getPediTotalDescontoProduto() {
		return pediTotalDescontoProduto;
	}

	public void setPediTotalDescontoProduto(Double pediTotalDescontoProduto) {
		this.pediTotalDescontoProduto = pediTotalDescontoProduto;
	}

	public Double getPediValorDescontoProduto() {
		return pediValorDescontoProduto;
	}

	public void setPediValorDescontoProduto(Double pediValorDescontoProduto) {
		this.pediValorDescontoProduto = pediValorDescontoProduto;
	}

	public Double getPediPorcentagemDescontoProduto() {
		return pediPorcentagemDescontoProduto;
	}

	public void setPediPorcentagemDescontoProduto(Double pediPorcentagemDescontoProduto) {
		this.pediPorcentagemDescontoProduto = pediPorcentagemDescontoProduto;
	}

	public Integer getPediEmpresa() {
		return pediEmpresa;
	}

	public void setPediEmpresa(Integer pediEmpresa) {
		this.pediEmpresa = pediEmpresa;
	}

	public Integer getPedi_vendedor() {
		return pedi_vendedor;
	}

	public void setPedi_vendedor(Integer pedi_vendedor) {
		this.pedi_vendedor = pedi_vendedor;
	}
	
	public Integer getPediOperacao() {
		return pediOperacao;
	}

	public void setPediOperacao(Integer pediOperacao) {
		this.pediOperacao = pediOperacao;
	}

}
