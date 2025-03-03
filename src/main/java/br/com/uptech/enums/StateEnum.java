package br.com.uptech.enums;

import lombok.Getter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Getter
public enum StateEnum {

  ACRE("AC", "ACRE"),
  ALAGOAS("AL", "ALAGOAS"),
  AMAPA("AP", "AMAPÁ"),
  AMAZONAS("AM", "AMAZONAS"),
  BAHIA("BA", "BAHIA"),
  CEARA("CE", "CEARÁ"),
  ESPIRITO_SANTO("ES", "ESPÍRITO SANTO"),
  GOIAS("GO", "GOIÁS"),
  MARANHAO("MA", "MARANHÃO"),
  MATO_GROSSO("MT", "MATO GROSSO"),
  MATO_GROSSO_DO_SUL("MS", "MATO GROSSO DO SUL"),
  MINAS_GERAIS("MG", "MINAS GERAIS"),
  PARA("PA", "PARÁ"),
  PARAIBA("PB", "PARAÍBA"),
  PARANA("PR", "PARANÁ"),
  PERNAMBUCO("PE", "PERNAMBUCO"),
  PIAUI("PI", "PIAUÍ"),
  RIO_DE_JANEIRO("RJ", "RIO DE JANEIRO"),
  RIO_GRANDE_DO_NORTE("RN", "RIO GRANDE DO NORTE"),
  RIO_GRANDE_DO_SUL("RS", "RIO GRANDE DO SUL"),
  RONDONIA("RO", "RONDÔNIA"),
  RORAIMA("RR", "RORAIMA"),
  SANTA_CATARINA("SC", "SANTA CATARINA"),
  SAO_PAULO("SP", "SÃO PAULO"),
  SERGIPE("SE", "SERGIPE"),
  TOCANTINS("TO", "TOCANTINS"),
  DISTRITO_FEDERAL("DF", "DISTRITO FEDERAL");

  private final String acronym;
  private final String name;

  StateEnum(String acronym, String name) {
    this.acronym = acronym;
    this.name = name;
  }

  public static StateEnum getByAcronym(String acronym) {
    List<StateEnum> states = Arrays.asList(StateEnum.values());
    Optional<StateEnum> s = states.stream().filter(state -> state.acronym.equalsIgnoreCase(acronym)).findFirst();
    return s.orElse(null);
  }
}