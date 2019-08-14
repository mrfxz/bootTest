package com.boot.test.poi.dao;

import com.boot.test.poi.pojo.EventPojo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventDao {
    int deleteByPrimaryKey(Integer id);

    void insert(EventPojo event);

    int insertSelective(EventPojo event);

    EventPojo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EventPojo event);

    int updateByPrimaryKey(EventPojo event);

    List<EventPojo> selectList(EventPojo event);
}
