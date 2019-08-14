/** */
package com.boot.test.base.dao;

import com.boot.test.common.base.dao.AbsBaseDao;
import com.boot.test.common.base.pojo.BasePojo;
import org.mybatis.spring.SqlSessionTemplate;


import javax.annotation.Resource;


public class BaseDao<P extends BasePojo> extends AbsBaseDao<P> {

    /**
     * @设置 单条sql操作模板
     */
    @Override
    @Resource
    protected void setTemplate(SqlSessionTemplate template) {
        this.template = template;
    }

    /**
     * @设置 批量sql操作模板
     */
    @Override
    @Resource
    protected void setBatchTemplate(SqlSessionTemplate batchTemplate) {
        this.batchTemplate = batchTemplate;
    }

}
