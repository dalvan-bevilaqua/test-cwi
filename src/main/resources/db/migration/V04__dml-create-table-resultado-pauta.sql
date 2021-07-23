CREATE TABLE pautaresultado (
  id serial,
  id_pauta INTEGER,
  nm_pauta VARCHAR (30) NOT NULL,
  de_pauta VARCHAR(300) NOT NULL,
  votos_sim INTEGER,
  votos_nao INTEGER
);

ALTER TABLE pautaresultado ADD CONSTRAINT PKPAUTARESULTADO PRIMARY KEY (id);
