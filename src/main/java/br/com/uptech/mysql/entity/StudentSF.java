package br.com.uptech.mysql.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "studentsf")
@Getter
@Setter
public class StudentSF {

  @Id
  @NotNull
  private String id;

  private String cpf;
}
