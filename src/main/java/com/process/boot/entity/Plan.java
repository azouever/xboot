package com.process.boot.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xkx
 * @description
 */
@Data
@Builder
public class Plan {

  private String name;

  private Integer type;

}
