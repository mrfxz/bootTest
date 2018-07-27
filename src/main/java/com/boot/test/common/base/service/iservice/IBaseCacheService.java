/** */
package com.boot.test.common.base.service.iservice;
import com.boot.test.common.base.pojo.BasePojo;

/**
 * @功能:缓存数据BaseService接口
 * @项目名:dunningCommon
 * @作者:wangjz
 * @日期:2017年8月22日上午11:58:14
 */
public interface IBaseCacheService<P extends BasePojo, R> extends IBaseService<P> {

	/**
	 * 清理缓存
	 */
	public void cleanCache(P po);

	/**
	 * 取得缓存数据
	 * 
	 * @param po
	 * @return
	 */
	public R getCacheDataByKey(P po);

}
