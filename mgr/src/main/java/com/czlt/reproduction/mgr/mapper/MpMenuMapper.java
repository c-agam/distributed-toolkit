package com.czlt.reproduction.mgr.mapper;

import com.czlt.reproduction.mgr.dto.MpMenuDto;
import com.czlt.reproduction.mgr.entity.MpMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MpMenuMapper {
    int deleteByPrimaryKey(Integer menuid);

    int insert(MpMenu record);

    int insertSelective(MpMenu record);

    MpMenu selectByPrimaryKey(Integer menuid);

    int updateByPrimaryKeySelective(MpMenu record);

    int updateByPrimaryKey(MpMenu record);

    List<MpMenu> findMpMenusByCondition(@Param("mpMenuDto") MpMenuDto mpMenuDto);

    int countByCondition(@Param("mpMenuDto") MpMenuDto mpMenuDto);
}