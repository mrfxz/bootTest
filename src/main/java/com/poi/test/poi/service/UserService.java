package com.poi.test.poi.service;



public interface UserService {

    int deleteByPrimaryKey(Integer id);

    int insert(pojo.UserPojo record);

    int insertSelective(pojo.UserPojo record);

    pojo.UserPojo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(pojo.UserPojo record);

    int updateByPrimaryKey(pojo.UserPojo record);
}
