package com.teste.micro.modules.pauta.entity;

import com.teste.micro.modules.enums.EnumSimNao;
import com.teste.micro.modules.votacao.entity.Voto;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;
  private String descricao;
  private String flEmVotacao;
  private Date dtInicio;
  private Date dtFechamento;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "idPauta", insertable = false, updatable = false)
  private List<Voto> votos;

  public Boolean isEmVotacao() {
    if (EnumSimNao.S.name().equals(this.flEmVotacao)) {
      return true;
    }
    return false;
  }
}
