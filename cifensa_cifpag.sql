--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.13
-- Dumped by pg_dump version 9.5.13

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: controle_acesso; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA controle_acesso;


ALTER SCHEMA controle_acesso OWNER TO postgres;

--
-- Name: sistema; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA sistema;


ALTER SCHEMA sistema OWNER TO postgres;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: regra; Type: TABLE; Schema: controle_acesso; Owner: postgres
--

CREATE TABLE controle_acesso.regra (
    regr_id integer NOT NULL,
    regr_controller text,
    regr_nome_exibido text
);


ALTER TABLE controle_acesso.regra OWNER TO postgres;

--
-- Name: regra_regr_id_seq; Type: SEQUENCE; Schema: controle_acesso; Owner: postgres
--

CREATE SEQUENCE controle_acesso.regra_regr_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE controle_acesso.regra_regr_id_seq OWNER TO postgres;

--
-- Name: regra_regr_id_seq; Type: SEQUENCE OWNED BY; Schema: controle_acesso; Owner: postgres
--

ALTER SEQUENCE controle_acesso.regra_regr_id_seq OWNED BY controle_acesso.regra.regr_id;


--
-- Name: usuario; Type: TABLE; Schema: controle_acesso; Owner: postgres
--

CREATE TABLE controle_acesso.usuario (
    usua_id integer NOT NULL,
    usua_usuario text,
    usua_senha text
);


ALTER TABLE controle_acesso.usuario OWNER TO postgres;

--
-- Name: usuario_regra; Type: TABLE; Schema: controle_acesso; Owner: postgres
--

CREATE TABLE controle_acesso.usuario_regra (
    usre_id integer NOT NULL,
    usre_usua_id integer,
    usre_regr_id integer
);


ALTER TABLE controle_acesso.usuario_regra OWNER TO postgres;

--
-- Name: usuario_regra_usre_id_seq; Type: SEQUENCE; Schema: controle_acesso; Owner: postgres
--

CREATE SEQUENCE controle_acesso.usuario_regra_usre_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE controle_acesso.usuario_regra_usre_id_seq OWNER TO postgres;

--
-- Name: usuario_regra_usre_id_seq; Type: SEQUENCE OWNED BY; Schema: controle_acesso; Owner: postgres
--

ALTER SEQUENCE controle_acesso.usuario_regra_usre_id_seq OWNED BY controle_acesso.usuario_regra.usre_id;


--
-- Name: usuario_usua_id_seq; Type: SEQUENCE; Schema: controle_acesso; Owner: postgres
--

CREATE SEQUENCE controle_acesso.usuario_usua_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE controle_acesso.usuario_usua_id_seq OWNER TO postgres;

--
-- Name: usuario_usua_id_seq; Type: SEQUENCE OWNED BY; Schema: controle_acesso; Owner: postgres
--

ALTER SEQUENCE controle_acesso.usuario_usua_id_seq OWNED BY controle_acesso.usuario.usua_id;


--
-- Name: arquivos_importados; Type: TABLE; Schema: sistema; Owner: postgres
--

CREATE TABLE sistema.arquivos_importados (
    arim_id integer NOT NULL,
    arim_nome text,
    arim_arquivo bytea
);


ALTER TABLE sistema.arquivos_importados OWNER TO postgres;

--
-- Name: arquivos_importados_armi_id_seq; Type: SEQUENCE; Schema: sistema; Owner: postgres
--

CREATE SEQUENCE sistema.arquivos_importados_armi_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sistema.arquivos_importados_armi_id_seq OWNER TO postgres;

--
-- Name: arquivos_importados_armi_id_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: postgres
--

ALTER SEQUENCE sistema.arquivos_importados_armi_id_seq OWNED BY sistema.arquivos_importados.arim_id;


--
-- Name: cidade; Type: TABLE; Schema: sistema; Owner: postgres
--

CREATE TABLE sistema.cidade (
    cida_id integer NOT NULL,
    cida_cidade character varying(50),
    cida_cep integer
);


ALTER TABLE sistema.cidade OWNER TO postgres;

--
-- Name: cidade_cida_id_seq; Type: SEQUENCE; Schema: sistema; Owner: postgres
--

CREATE SEQUENCE sistema.cidade_cida_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sistema.cidade_cida_id_seq OWNER TO postgres;

--
-- Name: cidade_cida_id_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: postgres
--

ALTER SEQUENCE sistema.cidade_cida_id_seq OWNED BY sistema.cidade.cida_id;


--
-- Name: dados_usuario; Type: TABLE; Schema: sistema; Owner: postgres
--

CREATE TABLE sistema.dados_usuario (
    clie_id integer NOT NULL,
    clie_nome character varying(50),
    clie_cnpj text,
    clie_cpf text,
    clie_endereco integer,
    clie_nome_fantasia character varying(50),
    clie_telefone text,
    clie_celular text,
    clie_rg text,
    clie_usuario integer,
    clie_data_nascimento date,
    clie_tipo_pessoa integer
);


ALTER TABLE sistema.dados_usuario OWNER TO postgres;

--
-- Name: empresa; Type: TABLE; Schema: sistema; Owner: postgres
--

CREATE TABLE sistema.empresa (
    empr_id integer NOT NULL,
    empr_empresa character varying(50),
    empr_inscricao_estadual text,
    empr_endereco integer,
    empr_nome_fantasia character varying(50),
    empr_telefone text,
    empr_cnpj text
);


ALTER TABLE sistema.empresa OWNER TO postgres;

--
-- Name: empresa_empr_id_seq; Type: SEQUENCE; Schema: sistema; Owner: postgres
--

CREATE SEQUENCE sistema.empresa_empr_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sistema.empresa_empr_id_seq OWNER TO postgres;

--
-- Name: empresa_empr_id_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: postgres
--

ALTER SEQUENCE sistema.empresa_empr_id_seq OWNED BY sistema.empresa.empr_id;


--
-- Name: endereco; Type: TABLE; Schema: sistema; Owner: postgres
--

CREATE TABLE sistema.endereco (
    ende_id integer NOT NULL,
    ende_endereco character varying(30),
    ende_bairro character varying(30),
    ende_numero integer,
    ende_cidade integer
);


ALTER TABLE sistema.endereco OWNER TO postgres;

--
-- Name: endereco_ende_id_seq; Type: SEQUENCE; Schema: sistema; Owner: postgres
--

CREATE SEQUENCE sistema.endereco_ende_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sistema.endereco_ende_id_seq OWNER TO postgres;

--
-- Name: endereco_ende_id_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: postgres
--

ALTER SEQUENCE sistema.endereco_ende_id_seq OWNED BY sistema.endereco.ende_id;


--
-- Name: operacao; Type: TABLE; Schema: sistema; Owner: postgres
--

CREATE TABLE sistema.operacao (
    oper_id integer NOT NULL,
    oper_opercao character varying(30),
    oper_operacao character varying(30)
);


ALTER TABLE sistema.operacao OWNER TO postgres;

--
-- Name: operacao_oper_id_seq; Type: SEQUENCE; Schema: sistema; Owner: postgres
--

CREATE SEQUENCE sistema.operacao_oper_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sistema.operacao_oper_id_seq OWNER TO postgres;

--
-- Name: operacao_oper_id_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: postgres
--

ALTER SEQUENCE sistema.operacao_oper_id_seq OWNED BY sistema.operacao.oper_id;


--
-- Name: pedido; Type: TABLE; Schema: sistema; Owner: postgres
--

CREATE TABLE sistema.pedido (
    pedi_id integer NOT NULL,
    pedi_numero_documento text,
    pedi_data_documento timestamp with time zone,
    pedi_numero_documento_fiscal integer,
    pedi_produto character varying(50),
    pedi_unidade character varying(2),
    pedi_quantidade double precision,
    pedi_preco_unidade_produto double precision,
    pedi_total_desconto_produto double precision,
    pedi_valor_desconto_produto double precision,
    pedi_porcetagem_desconto_produto double precision,
    pedi_empresa integer,
    pedi_vendedor integer,
    pedi_operacao integer,
    pedi_cliente_cpf text,
    pedi_cliente character varying(150),
    pedi_cliente_cnpj text
);


ALTER TABLE sistema.pedido OWNER TO postgres;

--
-- Name: pedido_pedi_id_seq; Type: SEQUENCE; Schema: sistema; Owner: postgres
--

CREATE SEQUENCE sistema.pedido_pedi_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sistema.pedido_pedi_id_seq OWNER TO postgres;

--
-- Name: pedido_pedi_id_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: postgres
--

ALTER SEQUENCE sistema.pedido_pedi_id_seq OWNED BY sistema.pedido.pedi_id;


--
-- Name: produto; Type: TABLE; Schema: sistema; Owner: postgres
--

CREATE TABLE sistema.produto (
    produto_id integer NOT NULL,
    descricao character varying(255),
    foto character varying(50000),
    nome character varying(255)
);


ALTER TABLE sistema.produto OWNER TO postgres;

--
-- Name: produto_produto_id_seq; Type: SEQUENCE; Schema: sistema; Owner: postgres
--

CREATE SEQUENCE sistema.produto_produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sistema.produto_produto_id_seq OWNER TO postgres;

--
-- Name: produto_produto_id_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: postgres
--

ALTER SEQUENCE sistema.produto_produto_id_seq OWNED BY sistema.produto.produto_id;


--
-- Name: tipo_pessoa; Type: TABLE; Schema: sistema; Owner: postgres
--

CREATE TABLE sistema.tipo_pessoa (
    tipo_id integer NOT NULL,
    tipo_tipo_pessoa character varying(30)
);


ALTER TABLE sistema.tipo_pessoa OWNER TO postgres;

--
-- Name: tipo_pessoa_tipo_id_seq; Type: SEQUENCE; Schema: sistema; Owner: postgres
--

CREATE SEQUENCE sistema.tipo_pessoa_tipo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sistema.tipo_pessoa_tipo_id_seq OWNER TO postgres;

--
-- Name: tipo_pessoa_tipo_id_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: postgres
--

ALTER SEQUENCE sistema.tipo_pessoa_tipo_id_seq OWNED BY sistema.tipo_pessoa.tipo_id;


--
-- Name: vendedor; Type: TABLE; Schema: sistema; Owner: postgres
--

CREATE TABLE sistema.vendedor (
    vend_id integer NOT NULL,
    vend_vendedor character varying(50),
    vend_telefone text
);


ALTER TABLE sistema.vendedor OWNER TO postgres;

--
-- Name: vendedor_vend_id_seq; Type: SEQUENCE; Schema: sistema; Owner: postgres
--

CREATE SEQUENCE sistema.vendedor_vend_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sistema.vendedor_vend_id_seq OWNER TO postgres;

--
-- Name: vendedor_vend_id_seq; Type: SEQUENCE OWNED BY; Schema: sistema; Owner: postgres
--

ALTER SEQUENCE sistema.vendedor_vend_id_seq OWNED BY sistema.vendedor.vend_id;


--
-- Name: regr_id; Type: DEFAULT; Schema: controle_acesso; Owner: postgres
--

ALTER TABLE ONLY controle_acesso.regra ALTER COLUMN regr_id SET DEFAULT nextval('controle_acesso.regra_regr_id_seq'::regclass);


--
-- Name: usua_id; Type: DEFAULT; Schema: controle_acesso; Owner: postgres
--

ALTER TABLE ONLY controle_acesso.usuario ALTER COLUMN usua_id SET DEFAULT nextval('controle_acesso.usuario_usua_id_seq'::regclass);


--
-- Name: usre_id; Type: DEFAULT; Schema: controle_acesso; Owner: postgres
--

ALTER TABLE ONLY controle_acesso.usuario_regra ALTER COLUMN usre_id SET DEFAULT nextval('controle_acesso.usuario_regra_usre_id_seq'::regclass);


--
-- Name: arim_id; Type: DEFAULT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.arquivos_importados ALTER COLUMN arim_id SET DEFAULT nextval('sistema.arquivos_importados_armi_id_seq'::regclass);


--
-- Name: cida_id; Type: DEFAULT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.cidade ALTER COLUMN cida_id SET DEFAULT nextval('sistema.cidade_cida_id_seq'::regclass);


--
-- Name: empr_id; Type: DEFAULT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.empresa ALTER COLUMN empr_id SET DEFAULT nextval('sistema.empresa_empr_id_seq'::regclass);


--
-- Name: ende_id; Type: DEFAULT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.endereco ALTER COLUMN ende_id SET DEFAULT nextval('sistema.endereco_ende_id_seq'::regclass);


--
-- Name: oper_id; Type: DEFAULT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.operacao ALTER COLUMN oper_id SET DEFAULT nextval('sistema.operacao_oper_id_seq'::regclass);


--
-- Name: pedi_id; Type: DEFAULT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.pedido ALTER COLUMN pedi_id SET DEFAULT nextval('sistema.pedido_pedi_id_seq'::regclass);


--
-- Name: produto_id; Type: DEFAULT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.produto ALTER COLUMN produto_id SET DEFAULT nextval('sistema.produto_produto_id_seq'::regclass);


--
-- Name: tipo_id; Type: DEFAULT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.tipo_pessoa ALTER COLUMN tipo_id SET DEFAULT nextval('sistema.tipo_pessoa_tipo_id_seq'::regclass);


--
-- Name: vend_id; Type: DEFAULT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.vendedor ALTER COLUMN vend_id SET DEFAULT nextval('sistema.vendedor_vend_id_seq'::regclass);


--
-- Data for Name: regra; Type: TABLE DATA; Schema: controle_acesso; Owner: postgres
--

COPY controle_acesso.regra (regr_id, regr_controller, regr_nome_exibido) FROM stdin;
2	ControleAcesso	Controle de Acesso
1	Usuario	Usuario
3	Vendedor	Controle de vendedores
4	TipoPessoa	Controle tipo pessoa
5	Pedido	Controle de pedidos
6	Operacao	Controle de operacao
7	Endereco	Controle de enderecos
8	Empresa	Controle de empresas
9	DadosUsuario	Controle dados usuario
10	Cidade	Controle de cidade
11	Produto	Pagina WEB de produtos
\.


--
-- Name: regra_regr_id_seq; Type: SEQUENCE SET; Schema: controle_acesso; Owner: postgres
--

SELECT pg_catalog.setval('controle_acesso.regra_regr_id_seq', 11, true);


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: controle_acesso; Owner: postgres
--

COPY controle_acesso.usuario (usua_id, usua_usuario, usua_senha) FROM stdin;
1	fernando	fernando
2	fernando2	fernando2
5	root	toor
\.


--
-- Data for Name: usuario_regra; Type: TABLE DATA; Schema: controle_acesso; Owner: postgres
--

COPY controle_acesso.usuario_regra (usre_id, usre_usua_id, usre_regr_id) FROM stdin;
26	2	1
31	1	2
32	1	1
45	5	9
46	5	2
47	5	10
48	5	8
49	5	7
50	5	6
51	5	5
52	5	3
53	5	4
54	5	11
55	5	1
\.


--
-- Name: usuario_regra_usre_id_seq; Type: SEQUENCE SET; Schema: controle_acesso; Owner: postgres
--

SELECT pg_catalog.setval('controle_acesso.usuario_regra_usre_id_seq', 55, true);


--
-- Name: usuario_usua_id_seq; Type: SEQUENCE SET; Schema: controle_acesso; Owner: postgres
--

SELECT pg_catalog.setval('controle_acesso.usuario_usua_id_seq', 5, true);


--
-- Data for Name: arquivos_importados; Type: TABLE DATA; Schema: sistema; Owner: postgres
--

COPY sistema.arquivos_importados (arim_id, arim_nome, arim_arquivo) FROM stdin;
73	arquivo3.XML	\\x3c3f786d6c2076657273696f6e3d22312e302220656e636f64696e673d2249534f2d383835392d31
74	arquivo1.XML	\\x3c3f786d6c2076657273696f6e3d22312e302220656e636f64696e673d2249534f2d383835392d31
75	arquivo2.XML	\\x3c3f786d6c2076657273696f6e3d22312e302220656e636f64696e673d2249534f2d383835392d31
76	arquivo3.XML	\\x3c3f786d6c2076657273696f6e3d22312e302220656e636f64696e673d2249534f2d383835392d31
77	arquivo1.XML	\\x3c3f786d6c2076657273696f6e3d22312e302220656e636f64696e673d2249534f2d383835392d31
78	arquivo2.XML	\\x3c3f786d6c2076657273696f6e3d22312e302220656e636f64696e673d2249534f2d383835392d31
\.


--
-- Name: arquivos_importados_armi_id_seq; Type: SEQUENCE SET; Schema: sistema; Owner: postgres
--

SELECT pg_catalog.setval('sistema.arquivos_importados_armi_id_seq', 78, true);


--
-- Data for Name: cidade; Type: TABLE DATA; Schema: sistema; Owner: postgres
--

COPY sistema.cidade (cida_id, cida_cidade, cida_cep) FROM stdin;
1	Ceres	7630000
\.


--
-- Name: cidade_cida_id_seq; Type: SEQUENCE SET; Schema: sistema; Owner: postgres
--

SELECT pg_catalog.setval('sistema.cidade_cida_id_seq', 1, true);


--
-- Data for Name: dados_usuario; Type: TABLE DATA; Schema: sistema; Owner: postgres
--

COPY sistema.dados_usuario (clie_id, clie_nome, clie_cnpj, clie_cpf, clie_endereco, clie_nome_fantasia, clie_telefone, clie_celular, clie_rg, clie_usuario, clie_data_nascimento, clie_tipo_pessoa) FROM stdin;
1	Michell Cesar	22.436.708/0001-22	111.1111.111-58	1	sdfsdfsdf	66546	65464	564654	5	19995-03-14	1
\.


--
-- Data for Name: empresa; Type: TABLE DATA; Schema: sistema; Owner: postgres
--

COPY sistema.empresa (empr_id, empr_empresa, empr_inscricao_estadual, empr_endereco, empr_nome_fantasia, empr_telefone, empr_cnpj) FROM stdin;
1	Cifensa	01254	1	Cifensa	85255	54654
\.


--
-- Name: empresa_empr_id_seq; Type: SEQUENCE SET; Schema: sistema; Owner: postgres
--

SELECT pg_catalog.setval('sistema.empresa_empr_id_seq', 1, true);


--
-- Data for Name: endereco; Type: TABLE DATA; Schema: sistema; Owner: postgres
--

COPY sistema.endereco (ende_id, ende_endereco, ende_bairro, ende_numero, ende_cidade) FROM stdin;
1	Rua	Centro	12	1
\.


--
-- Name: endereco_ende_id_seq; Type: SEQUENCE SET; Schema: sistema; Owner: postgres
--

SELECT pg_catalog.setval('sistema.endereco_ende_id_seq', 1, true);


--
-- Data for Name: operacao; Type: TABLE DATA; Schema: sistema; Owner: postgres
--

COPY sistema.operacao (oper_id, oper_opercao, oper_operacao) FROM stdin;
1	Operacao	\N
\.


--
-- Name: operacao_oper_id_seq; Type: SEQUENCE SET; Schema: sistema; Owner: postgres
--

SELECT pg_catalog.setval('sistema.operacao_oper_id_seq', 1, true);


--
-- Data for Name: pedido; Type: TABLE DATA; Schema: sistema; Owner: postgres
--

COPY sistema.pedido (pedi_id, pedi_numero_documento, pedi_data_documento, pedi_numero_documento_fiscal, pedi_produto, pedi_unidade, pedi_quantidade, pedi_preco_unidade_produto, pedi_total_desconto_produto, pedi_valor_desconto_produto, pedi_porcetagem_desconto_produto, pedi_empresa, pedi_vendedor, pedi_operacao, pedi_cliente_cpf, pedi_cliente, pedi_cliente_cnpj) FROM stdin;
470	192385	2017-12-05 10:08:40-02	123	PERFIL CHAPA #14 BATENTE	UN	6.95999999999999996	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	\N	\N	\N
471	192385	2017-12-05 10:08:40-02	123	PERFIL U BAT 15X30X40X30X15 #14	UN	6.04000000000000004	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	\N	\N	\N
472	192385	2017-12-05 10:08:40-02	123	DISCO DE CORTE INOX 7" - 178 TYROLIT	UN	1	6.62000000000000011	23.3999999999999986	14.3000000000000007	14.5	1	1	1	\N	\N	\N
473	192385	2017-12-05 10:08:40-02	123	ELETRODO STAR 2,50 350 X 5	UN	1	11.5700000000000003	23.3999999999999986	14.3000000000000007	14.5	1	1	1	\N	\N	\N
506	192382	2017-12-05 10:08:40-02	123	PERFIL CHAPA #20 BATENTE	UN	6.95999999999999996	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	111.1111.111-58	\N	\N
507	192382	2017-12-05 10:08:40-02	123	PERFIL U berro #14	UN	6.04000000000000004	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	111.1111.111-58	\N	\N
508	192382	2017-12-05 10:08:40-02	123	DISCO DE CORTE INOX 7" - 178 TYROLIT	UN	1	6.62000000000000011	23.3999999999999986	14.3000000000000007	14.5	1	1	1	111.1111.111-58	\N	\N
509	192382	2017-12-05 10:08:40-02	123	ELETRODO STAR 2,50 350 X 5	UN	1	11.5700000000000003	23.3999999999999986	14.3000000000000007	14.5	1	1	1	111.1111.111-58	\N	\N
514	192370	2017-12-05 10:08:40-02	123	RATO	UN	6.95999999999999996	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	333.333.333-58	TESTE	\N
515	192370	2017-12-05 10:08:40-02	123	PEDRA	UN	6.04000000000000004	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	333.333.333-58	TESTE	\N
516	192370	2017-12-05 10:08:40-02	123	DISCO DE CORTE INOX 7" - 178 TYROLIT	UN	1	6.62000000000000011	23.3999999999999986	14.3000000000000007	14.5	1	1	1	333.333.333-58	TESTE	\N
517	192370	2017-12-05 10:08:40-02	123	ELETRODO STAR 2,50 350 X 5	UN	1	11.5700000000000003	23.3999999999999986	14.3000000000000007	14.5	1	1	1	333.333.333-58	TESTE	\N
522	11222	2017-12-05 10:08:40-02	123	PERFIL	UN	6.95999999999999996	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	222.222.222-58	KIRITO ASUMA	\N
523	11222	2017-12-05 10:08:40-02	123	kasdasT 15X30X40X30X15 #14	UN	6.04000000000000004	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	222.222.222-58	KIRITO ASUMA	\N
524	11222	2017-12-05 10:08:40-02	123	DISCO DE CORTE INOX 7" - 178 TYROLIT	UN	1	6.62000000000000011	23.3999999999999986	14.3000000000000007	14.5	1	1	1	222.222.222-58	KIRITO ASUMA	\N
525	11222	2017-12-05 10:08:40-02	123	ELETRODO STAR 2,50 350 X 5	UN	1	11.5700000000000003	23.3999999999999986	14.3000000000000007	14.5	1	1	1	222.222.222-58	KIRITO ASUMA	\N
530	192382332	2017-12-05 10:08:40-02	123	PERFIL CHAPA #20 BATENTE	UN	6.95999999999999996	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	111.1111.111-58	CESAR ALVES SOARES	\N
531	192382332	2017-12-05 10:08:40-02	123	PERFIL U berro #14	UN	6.04000000000000004	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	111.1111.111-58	CESAR ALVES SOARES	\N
532	192382332	2017-12-05 10:08:40-02	123	DISCO DE CORTE INOX 7" - 178 TYROLIT	UN	1	6.62000000000000011	23.3999999999999986	14.3000000000000007	14.5	1	1	1	111.1111.111-58	CESAR ALVES SOARES	\N
533	192382332	2017-12-05 10:08:40-02	123	ELETRODO STAR 2,50 350 X 5	UN	1	11.5700000000000003	23.3999999999999986	14.3000000000000007	14.5	1	1	1	111.1111.111-58	CESAR ALVES SOARES	\N
542	192382332	2017-12-05 10:08:40-02	123	PERFIL CHAPA #20 BATENTE	UN	6.95999999999999996	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	2017-12-05 10:08:40	CESAR ALVES SOARES	\N
543	192382332	2017-12-05 10:08:40-02	123	PERFIL U berro #14	UN	6.04000000000000004	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	2017-12-05 10:08:40	CESAR ALVES SOARES	\N
544	192382332	2017-12-05 10:08:40-02	123	DISCO DE CORTE INOX 7" - 178 TYROLIT	UN	1	6.62000000000000011	23.3999999999999986	14.3000000000000007	14.5	1	1	1	2017-12-05 10:08:40	CESAR ALVES SOARES	\N
545	192382332	2017-12-05 10:08:40-02	123	ELETRODO STAR 2,50 350 X 5	UN	1	11.5700000000000003	23.3999999999999986	14.3000000000000007	14.5	1	1	1	2017-12-05 10:08:40	CESAR ALVES SOARES	\N
466	192385	2017-12-05 10:08:40-02	123	RATO	UN	6.95999999999999996	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	\N	\N	\N
467	192385	2017-12-05 10:08:40-02	123	PEDRA	UN	6.04000000000000004	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	\N	\N	\N
468	192385	2017-12-05 10:08:40-02	123	DISCO DE CORTE INOX 7" - 178 TYROLIT	UN	1	6.62000000000000011	23.3999999999999986	14.3000000000000007	14.5	1	1	1	\N	\N	\N
469	192385	2017-12-05 10:08:40-02	123	ELETRODO STAR 2,50 350 X 5	UN	1	11.5700000000000003	23.3999999999999986	14.3000000000000007	14.5	1	1	1	\N	\N	\N
475	11111	2017-12-05 10:08:40-02	123	PERFIL U BAT 15X30X40X30X15 #14	UN	6.04000000000000004	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	\N	\N	\N
476	11111	2017-12-05 10:08:40-02	123	DISCO DE CORTE INOX 7" - 178 TYROLIT	UN	1	6.62000000000000011	23.3999999999999986	14.3000000000000007	14.5	1	1	1	\N	\N	\N
477	11111	2017-12-05 10:08:40-02	123	ELETRODO STAR 2,50 350 X 5	UN	1	11.5700000000000003	23.3999999999999986	14.3000000000000007	14.5	1	1	1	\N	\N	\N
474	11111	2017-12-05 10:08:40-02	123	PERFIL CHAPA #14 BATENTE	UN	6.95999999999999996	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	\N	\N	\N
518	192382	2017-12-05 10:08:40-02	123	PERFIL CHAPA #20 BATENTE	UN	6.95999999999999996	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	111.1111.111-58	MICHELL CESAR ALVES SOARES	\N
519	192382	2017-12-05 10:08:40-02	123	PERFIL U berro #14	UN	6.04000000000000004	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	111.1111.111-58	MICHELL CESAR ALVES SOARES	\N
502	192370	2017-12-05 10:08:40-02	123	RATO	UN	6.95999999999999996	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	333.333.333-58	\N	\N
503	192370	2017-12-05 10:08:40-02	123	PEDRA	UN	6.04000000000000004	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	333.333.333-58	\N	\N
504	192370	2017-12-05 10:08:40-02	123	DISCO DE CORTE INOX 7" - 178 TYROLIT	UN	1	6.62000000000000011	23.3999999999999986	14.3000000000000007	14.5	1	1	1	333.333.333-58	\N	\N
505	192370	2017-12-05 10:08:40-02	123	ELETRODO STAR 2,50 350 X 5	UN	1	11.5700000000000003	23.3999999999999986	14.3000000000000007	14.5	1	1	1	333.333.333-58	\N	\N
510	11222	2017-12-05 10:08:40-02	123	PERFIL	UN	6.95999999999999996	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	222.222.222-58	\N	\N
511	11222	2017-12-05 10:08:40-02	123	kasdasT 15X30X40X30X15 #14	UN	6.04000000000000004	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	222.222.222-58	\N	\N
512	11222	2017-12-05 10:08:40-02	123	DISCO DE CORTE INOX 7" - 178 TYROLIT	UN	1	6.62000000000000011	23.3999999999999986	14.3000000000000007	14.5	1	1	1	222.222.222-58	\N	\N
513	11222	2017-12-05 10:08:40-02	123	ELETRODO STAR 2,50 350 X 5	UN	1	11.5700000000000003	23.3999999999999986	14.3000000000000007	14.5	1	1	1	222.222.222-58	\N	\N
520	192382	2017-12-05 10:08:40-02	123	DISCO DE CORTE INOX 7" - 178 TYROLIT	UN	1	6.62000000000000011	23.3999999999999986	14.3000000000000007	14.5	1	1	1	111.1111.111-58	MICHELL CESAR ALVES SOARES	\N
521	192382	2017-12-05 10:08:40-02	123	ELETRODO STAR 2,50 350 X 5	UN	1	11.5700000000000003	23.3999999999999986	14.3000000000000007	14.5	1	1	1	111.1111.111-58	MICHELL CESAR ALVES SOARES	\N
526	19237053645	2017-12-05 10:08:40-02	123	RATO	UN	6.95999999999999996	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	333.333.333-58	GIGAGIANO	\N
527	19237053645	2017-12-05 10:08:40-02	123	PEDRA	UN	6.04000000000000004	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	333.333.333-58	GIGAGIANO	\N
528	19237053645	2017-12-05 10:08:40-02	123	DISCO DE CORTE INOX 7" - 178 TYROLIT	UN	1	6.62000000000000011	23.3999999999999986	14.3000000000000007	14.5	1	1	1	333.333.333-58	GIGAGIANO	\N
529	19237053645	2017-12-05 10:08:40-02	123	ELETRODO STAR 2,50 350 X 5	UN	1	11.5700000000000003	23.3999999999999986	14.3000000000000007	14.5	1	1	1	333.333.333-58	GIGAGIANO	\N
534	1122286456	2017-12-05 10:08:40-02	123	PERFIL	UN	6.95999999999999996	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	222.222.222-58	ASUMA	\N
535	1122286456	2017-12-05 10:08:40-02	123	kasdasT 15X30X40X30X15 #14	UN	6.04000000000000004	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	222.222.222-58	ASUMA	\N
536	1122286456	2017-12-05 10:08:40-02	123	DISCO DE CORTE INOX 7" - 178 TYROLIT	UN	1	6.62000000000000011	23.3999999999999986	14.3000000000000007	14.5	1	1	1	222.222.222-58	ASUMA	\N
537	1122286456	2017-12-05 10:08:40-02	123	ELETRODO STAR 2,50 350 X 5	UN	1	11.5700000000000003	23.3999999999999986	14.3000000000000007	14.5	1	1	1	222.222.222-58	ASUMA	\N
538	19237053645	2017-12-05 10:08:40-02	123	RATO	UN	6.95999999999999996	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	2017-12-05 10:08:40	GIGAGIANO	\N
539	19237053645	2017-12-05 10:08:40-02	123	PEDRA	UN	6.04000000000000004	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	2017-12-05 10:08:40	GIGAGIANO	\N
540	19237053645	2017-12-05 10:08:40-02	123	DISCO DE CORTE INOX 7" - 178 TYROLIT	UN	1	6.62000000000000011	23.3999999999999986	14.3000000000000007	14.5	1	1	1	2017-12-05 10:08:40	GIGAGIANO	\N
541	19237053645	2017-12-05 10:08:40-02	123	ELETRODO STAR 2,50 350 X 5	UN	1	11.5700000000000003	23.3999999999999986	14.3000000000000007	14.5	1	1	1	2017-12-05 10:08:40	GIGAGIANO	\N
546	1122286456	2017-12-05 10:08:40-02	123	PERFIL	UN	6.95999999999999996	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	2017-12-05 10:08:40	ASUMA	\N
547	1122286456	2017-12-05 10:08:40-02	123	kasdasT 15X30X40X30X15 #14	UN	6.04000000000000004	5.13699999999999957	23.3999999999999986	14.3000000000000007	14.5	1	1	1	2017-12-05 10:08:40	ASUMA	\N
548	1122286456	2017-12-05 10:08:40-02	123	DISCO DE CORTE INOX 7" - 178 TYROLIT	UN	1	6.62000000000000011	23.3999999999999986	14.3000000000000007	14.5	1	1	1	2017-12-05 10:08:40	ASUMA	\N
549	1122286456	2017-12-05 10:08:40-02	123	ELETRODO STAR 2,50 350 X 5	UN	1	11.5700000000000003	23.3999999999999986	14.3000000000000007	14.5	1	1	1	2017-12-05 10:08:40	ASUMA	\N
\.


--
-- Name: pedido_pedi_id_seq; Type: SEQUENCE SET; Schema: sistema; Owner: postgres
--

SELECT pg_catalog.setval('sistema.pedido_pedi_id_seq', 549, true);


--
-- Data for Name: produto; Type: TABLE DATA; Schema: sistema; Owner: postgres
--

COPY sistema.produto (produto_id, descricao, foto, nome) FROM stdin;
1	25x25	data:image/jpeg;base64,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	Chapa
\.


--
-- Name: produto_produto_id_seq; Type: SEQUENCE SET; Schema: sistema; Owner: postgres
--

SELECT pg_catalog.setval('sistema.produto_produto_id_seq', 1, true);


--
-- Data for Name: tipo_pessoa; Type: TABLE DATA; Schema: sistema; Owner: postgres
--

COPY sistema.tipo_pessoa (tipo_id, tipo_tipo_pessoa) FROM stdin;
1	Fisica
2	Juridica
\.


--
-- Name: tipo_pessoa_tipo_id_seq; Type: SEQUENCE SET; Schema: sistema; Owner: postgres
--

SELECT pg_catalog.setval('sistema.tipo_pessoa_tipo_id_seq', 2, true);


--
-- Data for Name: vendedor; Type: TABLE DATA; Schema: sistema; Owner: postgres
--

COPY sistema.vendedor (vend_id, vend_vendedor, vend_telefone) FROM stdin;
1	Vendedor	86545
\.


--
-- Name: vendedor_vend_id_seq; Type: SEQUENCE SET; Schema: sistema; Owner: postgres
--

SELECT pg_catalog.setval('sistema.vendedor_vend_id_seq', 1, true);


--
-- Name: pk_regr_id; Type: CONSTRAINT; Schema: controle_acesso; Owner: postgres
--

ALTER TABLE ONLY controle_acesso.regra
    ADD CONSTRAINT pk_regr_id PRIMARY KEY (regr_id);


--
-- Name: pk_usre_id; Type: CONSTRAINT; Schema: controle_acesso; Owner: postgres
--

ALTER TABLE ONLY controle_acesso.usuario_regra
    ADD CONSTRAINT pk_usre_id PRIMARY KEY (usre_id);


--
-- Name: pk_usua_usuario_id; Type: CONSTRAINT; Schema: controle_acesso; Owner: postgres
--

ALTER TABLE ONLY controle_acesso.usuario
    ADD CONSTRAINT pk_usua_usuario_id PRIMARY KEY (usua_id);


--
-- Name: arim_id_pk; Type: CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.arquivos_importados
    ADD CONSTRAINT arim_id_pk PRIMARY KEY (arim_id);


--
-- Name: cida_id_pk; Type: CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.cidade
    ADD CONSTRAINT cida_id_pk PRIMARY KEY (cida_id);


--
-- Name: clie_id; Type: CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.dados_usuario
    ADD CONSTRAINT clie_id PRIMARY KEY (clie_id);


--
-- Name: empr_id_pk; Type: CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.empresa
    ADD CONSTRAINT empr_id_pk PRIMARY KEY (empr_id);


--
-- Name: ende_id_pk; Type: CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.endereco
    ADD CONSTRAINT ende_id_pk PRIMARY KEY (ende_id);


--
-- Name: oper_id_pk; Type: CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.operacao
    ADD CONSTRAINT oper_id_pk PRIMARY KEY (oper_id);


--
-- Name: pedi_id_pk; Type: CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.pedido
    ADD CONSTRAINT pedi_id_pk PRIMARY KEY (pedi_id);


--
-- Name: produto_pkey; Type: CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (produto_id);


--
-- Name: tipo_id_pk; Type: CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.tipo_pessoa
    ADD CONSTRAINT tipo_id_pk PRIMARY KEY (tipo_id);


--
-- Name: vend_id_pk; Type: CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.vendedor
    ADD CONSTRAINT vend_id_pk PRIMARY KEY (vend_id);


--
-- Name: fk_regr_id; Type: FK CONSTRAINT; Schema: controle_acesso; Owner: postgres
--

ALTER TABLE ONLY controle_acesso.usuario_regra
    ADD CONSTRAINT fk_regr_id FOREIGN KEY (usre_regr_id) REFERENCES controle_acesso.regra(regr_id);


--
-- Name: fk_usua_id; Type: FK CONSTRAINT; Schema: controle_acesso; Owner: postgres
--

ALTER TABLE ONLY controle_acesso.usuario_regra
    ADD CONSTRAINT fk_usua_id FOREIGN KEY (usre_usua_id) REFERENCES controle_acesso.usuario(usua_id);


--
-- Name: clie_endereco_fk; Type: FK CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.dados_usuario
    ADD CONSTRAINT clie_endereco_fk FOREIGN KEY (clie_endereco) REFERENCES sistema.endereco(ende_id);


--
-- Name: clie_tipo_pessoa_fk; Type: FK CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.dados_usuario
    ADD CONSTRAINT clie_tipo_pessoa_fk FOREIGN KEY (clie_tipo_pessoa) REFERENCES sistema.tipo_pessoa(tipo_id);


--
-- Name: clie_usuario_fk; Type: FK CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.dados_usuario
    ADD CONSTRAINT clie_usuario_fk FOREIGN KEY (clie_usuario) REFERENCES controle_acesso.usuario(usua_id);


--
-- Name: empr_endereco_fk; Type: FK CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.empresa
    ADD CONSTRAINT empr_endereco_fk FOREIGN KEY (empr_endereco) REFERENCES sistema.endereco(ende_id);


--
-- Name: ende_cidade_fk; Type: FK CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.endereco
    ADD CONSTRAINT ende_cidade_fk FOREIGN KEY (ende_cidade) REFERENCES sistema.cidade(cida_id);


--
-- Name: pedi_empresa_fk; Type: FK CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.pedido
    ADD CONSTRAINT pedi_empresa_fk FOREIGN KEY (pedi_empresa) REFERENCES sistema.empresa(empr_id);


--
-- Name: pedi_operacao_fk; Type: FK CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.pedido
    ADD CONSTRAINT pedi_operacao_fk FOREIGN KEY (pedi_operacao) REFERENCES sistema.operacao(oper_id);


--
-- Name: pedi_vendedor_fk; Type: FK CONSTRAINT; Schema: sistema; Owner: postgres
--

ALTER TABLE ONLY sistema.pedido
    ADD CONSTRAINT pedi_vendedor_fk FOREIGN KEY (pedi_vendedor) REFERENCES sistema.vendedor(vend_id);


--
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

