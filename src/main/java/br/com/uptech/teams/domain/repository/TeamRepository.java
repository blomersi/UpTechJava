package br.com.uptech.teams.domain.repository;

import br.com.uptech.teams.domain.entity.Team;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface TeamRepository extends MongoRepository<Team, String> {

  @Query ("{name : ?0}")
  Optional<Team> findByName(String name);

}
