/** */
package com.boot.test.base.service;

import com.boot.test.common.base.dao.AbsBaseDao;
import com.boot.test.common.base.pojo.BasePojo;
import com.boot.test.common.base.service.AbsBaseService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @功能:
 * @项目名:dunningServer
 * @作者:wangjz
 * @日期:2017年8月3日上午11:28:23
 * @说明：<pre></pre>
 */
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
