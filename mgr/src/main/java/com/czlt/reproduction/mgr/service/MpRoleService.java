package com.czlt.reproduction.mgr.service;

import com.czlt.reproduction.mgr.dto.MpRoleDto;
import com.czlt.reproduction.mgr.entity.MpRole;
import com.czlt.reproduction.mgr.utils.PageHelper;
import org.springframework.stereotype.Service;

@Service("mpRole")
public class MpRoleService {

    public PageHelper<MpRole> findMpRolePageByCondition(MpRoleDto mpRoleDto) {
        return null;
    }

    public void insert(MpRole mpRole) {

    }

    public void updateByPrimaryKey(MpRole mpRole) {

    }
}
