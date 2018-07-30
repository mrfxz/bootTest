/** */
package com.boot.test.base.service;

import com.boot.test.common.base.dao.AbsBaseDao;
import com.boot.test.common.base.pojo.BasePojo;
import com.boot.test.common.base.service.AbsBaseService;
import org.springframework.beans.factory.annotation.Autowired;



public class BaseService<P extends BasePojo, D extends AbsBaseDao<P>> extends AbsBaseService<P, D> {
	/**
	 * @设置 dao工具
	 */
	@Override
	@Autowired
	protected void setDao(D dao) {
		this.dao = dao;
	}

}
