package br.com.cifpag.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-03-05T16:55:19.769-0300")
@StaticMetamodel(DadosUsuario.class)
public class DadosUsuario_ {
	public static volatile SingularAttribute<DadosUsuario, Integer> clieId;
	public static volatile SingularAttribute<DadosUsuario, String> clieNome;
	public static volatile SingularAttribute<DadosUsuario, String> clieCnpj;
	public static volatile SingularAttribute<DadosUsuario, String> clieCpf;
	public static volatile SingularAttribute<DadosUsuario, Integer> clieEndereco;
	public static volatile SingularAttribute<DadosUsuario, String> clieNomeFantasia;
	public static volatile SingularAttribute<DadosUsuario, String> clieTelefone;
	public static volatile SingularAttribute<DadosUsuario, String> clieCelular;
	public static volatile SingularAttribute<DadosUsuario, String> clieRg;
	public static volatile SingularAttribute<DadosUsuario, Date> clieDataNascimento;
	public static volatile SingularAttribute<DadosUsuario, Integer> clieTipoPessoa;
}
