package com.czlt.reproduction.mgr;

import com.czlt.reproduction.mgr.entity.MpUser;
import com.czlt.reproduction.mgr.service.MpUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MgrApplicationTests {

    @Autowired
    private MpUserService mpUserService;

    @Test
    public void contextLoads() {
        MpUser mpUser = new MpUser();
        mpUser.setAccount("fdafsda");
        mpUser.setUsername("dfasfhs");
        mpUser.setPassword("fdafs");
        mpUser.setPhone("rewrw");
        mpUser.setLocked(0);
        mpUserService.insert(mpUser);
    }

}
