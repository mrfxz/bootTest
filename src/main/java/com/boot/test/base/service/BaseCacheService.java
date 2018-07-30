/** */
package com.boot.test.base.service;

import com.boot.test.common.base.dao.AbsBaseDao;
import com.boot.test.common.base.pojo.BasePojo;
import com.boot.test.common.base.service.AbsBaseCacheService;
import org.springframework.beans.factory.annotation.Autowired;



public abstract class BaseCacheService<P extends BasePojo, D extends AbsBaseDao<P>> extends AbsBaseCacheService<P, D> {
	/**
	 * @设置 dao工具
	 */
	@Override
	@Autowired
	protected void setDao(D dao) {
		this.dao = dao;
	}
}
