package com.cwi.testcwi.modules.pauta.entity;

import com.cwi.testcwi.modules.votacao.entity.Voto;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pauta")
public class Pauta implements Serializable {

  private static final long serialVersionUID = -3096091941864799543L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String nome;
  private String descricao;
  private String flEmVotacao;
  private Timestamp dtFechamento;

  @OneToMany
  @JoinColumn(name = "id_pauta", insertable = false, updatable = false)
  private List<Voto> votoList;

}
