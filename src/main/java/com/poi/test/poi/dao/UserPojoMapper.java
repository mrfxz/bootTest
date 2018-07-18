package com.poi.test.poi.dao;

import org.springframework.stereotype.Repository;
import pojo.UserPojo;
@Repository
public interface UserPojoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPojo record);

    int insertSelective(UserPojo record);

    UserPojo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserPojo record);

    int updateByPrimaryKey(UserPojo record);
}