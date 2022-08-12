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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (ID ^ (ID >>> 32));
    result = prime * result + numOfGoals;
    result = prime * result + numOfTackles;
    result = prime * result + ((player == null) ? 0 : player.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    MatchDataDTO other = (MatchDataDTO) obj;
    if (ID != other.ID)
      return false;
    if (numOfGoals != other.numOfGoals)
      return false;
    if (numOfTackles != other.numOfTackles)
      return false;
    if (player == null) {
      if (other.player != null)
        return false;
    } else if (!player.equals(other.player))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "MatchDataDTO [ID=" + ID + ", numOfGoals=" + numOfGoals + ", numOfTackles=" + numOfTackles + ", player="
        + player + "]";
  } 

}
