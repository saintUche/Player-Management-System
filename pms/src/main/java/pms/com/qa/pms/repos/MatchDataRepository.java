package pms.com.qa.pms.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pms.com.qa.pms.models.MatchData;



@Repository
public interface MatchDataRepository extends JpaRepository<MatchData, Long> {
    

    @Query(value = "SELECT * FROM MatchData WHERE Player_ID = ?1 Limit 1", nativeQuery = true)
    MatchData findMatchDataByPlayerID(String playerID);
}

