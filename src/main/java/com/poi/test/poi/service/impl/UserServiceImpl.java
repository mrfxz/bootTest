package com.poi.test.poi.service.impl;

import com.poi.test.poi.dao.UserPojoMapper;
import com.poi.test.poi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.UserPojo;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPojoMapper userDao;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserPojo record) {
        return userDao.insert(record);
    }

    @Override
    public int insertSelective(UserPojo record) {
        return userDao.insertSelective(record);
    }

    @Override
    public UserPojo selectByPrimaryKey(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserPojo record) {
        return userDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserPojo record) {
        return userDao.updateByPrimaryKey(record);
    }
}
