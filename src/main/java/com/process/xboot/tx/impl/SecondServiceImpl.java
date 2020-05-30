package com.process.xboot.tx.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import com.process.xboot.entity.Goods;
import com.process.xboot.exception.XbootRuntimeException;
import com.process.xboot.mapper.GoodsMapper;
import com.process.xboot.tx.SecondService;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Kai
 * @description do something
 */
@Service
public class SecondServiceImpl implements SecondService {

  private static final Logger log = LoggerFactory.getLogger(SecondServiceImpl.class);

  @Autowired
  private GoodsMapper goodsMapper;

  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void handleNotImportantData() {

    Goods goods = Goods.builder().goodsNo(UUID.fastUUID().toString()).price(BigDecimal.TEN)
        .quantity(10).createDate(
            DateUtil.date()).build();
//      try {
    goodsMapper.insertSelective(goods);
    throw new XbootRuntimeException("goods save exception");
//    } catch (XbootRuntimeException e) {
//      e.printStackTrace();
//    }
  }
}
