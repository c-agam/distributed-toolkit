package com.czlt.reproduction.mgr.service;

import com.czlt.reproduction.mgr.dto.MpRoleDto;
import com.czlt.reproduction.mgr.entity.MpRole;
import com.czlt.reproduction.mgr.utils.PageHelper;

public interface MpRoleService {
    /**
     * 按条件分页查询
     * @param mpRoleDto
     * @return
     */
    PageHelper<MpRole> findMpRolePageByCondition(MpRoleDto mpRoleDto);

    /**
     * 新增角色
     * @param mpRole
     */
    void insert(MpRole mpRole);

    /**
     * 修改角色
     * @param mpRole
     */
    void updateByPrimaryKey(MpRole mpRole);
}
