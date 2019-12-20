package com.process.boot.optional;

import com.process.boot.entity.Plan;
import java.util.Optional;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xkx
 * @description
 */
public class OptionalTest {

  private static final Integer TYPE_LEGAL_HOLIDAYS = 1;

  private final Logger log = LoggerFactory.getLogger(getClass());

  @Test
  public void of() {
    Plan midAutumnPlan = Plan.builder().name("中秋节").type(TYPE_LEGAL_HOLIDAYS).build();
    Optional<Object> optional = Optional.of(midAutumnPlan);
    System.out.println(optional.isPresent());
    Plan plan = (Plan) optional.get();
    log.info(plan.getName());
  }

  @Test
  public void ofNullable() {
    Plan midAutumnPlan = Plan.builder().name("中秋节").type(TYPE_LEGAL_HOLIDAYS).build();
//    Optional<Plan> autumnPlan = Optional.of(midAutumnPlan);
    Optional<Plan> autumnPlan = Optional.ofNullable(null);
    autumnPlan.ifPresent(plan -> {
      log.info(plan.getName());
      log.info(plan.getType().toString());
    });
  }

  @Test
  public void orElse() {
    Plan midAutumnPlan = Plan.builder().name("中秋节").type(TYPE_LEGAL_HOLIDAYS).build();
    Optional<Plan> autumnPlan = Optional.ofNullable(null);
    Plan plan = autumnPlan.orElse(midAutumnPlan);
    log.info(plan.getName());
    log.info(plan.getType().toString());
  }

  @Test
  public void orElseGet() {
    Plan midAutumnPlan = Plan.builder().name("中秋节").type(TYPE_LEGAL_HOLIDAYS).build();
    Optional<Plan> autumnPlan = Optional.ofNullable(null);
    Plan plan = autumnPlan
        .orElseGet(() -> Plan.builder().name("国庆节").type(TYPE_LEGAL_HOLIDAYS).build());
    log.info(plan.getName());
    log.info(plan.getType().toString());
  }

  @Test
  public void orElseThrow() {

    Optional<Plan> autumnPlan = Optional.ofNullable(null);

    try {
      Plan plan = autumnPlan.orElseThrow(() -> new NullPointerException());
    } catch (NullPointerException e) {
      e.printStackTrace();
    }

  }
}
