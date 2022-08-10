package pms.com.qa.pms.DTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pms.com.qa.pms.models.Player;


@NoArgsConstructor
@AllArgsConstructor
public class FansDTO {

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
