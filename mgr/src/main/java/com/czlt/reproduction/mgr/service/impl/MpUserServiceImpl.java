package com.czlt.reproduction.mgr.service.impl;

import com.czlt.reproduction.mgr.dto.MpUserDto;
import com.czlt.reproduction.mgr.entity.MpUser;
import com.czlt.reproduction.mgr.mapper.MpUserMapper;
import com.czlt.reproduction.mgr.service.MpUserService;
import com.czlt.reproduction.mgr.utils.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MpUserServiceImpl implements MpUserService {
    @Autowired
    private MpUserMapper mpUserMapper;

    @Override
    public PageHelper<MpUser> findMpUserPageByCondition(MpUserDto mpUserDto) {
        List<MpUser> mpUsers = mpUserMapper.findMpUsersByCondition(mpUserDto);
        int count = mpUserMapper.countByCondition(mpUserDto);
        PageHelper<MpUser> pageHelper = new PageHelper<>();
        pageHelper.setEntries(mpUsers);
        pageHelper.setPageSize(mpUserDto.getSize());
        pageHelper.setPageCount(count);
        pageHelper.setPageNumber(mpUserDto.getStart());
        return pageHelper;
    }

    @Override
    @Transactional
    public void insert(MpUser mpUser) {
        mpUserMapper.insert(mpUser);
    }

    @Override
    @Transactional
    public void updateByPrimaryKey(MpUser mpUser) {
        mpUserMapper.updateByPrimaryKey(mpUser);
    }
}
