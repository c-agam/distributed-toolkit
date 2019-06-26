package com.czlt.reproduction.mgr.service.impl;

import com.czlt.reproduction.mgr.dto.MpRoleDto;
import com.czlt.reproduction.mgr.entity.MpRole;
import com.czlt.reproduction.mgr.service.MpRoleService;
import com.czlt.reproduction.mgr.utils.PageHelper;
import org.springframework.stereotype.Service;

@Service
public class MpRoleServiceImpl implements MpRoleService {
    @Override
    public PageHelper<MpRole> findMpRolePageByCondition(MpRoleDto mpRoleDto) {
        return null;
    }

    @Override
    public void insert(MpRole mpRole) {

    }

    @Override
    public void updateByPrimaryKey(MpRole mpRole) {

    }
}
