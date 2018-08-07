package br.com.cifpag.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-08-01T13:54:10.143-0300")
@StaticMetamodel(Endereco.class)
public class Endereco_ {
	public static volatile SingularAttribute<Endereco, Integer> endeId;
	public static volatile SingularAttribute<Endereco, String> endeEndereco;
	public static volatile SingularAttribute<Endereco, String> endeBairro;
	public static volatile SingularAttribute<Endereco, Integer> endeNumero;
	public static volatile SingularAttribute<Endereco, Integer> endeCidade;
}
