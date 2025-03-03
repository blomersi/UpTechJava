package br.com.uptech.teams.service;

import br.com.uptech.exceptions.ObjectAlreadyExistsException;
import br.com.uptech.exceptions.ObjectNotFoundException;
import br.com.uptech.teams.domain.dto.TeamDTO;
import br.com.uptech.teams.domain.entity.Team;
import br.com.uptech.teams.domain.repository.TeamRepository;
import br.com.uptech.utils.GenericConvertObjectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import java.util.List;
import org.modelmapper.internal.util.Lists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class TeamService {

  private final TeamRepository teamRepository;

  public void create(TeamDTO dto) {
    log.info("Criando um novo time");
    if (teamRepository.findByName(dto.getName()).isPresent()) {
      log.error("O time {} já existe na base de dados", dto.getName());
      throw new ObjectAlreadyExistsException("Team [" + dto.getName() + "] already exists.");
    }

    teamRepository.save(GenericConvertObjectUtils.convertObject(dto, Team.class));
    log.info("O time {} foi armazenado com sucesso na base de dados", dto.getName());
  }

  public TeamDTO update(TeamDTO dto) {
    log.info("Atualizando dados de um time");
    return teamRepository.findById(dto.getId()).map(
        teamExists -> {
          Team newTeam = GenericConvertObjectUtils.convertObject(dto, Team.class);
          newTeam.setId(teamExists.getId());
          return GenericConvertObjectUtils.convertObject(
              teamRepository.save(newTeam), TeamDTO.class);
        }).orElseThrow(() -> {
      log.error("o time com o id {} não existe na base de dados", dto.getId());
      return new ObjectNotFoundException("team [" + dto.getId() + "] not exists.");
    });
  }

  public void delete(String id) {
    Team team = teamRepository.findById(id).orElseThrow(
        () -> {
          log.error("O time com o id {} não existe na base de dados", id);
          return new ObjectNotFoundException("team [" + id + "] not exists.");
        }
    );
    teamRepository.delete(team);
  }

  public TeamDTO getTeamById(String id) {
    Team team = teamRepository.findById(id).orElseThrow(
        () -> {
          log.error("O time com o id {} não existe na base de dados", id);
          return new ObjectNotFoundException("team [" + id + "] not exists.");
        }
    );
    return GenericConvertObjectUtils.convertObject(team, TeamDTO.class);
  }

  public TeamDTO getTeamByName(String name) {
    Team team = teamRepository.findByName(name).orElseThrow(
        () -> {
          log.error("O time com o nome {} não existe na base de dados", name);
          return new ObjectNotFoundException("team [" + name + "] not exists.");
        }
    );
    return GenericConvertObjectUtils.convertObject(team, TeamDTO.class);
  }

  public Page<TeamDTO> getAllPaginated(Pageable pageable) {
    return teamRepository.findAll(pageable).map(team ->
        GenericConvertObjectUtils.convertObject(team, TeamDTO.class)
    );
  }

  public List<TeamDTO> getAll() {
    return GenericConvertObjectUtils.
        convertObjectToList(Lists.from(teamRepository.findAll().iterator()), TeamDTO.class);
  }

}
