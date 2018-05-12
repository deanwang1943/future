package com.system.future.dao;

import com.system.future.entity.InstanceDO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstanceDaoTest {
    @Autowired
    private InstanceDao instanceDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testFindByServerIP() {
        final String testIP = "192.168.1.1";
        List<InstanceDO> records = instanceDao.findByServerIP(testIP);
    }
}