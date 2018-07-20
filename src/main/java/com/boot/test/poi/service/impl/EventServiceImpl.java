package com.boot.test.poi.service.impl;

import com.boot.test.poi.dao.EventDao;
import com.boot.test.poi.pojo.EventPojo;
import com.boot.test.poi.service.EventService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Resource
    private EventDao eventDao;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return eventDao.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(EventPojo event) {
         eventDao.insert(event);
    }

    @Override
    public int insertSelective(EventPojo event) {
        return eventDao.insertSelective(event);
    }

    @Override
    public EventPojo selectByPrimaryKey(Integer id) {
        return eventDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(EventPojo event) {
        return eventDao.updateByPrimaryKeySelective(event);
    }

    @Override
    public int updateByPrimaryKey(EventPojo event) {
        return eventDao.updateByPrimaryKey(event);
    }

    @Override
    public List<EventPojo> selectList(EventPojo event) {
        return eventDao.selectList(event);
    }
}
