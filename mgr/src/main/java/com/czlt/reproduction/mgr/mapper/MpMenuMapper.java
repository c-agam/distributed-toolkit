package com.czlt.reproduction.mgr.mapper;

import com.czlt.reproduction.mgr.entity.MpMenu;

public interface MpMenuMapper {
    int deleteByPrimaryKey(Integer menuid);

    int insert(MpMenu record);

    int insertSelective(MpMenu record);

    MpMenu selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(MpMenu record);

    int updateByPrimaryKey(MpMenu record);
}