package br.com.uptech.teams.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "Team")
public class Team {

  @MongoId
  private String id;

  private String name;

  private String city;

  private String state;

  private String stadium;

  private int foundation;

}
