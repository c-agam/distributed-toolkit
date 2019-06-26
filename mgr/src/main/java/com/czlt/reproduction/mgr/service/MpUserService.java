package com.czlt.reproduction.mgr.service;

import com.czlt.reproduction.mgr.dto.MpUserDto;
import com.czlt.reproduction.mgr.entity.MpUser;
import com.czlt.reproduction.mgr.utils.PageHelper;

public interface MpUserService {
    /**
     * 按条件分页查询
     * @param mpUserDto
     * @return
     */
    PageHelper<MpUser> findMpUserPageByCondition(MpUserDto mpUserDto);

    /**
     * 新增用户
     * @param mpUser
     */
    void insert(MpUser mpUser);

    /**
     * 修改用户
     * @param mpUser
     */
    void updateByPrimaryKey(MpUser mpUser);
}
