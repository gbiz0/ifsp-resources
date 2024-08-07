CREATE TABLE contraventor (
    id_cont serial, 
    nome_cont character varying(50), 
    cpf_cont character varying (14), 
    login_cont character varying (30), 
    senha_cont character varying (128), 
    tipo_cont character varying (13),
    CONSTRAINT contraventor_pkey PRIMARY KEY (id_cont), 
    CONSTRAINT contraventor_cpf_key UNIQUE (cpf_cont), 
    CONSTRAINT contraventor_login_key UNIQUE (login_cont)
);

CREATE TABLE bicho (
    id_bicho serial, 
    nome_bicho VARCHAR(50),
    tipo_bicho VARCHAR(50),
    id_cont integer,
    val_aposta numeric(20,2),
    banca_aposta character varying(50),
    CONSTRAINT bicho_pkey PRIMARY KEY (id_bicho),
    CONSTRAINT contraventor_fkey FOREIGN KEY (id_cont) REFERENCES contraventor (id_cont)
);

CREATE TABLE cliente (
    id_cli serial, 
    nome_cli character varying (50), 
    logradouro_cli character varying (50), 
    numero_cli integer, 
    bairro_cli character varying (30), 
    cidade_cli character varying (30), 
    estado_cli character varying(2), 
    cep_cli character varying(9), 
    cpf_cli character varying (14), 
    rg_cli character varying (15),
    CONSTRAINT cliente_pkey PRIMARY KEY (id_cli),
    CONSTRAINT cliente_cpf_key UNIQUE (cpf_cli)
);

CREATE TABLE aposta (
    id_aposta integer NOT NULL,
    valor_aposta numeric(20,2),
    id_cli integer
    CONSTRAINT aposta_pkey PRIMARY KEY (id_aposta),
    CONSTRAINT aposta_id_cli_fkey FOREIGN KEY (id_cli) REFERENCES cliente (id_cli)
);

CREATE TABLE bicho_aposta (
    id_bicho integer,
    id_aposta integer,
    val_bicho double precision,
    qtd_bicho integer,
    CONSTRAINT bicho_aposta_id_bicho_fkey FOREIGN KEY (id_bicho) REFERENCES bicho (id_bicho),
    CONSTRAINT bicho_aposta_id_aposta_fkey FOREIGN KEY (id_aposta) REFERENCES aposta (id_aposta)
);
