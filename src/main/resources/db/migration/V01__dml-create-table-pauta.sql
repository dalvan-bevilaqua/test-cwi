CREATE TABLE pauta (
  id serial,
  nome VARCHAR (30) NOT NULL,
  descricao VARCHAR(300) NOT NULL,
  fl_em_votacao char(1) DEFAULT('N') CHECK (fl_em_votacao IN ('S', 'N')),
  dt_inicio TIMESTAMP,
  dt_fechamento TIMESTAMP
);

ALTER TABLE pauta ADD CONSTRAINT PKPAUTA PRIMARY KEY (id);