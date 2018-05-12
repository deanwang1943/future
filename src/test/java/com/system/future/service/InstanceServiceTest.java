package com.system.future.service;

import com.system.future.dao.InstanceDao;
import com.system.future.entity.InstanceDO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InstanceServiceTest {
    @Autowired
    private InstanceService instanceService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listAll() {
        List<InstanceDO> records = instanceService.listAll();
        System.out.println("Get Size:" + records.size());
    }

    @Test
    public void get() {
    }

    @Test
    public void save() {
        InstanceDO record = new InstanceDO();
        record.setCreateDate(new Date());
        record.setProjectId(1L);
        record.setRemark("");
        record.setServerIP("192.168.1.1");
        record.setServerUser("centos");
        record.setServerPrivateKey("dsdfsdfw3r23rf3r2");
        record.setUserName("admin");

        instanceService.save(record);


    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }
}