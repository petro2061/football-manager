package project.footballmanager.repository.player;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.footballmanager.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p LEFT JOIN FETCH p.team")
    List<Player> findPlayerWithTeam();

    @Query("SELECT p FROM Player p LEFT JOIN FETCH p.team WHERE p.id = :id")
    Optional<Player> findPlayerWithTeamById(Long id);

    @Query("SELECT p FROM Player p LEFT JOIN FETCH p.team t WHERE t.id = :teamId")
    List<Player> findAllByTeamId(Long teamId);
}
