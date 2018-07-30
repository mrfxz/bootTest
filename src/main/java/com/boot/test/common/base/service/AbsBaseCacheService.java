/** */
package com.boot.test.common.base.service;
import com.boot.test.common.base.dao.AbsBaseDao;
import com.boot.test.common.base.pojo.BasePojo;


public abstract class AbsBaseCacheService<P extends BasePojo, D extends AbsBaseDao<P>> extends AbsBaseService<P, D> {
	/**
	 * 初始化缓存数据，主要通过@PostConstruct注解初始化bean时首次自动加载
	 * 
	 */
	protected abstract void init();

}
