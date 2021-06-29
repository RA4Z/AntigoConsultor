CREATE TABLE consultor(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    skill text not null,
    telefone varchar(45) not null,
    primary key (id)
);