package com.czlt.reproduction.mgr.mapper;

import com.czlt.reproduction.mgr.dto.MpUserDto;
import com.czlt.reproduction.mgr.entity.MpUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MpUserMapper {
    int deleteByPrimaryKey(Integer userno);

    int insert(MpUser record);

    int insertSelective(MpUser record);

    MpUser selectByPrimaryKey(Integer userno);

    int updateByPrimaryKeySelective(MpUser record);

    int updateByPrimaryKey(MpUser record);

    List<MpUser> findMpUsersByCondition(@Param("mpUserDto") MpUserDto mpUserDto);

    int countByCondition(@Param("mpUserDto") MpUserDto mpUserDto);
}