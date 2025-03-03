package br.com.uptech.teams.business;

import br.com.uptech.teams.domain.dto.TeamDTO;
import br.com.uptech.teams.service.TeamService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamBusiness {

  private final TeamService teamService;

  public void create(TeamDTO dto) {
    teamService.create(dto);
  }

  public TeamDTO update(TeamDTO dto) {
    return teamService.update(dto);
  }

  public void delete(String id) {
    teamService.delete(id);
  }

  public TeamDTO getTeamById(String id) {
    return teamService.getTeamById(id);
  }

  public TeamDTO getTeamByName(String id) {
    return teamService.getTeamByName(id);
  }

  public Page<TeamDTO> getAllPaginated(Pageable pageable) {
    return teamService.getAllPaginated(pageable);
  }

  public List<TeamDTO> getAll() {
    return teamService.getAll();
  }
}
