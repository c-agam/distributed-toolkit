//package com.czlt.reproduction.mgr.service;
//
//import com.czlt.reproduction.mgr.dto.MpUserDto;
//import com.czlt.reproduction.mgr.utils.PageHelper;
//import com.czlt.reproduction.mgr.utils.Route;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service("mpUser")
//public class MpUserService {
//    @Autowired
//    private MpUserMapper mpUserMapper;
//
//    @Route("query")
//    public PageHelper<MpUser> findMpUserPageByCondition(MpUserDto mpUserDto) {
//        List<MpUser> mpUsers = mpUserMapper.findMpUsersByCondition(mpUserDto);
//        int count = mpUserMapper.countByCondition(mpUserDto);
//        PageHelper<MpUser> pageHelper = new PageHelper<>();
//        pageHelper.setEntries(mpUsers);
//        pageHelper.setPageSize(mpUserDto.getSize());
//        pageHelper.setPageCount(count);
//        pageHelper.setPageNumber(mpUserDto.getStart());
//        return pageHelper;
//    }
//
//    @Route("insert")
//    @Transactional
//    public void insert(MpUser mpUser) {
//        mpUserMapper.insert(mpUser);
//    }
//
//    @Route("update")
//    @Transactional
//    public void updateByPrimaryKey(MpUser mpUser) {
//        mpUserMapper.updateByPrimaryKey(mpUser);
//    }
//
//}
