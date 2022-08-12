package pms.com.qa.pms.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pms.com.qa.pms.models.Fans;
import pms.com.qa.pms.models.Player;



@Repository
public interface FansRepository extends JpaRepository<Fans, Long> {
    

    @Query(value = "SELECT * FROM fans WHERE Player = ?1 Limit 1", nativeQuery = true)
    Fans findFansByPlayer(Player player);
}

