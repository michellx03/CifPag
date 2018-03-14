package br.com.cifpag.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-03-14T11:00:00.854-0300")
@StaticMetamodel(Pedido.class)
public class Pedido_ {
	public static volatile SingularAttribute<Pedido, Integer> pediId;
	public static volatile SingularAttribute<Pedido, String> pediNumeroDocumento;
	public static volatile SingularAttribute<Pedido, Date> pediDataDocumento;
	public static volatile SingularAttribute<Pedido, Integer> pediNumeroDocumentoFiscal;
	public static volatile SingularAttribute<Pedido, String> pediProduto;
	public static volatile SingularAttribute<Pedido, Double> pediQuantidade;
	public static volatile SingularAttribute<Pedido, String> pediUnidade;
	public static volatile SingularAttribute<Pedido, Double> pediPrecoUnitarioProduto;
	public static volatile SingularAttribute<Pedido, Double> pediPrecoTotalProduto;
	public static volatile SingularAttribute<Pedido, Double> pediTotalDescontoProduto;
	public static volatile SingularAttribute<Pedido, Double> pediValorDescontoProduto;
	public static volatile SingularAttribute<Pedido, Double> pediPorcentagemDescontoProduto;
	public static volatile SingularAttribute<Pedido, Double> pediTotalPeso;
	public static volatile SingularAttribute<Pedido, Integer> pediQuantidadeTotal;
	public static volatile SingularAttribute<Pedido, Double> pediDescontoTotal;
	public static volatile SingularAttribute<Pedido, Double> pediPorcentagemTotal;
	public static volatile SingularAttribute<Pedido, Double> pediValorTotal;
	public static volatile SingularAttribute<Pedido, Double> pediValorFinal;
	public static volatile SingularAttribute<Pedido, Integer> pediEmpresa;
	public static volatile SingularAttribute<Pedido, Integer> pedi_vendedor;
	public static volatile SingularAttribute<Pedido, Integer> pediCliente;
	public static volatile SingularAttribute<Pedido, Integer> pediOperacao;
}
