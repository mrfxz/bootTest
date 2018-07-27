/** */
package com.boot.test.common.base.service;
import com.boot.test.common.base.dao.AbsBaseDao;
import com.boot.test.common.base.pojo.BasePojo;

/**
 * @功能:缓存数据BaseService
 * @项目名:dunningCommon
 * @作者:wangjz
 * @日期:2017年8月22日上午11:58:14
 */
public abstract class AbsBaseCacheService<P extends BasePojo, D extends AbsBaseDao<P>> extends AbsBaseService<P, D> {
	/**
	 * 初始化缓存数据，主要通过@PostConstruct注解初始化bean时首次自动加载
	 * 
	 */
	protected abstract void init();

}
