package com.czlt.reproduction.mgr.mapper;

import com.czlt.reproduction.mgr.entity.MpRole;
import com.czlt.reproduction.mgr.entity.MpRoleKey;

public interface MpRoleMapper {
    int deleteByPrimaryKey(MpRoleKey key);

    int insert(MpRole record);

    int insertSelective(MpRole record);

    MpRole selectByPrimaryKey(MpRoleKey key);

    int updateByPrimaryKeySelective(MpRole record);

    int updateByPrimaryKey(MpRole record);


}