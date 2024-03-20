CREATE TABLE bicho (
    id_cli SERIAL PRIMARY KEY,
    nome_cli VARCHAR(50), 
    numero_cli INTEGER,
    bairro_cli VARCHAR(30),
    cidade_cli VARCHAR(30),
    estado_cli VARCHAR(2),
    cpf_cli VARCHAR(14) UNIQUE,
    telefone_cli VARCHAR(11),
    nome_bicho VARCHAR(50),
    tipo_aposta VARCHAR(50),
    valor_aposta DECIMAL(20, 2),
    banca_aposta VARCHAR(50),
    datahora_aposta TIMESTAMP
);