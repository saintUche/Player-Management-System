package pms.com.qa.pms.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pms.com.qa.pms.models.Player;



@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    

    @Query(value = "SELECT * FROM PLAYERS WHERE first_name = ?1 Limit 1", nativeQuery = true)
    Player findPlayerByFirstName(String firstName);

    @Query(value = "SELECT * FROM PLAYERS WHERE last_name = ?1 Limit 1", nativeQuery = true)
    Player findPlayerByLastName(String lastName);

}
