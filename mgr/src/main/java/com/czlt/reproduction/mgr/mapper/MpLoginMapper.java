package com.czlt.reproduction.mgr.mapper;

import com.czlt.reproduction.mgr.entity.MpLogin;

public interface MpLoginMapper {
    int deleteByPrimaryKey(Integer loginid);

    int insert(MpLogin record);

    int insertSelective(MpLogin record);

    MpLogin selectByPrimaryKey(Integer loginid);

    int updateByPrimaryKeySelective(MpLogin record);

    int updateByPrimaryKey(MpLogin record);
}