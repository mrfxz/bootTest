package com.boot.test.poi.dao;

import com.boot.test.poi.pojo.UserPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface  UserDao {
    int deleteByPrimaryKey(Integer id);

    void insert(UserPojo record);

    int insertSelective(UserPojo record);

    UserPojo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPojo record);

    int updateByPrimaryKey(UserPojo record);

    List<UserPojo> selectList(UserPojo user);
}
