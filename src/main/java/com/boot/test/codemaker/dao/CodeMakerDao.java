/** */
package com.boot.test.codemaker.dao;

import com.boot.test.codemaker.po.ColumnInfo;
import com.boot.test.common.base.dao.AbsBaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;


/**
 * @功能:
 * @项目名:xdTransactionServer
 * @作者:wangjz
 * @日期:2017年8月3日上午11:23:08
 * @说明：<pre></pre>
 */
@Mapper
public class CodeMakerDao extends AbsBaseDao<ColumnInfo> {
	/**
	 * @设置 单条sql操作模板
	 */
	@Override
	protected void setTemplate(SqlSessionTemplate template) {
		this.template = template;
	}

	/**
	 * @设置 单条sql操作模板
	 */
	public void setTemplate2(SqlSessionTemplate template) {
		super.template = template;
	}

	/**
	 * @设置 批量sql操作模板
	 */
	@Override
	protected void setBatchTemplate(SqlSessionTemplate batchTemplate) {
		this.batchTemplate = batchTemplate;
	}

	@Override
	public List<ColumnInfo> selectList(ColumnInfo columnInfo) {
		return super.selectList(columnInfo);
	}
}
