/** */
package com.boot.test.common.base.service.iservice;

import com.boot.test.common.base.pojo.BasePojo;

import java.util.List;


/**
 * @功能:
 * @项目名:dunningCommon
 * @作者:wangjz
 * @日期:2017年8月3日上午11:28:23
 * @说明：<pre></pre>
 */
public interface IBaseService<P extends BasePojo> {

	/**
	 * 根据主键或唯一键查找数据
	 *
	 * @param p
	 * @return
	 */
	public P selectUnique(P p);

	/**
	 * 根据条件查询记录
	 *
	 * @param p
	 * @return
	 */
	public List<P> selectList(P p);

	/**
	 * 插入一条数据
	 *
	 * @param p
	 * @return
	 */
	public int insert(P p);

	/**
	 * 修改一条数据
	 *
	 * @param p
	 * @return
	 */
	public int update(P p);

	/**
	 * 批量插入数据
	 *
	 * @param list
	 * @return
	 */
	public int insertList(List<P> list);

	/**
	 * 批量修改数据
	 *
	 * @param list
	 * @return
	 */
	public int updateList(List<P> list);

}
