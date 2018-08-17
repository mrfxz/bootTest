/** */
package com.boot.test.common.base.service;

import com.boot.test.common.base.dao.AbsBaseDao;
import com.boot.test.common.base.pojo.BasePojo;
import com.boot.test.common.base.service.iservice.IBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;



public abstract class AbsBaseService<P extends BasePojo, D extends AbsBaseDao<P>> implements IBaseService<P> {

	/** 日志 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());
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
