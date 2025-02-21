package br.com.uptech.teams.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TeamDTO {

  private String id;

  private String name;

  private String city;

  private String state;

  private String stadium;

  private int foundation;

}
