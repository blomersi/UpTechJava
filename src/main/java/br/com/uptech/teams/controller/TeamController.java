package br.com.uptech.teams.controller;


import br.com.uptech.teams.business.TeamBusiness;
import br.com.uptech.teams.domain.dto.TeamDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {


  private final TeamBusiness teamBusiness;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(summary = "Creating a new team", description = "Method responsible for recording a new team in the database.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Successfully created team"),
      @ApiResponse(responseCode = "400", description = "Bad Request"),
      @ApiResponse(responseCode = "500", description = "Internal Server Error")
  })
  public void create(@RequestBody TeamDTO dto) {
    log.info("Create");
    teamBusiness.create(dto);
  }

  //Update
  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  @Operation(description = "Method responsible for update one team")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully processed"),
      @ApiResponse(responseCode = "400", description = "Bad request"),
      @ApiResponse(responseCode = "500", description = "Processing error")
  })
  public TeamDTO update(@RequestBody TeamDTO dto) {
    log.info("Update");
    return teamBusiness.update(dto);
  }

  //Delete
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @Operation(description = "Method responsible for remove one team")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "Successfully processed"),
      @ApiResponse(responseCode = "400", description = "Bad request"),
      @ApiResponse(responseCode = "500", description = "Processing error")
  })
  public void delete(@PathVariable String id) {
    log.info("Delete");
    teamBusiness.delete(id);
  }

  //Get
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @Operation(description = "Method responsible for returning the team by Id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully processed"),
      @ApiResponse(responseCode = "400", description = "Bad request"),
      @ApiResponse(responseCode = "500", description = "Processing error")
  })
  public TeamDTO getTeamById(@PathVariable String id) {
    log.info("Get by Id");
    return teamBusiness.getTeamById(id);
  }

  //Get
  @GetMapping("/name/{name}")
  @ResponseStatus(HttpStatus.OK)
  @Operation(description = "Method responsible for returning the team by nresponsible for returning the team by name")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully processed"),
      @ApiResponse(responseCode = "400", description = "Bad request"),
      @ApiResponse(responseCode = "500", description = "Processing error")
  })
  public TeamDTO getTeamByName(@PathVariable String name) {
    log.info("Get by Name");
    return teamBusiness.getTeamByName(name);
  }

  @PostMapping(value = "/search")
  @ResponseStatus(HttpStatus.OK)
  @Operation(description = "Responsible method return teams page")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully processed"),
      @ApiResponse(responseCode = "400", description = "Bad request"),
      @ApiResponse(responseCode = "500", description = "Processing error")
  })
  public Page<TeamDTO> listPageable(@PageableDefault Pageable pageable) {
    log.info("Search All");
    return teamBusiness.getAllPaginated(pageable);
  }

  @GetMapping("/list")
  @ResponseStatus(HttpStatus.OK)
  @Operation(description = "Method responsible for returning all teams")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Successfully processed"),
      @ApiResponse(responseCode = "400", description = "Bad request"),
      @ApiResponse(responseCode = "500", description = "Processing error")
  })
  public List<TeamDTO> getAll() {
    log.info("List All");
    return teamBusiness.getAll();
  }

}
