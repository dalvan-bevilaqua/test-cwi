CREATE TABLE pauta (
  id serial CONSTRAINT PKPAUTA PRIMARY KEY,
  nome VARCHAR (30) NOT NULL,
  descricao VARCHAR(300) NOT NULL,
  fl_em_votacao char(1) DEFAULT('N') CHECK (fl_em_votacao IN ('S', 'N')),
  dt_inicio TIMESTAMP,
  dt_fechamento TIMESTAMP
);