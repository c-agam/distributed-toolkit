package com.czlt.reproduction.mgr.mapper;

import com.czlt.reproduction.mgr.dto.MpRoleDto;
import com.czlt.reproduction.mgr.dto.MpUserDto;
import com.czlt.reproduction.mgr.entity.MpRole;
import com.czlt.reproduction.mgr.entity.MpUser;
import com.czlt.reproduction.mgr.entity.MpUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MpUserRoleMapper {
    int deleteByPrimaryKey(Integer urid);

    int insert(MpUserRole record);

    int insertSelective(MpUserRole record);

    MpUserRole selectByPrimaryKey(Integer urid);

    int updateByPrimaryKeySelective(MpUserRole record);

    int updateByPrimaryKey(MpUserRole record);

    List<MpRole> findMpRolesByCondition(@Param("mpRoleDto") MpRoleDto mpRoleDto);

    int countByCondition(@Param("mpRoleDto") MpRoleDto mpRoleDto);
}