package com.system.future.service.impl;

import com.system.future.dao.UserDao;
import com.system.future.entity.UserDO;
import com.system.future.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserDO> listAll() {
        return userDao.findAll();
    }

    @Override
    public UserDO get(Long id) {
        return userDao.findOne(id);
    }

    @Override
    @Transactional
    public void save(UserDO record) {
        userDao.save(record);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void update(UserDO record, Long id) {
        userDao.save(record);
    }
}
