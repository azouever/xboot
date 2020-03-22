package com.process.xboot.mapper;

import com.process.xboot.entity.Bill;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author xkx
 * @description
 */
public interface BillMapper extends Mapper<Bill> {

    List<Bill> findBills();


}
