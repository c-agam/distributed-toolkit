package com.czlt.reproduction.mgr.mapper;

import com.czlt.reproduction.mgr.entity.MpRoleMenu;

public interface MpRoleMenuMapper {
    int deleteByPrimaryKey(Integer rmid);

    int insert(MpRoleMenu record);

    int insertSelective(MpRoleMenu record);

    MpRoleMenu selectByPrimaryKey(Integer rmid);

    int updateByPrimaryKeySelective(MpRoleMenu record);

    int updateByPrimaryKey(MpRoleMenu record);
}