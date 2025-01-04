package project.footballmanager.repository.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.footballmanager.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
