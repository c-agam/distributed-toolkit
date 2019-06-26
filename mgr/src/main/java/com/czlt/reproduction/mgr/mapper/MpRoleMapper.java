package com.czlt.reproduction.mgr.mapper;

import com.czlt.reproduction.mgr.dto.MpRoleDto;
import com.czlt.reproduction.mgr.entity.MpRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MpRoleMapper {
    int deleteByPrimaryKey(Integer roleno);

    int insert(MpRole record);

    int insertSelective(MpRole record);

    MpRole selectByPrimaryKey(Integer roleno);

    int updateByPrimaryKeySelective(MpRole record);

    int updateByPrimaryKey(MpRole record);

    List<MpRole> findMpRolesByCondition(@Param("mpRoleDto") MpRoleDto mpRoleDto);

    int countByCondition(@Param("mpRoleDto") MpRoleDto mpRoleDto);
}