package br.com.cifpag.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-28T18:37:26.116-0300")
@StaticMetamodel(Empresa.class)
public class Empresa_ {
	public static volatile SingularAttribute<Empresa, Integer> emprId;
	public static volatile SingularAttribute<Empresa, String> emprEmpresa;
	public static volatile SingularAttribute<Empresa, String> emprInscricaoEstadual;
	public static volatile SingularAttribute<Empresa, Integer> emprEndereco;
	public static volatile SingularAttribute<Empresa, String> emprNomeFantasia;
	public static volatile SingularAttribute<Empresa, String> emprTelefone;
	public static volatile SingularAttribute<Empresa, String> emprCnpj;
}