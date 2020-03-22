package com.process.xboot.entity.nba;

import com.process.xboot.entity.Nba;
import java.io.Serializable;
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
public class Rockets implements Nba, Serializable {

  private static final long serialVersionUID = 3645805693816923966L;

  private String oldStar;
  private String newStar;

}
