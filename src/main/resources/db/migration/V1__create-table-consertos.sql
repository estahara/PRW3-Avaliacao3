-- Parte 1: tabela de consertos.
-- Veiculo e Mecanico sao "embedded" em Conserto, entao seus campos
-- ficam na mesma tabela (nome_mecanico, marca, modelo, ...).

create table consertos(

    id bigint not null auto_increment,
    data_entrada varchar(10),
    data_saida varchar(10),
    nome varchar(100),
    anos_experiencia int,
    marca varchar(100),
    modelo varchar(100),
    ano varchar(4),

    primary key(id)

);
