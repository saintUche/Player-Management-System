package pms.com.qa.pms.DTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pms.com.qa.pms.models.Player;

@NoArgsConstructor
@AllArgsConstructor
public class MatchDataDTO {

  @Getter
  @Setter
  private long ID;

  @Getter
  @Setter
  private Player player;

  @Getter
  @Setter
  private int numOfGoals;

  @Getter
  @Setter
  private int numOfTackles; 

}
