package com.czlt.reproduction.mgr.mapper;

import com.czlt.reproduction.mgr.entity.MpUser;

public interface MpUserMapper {
    int deleteByPrimaryKey(Integer userno);

    int insert(MpUser record);

    int insertSelective(MpUser record);

    MpUser selectByPrimaryKey(Integer userno);

    int updateByPrimaryKeySelective(MpUser record);

    int updateByPrimaryKey(MpUser record);
}