package com.qa.DTOs;


import com.qa.models.Player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
