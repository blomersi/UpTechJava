package br.com.uptech.postgres.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
public class User {

  @Id
  private Long id;

}
