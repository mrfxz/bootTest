package com.boot.test.poi.service;

import com.boot.test.poi.pojo.EventPojo;

import java.util.List;

public interface EventService {

    int deleteByPrimaryKey(Integer id);

    void insert(EventPojo event);

    int insertSelective(EventPojo event);

    EventPojo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EventPojo event);

    int updateByPrimaryKey(EventPojo event);

    List<EventPojo> selectList(EventPojo event);
}
