package com.boot.test.poi.service;

import com.boot.test.poi.pojo.UserPojo;

import java.util.List;

public interface UserService {

    int deleteByPrimaryKey(Integer id);

    void insert(UserPojo record);

    int insertSelective(UserPojo record);

    UserPojo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPojo record);

    int updateByPrimaryKey(UserPojo record);

    List<UserPojo> selectList(UserPojo user);
}
