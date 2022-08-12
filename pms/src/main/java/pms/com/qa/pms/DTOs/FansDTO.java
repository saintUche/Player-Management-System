package pms.com.qa.pms.DTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pms.com.qa.pms.models.Player;


@NoArgsConstructor
@AllArgsConstructor
public class FansDTO {

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (ID ^ (ID >>> 32));
    result = prime * result + haters;
    result = prime * result + ((player == null) ? 0 : player.hashCode());
    result = prime * result + supporters;
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
    FansDTO other = (FansDTO) obj;
    if (ID != other.ID)
      return false;
    if (haters != other.haters)
      return false;
    if (player == null) {
      if (other.player != null)
        return false;
    } else if (!player.equals(other.player))
      return false;
    if (supporters != other.supporters)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "FansDTO [ID=" + ID + ", haters=" + haters + ", player=" + player + ", supporters=" + supporters + "]";
  }

  @Getter
  @Setter
  private long ID;

  @Getter
  @Setter
  private Player player;

  @Getter
  @Setter
  private int supporters;

  @Getter
  @Setter
  private int haters;


}
