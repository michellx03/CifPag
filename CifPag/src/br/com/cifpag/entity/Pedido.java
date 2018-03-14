package br.com.cifpag.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pedido", schema="sistema")
public class Pedido implements Serializable {
	
	@Id
	@Column(name="pedi_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer pediId;
	
	@Column(name="pedi_numero_documento")
	private String pediNumeroDocumento;
	
	@Column(name="pedi_data_documento")
	private Date pediDataDocumento;
	
	@Column(name="pedi_numero_documento_fiscal")
	private Integer pediNumeroDocumentoFiscal;
	
	@Column(name="pedi_produto", length=50)
	private String pediProduto;
	
	@Column(name="pedi_quantidade")
	private Double pediQuantidade;
	
	@Column(name="pedi_unidade", length=2)
	private String pediUnidade;
	
	@Column(name="pedi_preco_unitario_produto")
	private Double pediPrecoUnitarioProduto;
	
	@Column(name="pedi_preco_total_produto")
	private Double pediPrecoTotalProduto;
	
	@Column(name="pedi_total_desconto_produto")
	private Double pediTotalDescontoProduto;
	
	@Column(name="pedi_valor_desconto_produto")
	private Double pediValorDescontoProduto;
	
	@Column(name="pedi_porcentagem_desconto_produto")
	private Double pediPorcentagemDescontoProduto;
	
	@Column(name="pedi_total_peso")
	private Double pediTotalPeso;
	
	@Column(name="pedi_quantidade_total")
	private Integer pediQuantidadeTotal;
	
	@Column(name="pedi_desconto_total")
	private Double pediDescontoTotal;
	
	@Column(name="pedi_porcentagem_total")
	private Double pediPorcentagemTotal;
	
	@Column(name="pedi_valor_total")
	private Double pediValorTotal;
	
	@Column(name="pedi_valor_final")
	private Double pediValorFinal; 
	
	@Column(name="pedi_empresa")
	private Integer pediEmpresa;
	
	@Column(name="pediVendedor")
	private Integer pedi_vendedor; 
	
	@Column(name="pedi_cliente")
	private Integer pediCliente;
	
	@Column(name="pedi_operacao")
	private Integer pediOperacao;

}
