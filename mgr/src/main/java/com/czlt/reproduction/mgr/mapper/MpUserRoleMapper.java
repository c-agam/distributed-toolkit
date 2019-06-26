package com.czlt.reproduction.mgr.mapper;

import com.czlt.reproduction.mgr.entity.MpUserRole;

public interface MpUserRoleMapper {
    int deleteByPrimaryKey(Integer urid);

    int insert(MpUserRole record);

    int insertSelective(MpUserRole record);

    MpUserRole selectByPrimaryKey(Integer urid);

    int updateByPrimaryKeySelective(MpUserRole record);

    int updateByPrimaryKey(MpUserRole record);
}