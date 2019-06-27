package com.czlt.reproduction.mgr.service;

import com.czlt.reproduction.mgr.dto.MpRoleDto;
import com.czlt.reproduction.mgr.entity.MpRole;
import com.czlt.reproduction.mgr.mapper.MpRoleMapper;
import com.czlt.reproduction.mgr.utils.PageHelper;
import com.czlt.reproduction.mgr.utils.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("mpRole")
public class MpRoleService {

    @Autowired
    private MpRoleMapper mpRoleMapper;

    public PageHelper<MpRole> findMpRolePageByCondition(MpRoleDto mpRoleDto) {
        List<MpRole> mpRoles = mpRoleMapper.findMpRolesByCondition(mpRoleDto);
        int count = mpRoleMapper.countByCondition(mpRoleDto);
        PageHelper<MpRole> pageHelper = new PageHelper<>();
        pageHelper.setEntries(mpRoles);
        pageHelper.setPageSize(mpRoleDto.getSize());
        pageHelper.setPageCount(count);
        pageHelper.setPageNumber(mpRoleDto.getStart());
        return pageHelper;
    }

    @Route("insert")
    @Transactional
    public void insert(MpRole mpRole) {
        mpRoleMapper.insert(mpRole);
    }

    @Route("update")
    @Transactional
    public void updateByPrimaryKey(MpRole mpRole) {
        mpRoleMapper.updateByPrimaryKey(mpRole);
    }
}
