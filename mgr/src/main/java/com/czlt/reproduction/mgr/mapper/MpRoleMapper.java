package com.czlt.reproduction.mgr.mapper;

import com.czlt.reproduction.mgr.entity.MpRole;

public interface MpRoleMapper {
    int deleteByPrimaryKey(Integer roleno);

    int insert(MpRole record);

    int insertSelective(MpRole record);

    MpRole selectByPrimaryKey(Integer roleno);

    int updateByPrimaryKeySelective(MpRole record);

    int updateByPrimaryKey(MpRole record);
}