/** */
package com.boot.test.common.base.service;

import com.boot.test.common.base.dao.AbsBaseDao;
import com.boot.test.common.base.pojo.BasePojo;
import com.boot.test.common.base.service.iservice.IBaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;


/**
 * @功能:server父类
 * @项目名:xd
 * @作者:wangjz
 * @日期:2017年8月3日上午11:28:23
 * @说明：<pre></pre>
 */
public abstract class AbsBaseService<P extends BasePojo, D extends AbsBaseDao<P>> implements IBaseService<P> {

	/** 日志 */
	protected Logger logger = LogManager.getLogger(this.getClass());
	/** dao工具 */
	protected D dao;

	/**
	 * @设置 dao工具
	 */
	protected abstract void setDao(D dao);

	/**
	 * 根据主键或唯一键查找数据
	 * 
	 * @param p
	 * @return
	 */
	@Override
	public P selectUnique(P p) {
		return dao.selectUnique(p);
	}

	/**
	 * 根据条件查询记录
	 * 
	 * @param p
	 * @return
	 */
	@Override
	public List<P> selectList(P p) {
		return dao.selectList(p);
	}

	/**
	 * 插入一条数据
	 * 
	 * @param p
	 * @return
	 */
	@Override
	public int insert(P p) {
		int count = dao.insert(p);
		return count;
	}

	/**
	 * 修改一条数据
	 * 
	 * @param p
	 * @return
	 */
	@Override
	public int update(P p) {
		return dao.update(p);
	}

	/**
	 * 批量插入数据
	 * 
	 * @param list
	 * @return
	 */
	@Override
	public int insertList(List<P> list) {
		return dao.insertList(list);
	}

	/**
	 * 批量修改数据
	 * 
	 * @param list
	 * @return
	 */
	@Override
	public int updateList(List<P> list) {
		return dao.updateList(list);
	}

}
