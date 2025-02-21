package br.com.uptech.teams.controller;


import br.com.uptech.teams.domain.dto.TeamDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {

  //Create
  @PostMapping
  public void create(@RequestBody TeamDTO dto) {
    log.info("Create");
  }

  //Update
  @PutMapping
  public void update(@RequestBody TeamDTO dto) {
    log.info("Update");
  }

  //Delete
  @DeleteMapping
  public void delete() {
    log.info("Delete");
  }

  //Get
  @GetMapping
  public void get() {
    log.info("Get");
  }

  //List
  @GetMapping("/list")
  public void list() {
    log.info("List");
  }


}
