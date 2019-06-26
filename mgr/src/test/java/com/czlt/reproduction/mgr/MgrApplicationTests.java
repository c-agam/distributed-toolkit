package com.czlt.reproduction.mgr;

import com.alibaba.fastjson.JSON;
import com.czlt.reproduction.mgr.dto.MpUserDto;
import com.czlt.reproduction.mgr.entity.MpUser;
import com.czlt.reproduction.mgr.mapper.MpUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MgrApplicationTests {

    @Autowired
    private MpUserMapper mpUserMapper;

    @Test
    public void contextLoads() {
        MpUserDto mpUserDto = new MpUserDto();
//        mpUserDto.setUsername("1");

        List<MpUser> list = mpUserMapper.findMpUsersByCondition(mpUserDto);
        System.out.println(JSON.toJSON(list));
    }

}
