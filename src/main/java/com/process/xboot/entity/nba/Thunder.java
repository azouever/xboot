package com.process.xboot.entity.nba;

import com.process.xboot.entity.Nba;
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
public class Thunder implements Nba {

  private String oldStar;
  private String newStar;

}
