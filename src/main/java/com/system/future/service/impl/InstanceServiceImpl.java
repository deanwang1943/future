package com.system.future.service.impl;

import com.system.future.dao.InstanceDao;
import com.system.future.entity.InstanceDO;
import com.system.future.service.InstanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("instanceService")
@Slf4j
public class InstanceServiceImpl implements InstanceService {
    @Autowired
    private InstanceDao instanceDao;

    @Override
    public List<InstanceDO> listAll() {
        return instanceDao.findAll();
    }

    @Override
    public InstanceDO get(Long id) {
        if (null != id) {
            return instanceDao.findOne(id);
        }
        return null;
    }

    @Override
    @Transactional
    public void save(InstanceDO record) {
        instanceDao.save(record);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (null != id && instanceDao.findOne(id) != null) {
            instanceDao.delete(id);
        } else {
            log.info("Delete id:" + id + " was not exit.");
        }
    }

    @Override
    @Transactional
    public void update(InstanceDO record, Long id) {
        InstanceDO old = instanceDao.findOne(id);
        if (old != null) {
            record.setId(id);
            instanceDao.save(record);
        }
    }
}
