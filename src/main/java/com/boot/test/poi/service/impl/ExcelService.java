package com.boot.test.poi.service.impl;

import com.boot.test.poi.pojo.UserPojo;
import com.boot.test.poi.util.ExcelUtil;
import com.boot.test.poi.vo.ExcelCol;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


/**
 * 用户导出service
 */
@Service
public class ExcelService extends ExcelUtil<UserPojo> {
    /**
     * 初始化列信息
     */
    protected void init() {
        cols = new ArrayList<ExcelCol>();
        cols.add(new ExcelCol("id","编号"));
        cols.add(new ExcelCol("userName","用户名"));
        cols.add(new ExcelCol("password","密码"));
    }
}
