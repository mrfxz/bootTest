/** */
package com.boot.test.redis;

import com.boot.test.util.ObjectTool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Component
@ConfigurationProperties(prefix = "redis-cfg")
public class RedisCfg {
	/** 日志 */
	protected Logger logger = LogManager.getLogger(this.getClass());
	/** redis连接池配置参数 */
	private Map<String, Object> redisPoolCfg;
	/** redis配置参数 */
	private Map<String, Object> redisShardCfg;
	/** 数据源参数 */
	private List<String> hostsCfg;


	/**
	 * 初始化Bean
	 */
	@Bean(name = "myRedisDao")
	public RedisDao generateRedisDao() throws Exception {
		return this.generateRedisDao(0);
	}

	/**
	 * 产生RedisDao
	 * 
	 * @param dbIndex
	 * @return
	 * @throws Exception
	 */
	public RedisDao generateRedisDao(int dbIndex) throws Exception {
		logger.info("====================配置redis dbIndex=" + dbIndex + "=====================");
		JedisPoolConfig cfg = new JedisPoolConfig();
		ObjectTool.setValue(cfg, redisPoolCfg);

		List<JedisShardInfo> shardInfoList = new ArrayList<JedisShardInfo>();
		JedisShardInfo shardInfo = null;
		for (String host : hostsCfg) {
			shardInfo = new JedisShardInfo(host);
			redisShardCfg.put("db", dbIndex);
			ObjectTool.setValue(shardInfo, redisShardCfg);
			shardInfoList.add(shardInfo);
		}
		ShardedJedisPool pool = new ShardedJedisPool(cfg, shardInfoList);

		logger.info("ShardedJedisPool创建成功");

		RedisDao dao = new RedisDao();
		dao.setShardedJedisPool(pool);
		logger.info("RedisDao创建成功");

		return dao;
	}

	/* ========================= get and set ========================== */
	/**
	 * @取得 redis连接池配置参数
	 */
	public Map<String, Object> getRedisPoolCfg() {
		return redisPoolCfg;
	}

	/**
	 * @设置 redis连接池配置参数
	 */
	public void setRedisPoolCfg(Map<String, Object> redisPoolCfg) {
		this.redisPoolCfg = redisPoolCfg;
	}

	/**
	 * @取得 redis配置参数
	 */
	public Map<String, Object> getRedisShardCfg() {
		return redisShardCfg;
	}

	/**
	 * @设置 redis配置参数
	 */
	public void setRedisShardCfg(Map<String, Object> redisShardCfg) {
		this.redisShardCfg = redisShardCfg;
	}

	/**
	 * @取得 数据源参数
	 */
	public List<String> getHostsCfg() {
		return hostsCfg;
	}

	/**
	 * @设置 数据源参数
	 */
	public void setHostsCfg(List<String> hostsCfg) {
		this.hostsCfg = hostsCfg;
	}

}
