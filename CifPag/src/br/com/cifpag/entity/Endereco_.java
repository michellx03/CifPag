package br.com.cifpag.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-15T21:35:10.007-0200")
@StaticMetamodel(Endereco.class)
public class Endereco_ {
	public static volatile SingularAttribute<Endereco, Integer> endeId;
	public static volatile SingularAttribute<Endereco, String> endeEndereco;
	public static volatile SingularAttribute<Endereco, String> endeBairro;
	public static volatile SingularAttribute<Endereco, Integer> endeNumero;
	public static volatile SingularAttribute<Endereco, Integer> endeCidade;
}
