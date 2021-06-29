CREATE TABLE cards (
  id int(11) NOT NULL AUTO_INCREMENT,
  secao varchar(60) NOT NULL,
  nome varchar(60) NOT NULL,
  status varchar(30) NOT NULL,
  data_inicio varchar(50) NOT NULL,
  data_estimada varchar(50) NOT NULL,
  horas_estimadas int(11) NOT NULL,
  horas_apontadas int(11),
  PRIMARY KEY (id)
);