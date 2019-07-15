package com.process.boot.entity.nba;

import com.process.boot.entity.BallTeam;
import com.process.boot.entity.Nba;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xkx
 * @description
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Rockets implements Nba {

  private String oldStar;
  private String newStar;

}
