package com.hanleng.mapper;

import java.util.List;

import com.hanleng.entity.CtcKey;

public interface CtcMapper {

    int deleteByPrimaryKey(CtcKey key);

    int insert(CtcKey record);

    int insertSelective(CtcKey record);
   
    void  insertBatch(List<CtcKey> ctclist);
}