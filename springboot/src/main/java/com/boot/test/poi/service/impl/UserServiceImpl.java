package com.boot.test.poi.service.impl;

import com.boot.test.poi.dao.UserDao;
import com.boot.test.poi.pojo.UserPojo;
import com.boot.test.poi.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userDao.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(UserPojo record) {
        userDao.insert(record);
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

    @Override
    public List<UserPojo> selectList(UserPojo user) {
        return userDao.selectList(user);
    }
}
