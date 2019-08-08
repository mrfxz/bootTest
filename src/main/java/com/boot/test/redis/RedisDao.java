package com.boot.test.redis;

import com.boot.test.util.JsonTool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;


import java.util.List;


public class RedisDao {
	/** 日志 */
	protected Logger logger = LogManager.getLogger(this.getClass());
	/** redis连接池 */
	protected ShardedJedisPool shardedJedisPool;

	/**
	 * 查询对象是否存
	 * 
	 * @param key
	 * @return
	 */
	public boolean exists(String key) {
		ShardedJedis jedis = null;
		try {
			jedis = shardedJedisPool.getResource();
			return jedis.exists(key);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * 保存或更新对象
	 * 
	 * @param key
	 * @param obj
	 * @return
	 */
	public long saveOrUpdate(String key, Object obj) {
		return saveOrUpdate(key, obj, 0);
	}

	/**
	 * 设置对象过期时间
	 * 
	 * @param key
	 * @param expSecond
	 * @return 单位秒
	 */
	public long expire(String key, int expSecond) {
		return saveOrUpdate(key, null, expSecond);
	}

	/**
	 * 保存或更新对象,同时更新对象的失效时间,expSecond>0时才设置失效时间
	 * 
	 * @param key
	 * @param obj
	 * @param expSecond 单位秒
	 * @return
	 */
	public long saveOrUpdate(String key, Object obj, int expSecond) {
		ShardedJedis jedis = null;
		try {
			jedis = shardedJedisPool.getResource();
			long result = 0;
			if (obj != null) {
				jedis.set(key, JsonTool.getString(obj));
				result = 1;
			}
			if (expSecond > 0) {
				result = jedis.expire(key, expSecond);
			}
			return result;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * 删除对象:对象不存在，也返回true
	 * 
	 * @param key
	 * @return
	 */
	public long delete(String key) {
		ShardedJedis jedis = null;
		try {
			jedis = shardedJedisPool.getResource();
			return jedis.del(key);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * 根据key取得对象
	 * 
	 * @param key
	 * @param cls
	 * @return
	 */
	public <T> T get(String key, Class<T> cls) {
		return get(key, cls, 0);
	}

	/**
	 * 根据key取得对象,同时更新对象的失效时间,expSecond>0时才设置失效时间
	 * 
	 * @param key
	 * @param cls
	 * @param expSecond 单位秒
	 * @return
	 */
	public <T> T get(String key, Class<T> cls, int expSecond) {
		ShardedJedis jedis = null;
		try {
			jedis = shardedJedisPool.getResource();
			String str = jedis.get(key);
			if (str != null) {
				if (expSecond > 0) {
					jedis.expire(key, expSecond);
				}
				return JsonTool.getObj(str, cls);
			}
			return null;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * 操作HashMap：保存或更新值
	 * 
	 * @param storekey
	 * @param mapKey
	 * @param obj
	 * @return
	 */
	public long saveOrUpdateMapVal(String storekey, String mapKey, Object obj) {
		ShardedJedis jedis = null;
		try {
			jedis = shardedJedisPool.getResource();
			return jedis.hset(storekey, mapKey, JsonTool.getString(obj));
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * 操作HashMap：取得值
	 * 
	 * @param storekey
	 * @param mapKey
	 * @param cls
	 * @return
	 */
	public <T> T getMapVal(String storekey, String mapKey, Class<T> cls) {
		ShardedJedis jedis = null;
		try {
			jedis = shardedJedisPool.getResource();
			String str = jedis.hget(storekey, mapKey);
			if (str != null) {
				return JsonTool.getObj(str, cls);
			}
			return null;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * 队列处理:从左将对象压入队列中
	 * 
	 * @param key
	 * @param obj
	 * @return
	 */
	public long leftPush(String key, Object obj) {
		ShardedJedis jedis = null;
		try {
			jedis = shardedJedisPool.getResource();
			return jedis.lpush(key, JsonTool.getString(obj));
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * 队列处理:从右取出对象
	 * 
	 * @param key
	 * @param
	 * @return
	 */
	public <T> T rightPop(String key, Class<T> cls) {
		ShardedJedis jedis = null;
		try {
			jedis = shardedJedisPool.getResource();
			String str = jedis.rpop(key);
			if (str != null) {
				return JsonTool.getObj(str, cls);
			}
			return null;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * 队列处理:从右取出对象(阻塞)
	 *
	 * @param key
	 * @param cls
	 * @return
	 */
	public <T> T bRightPop(String key, Class<T> cls) {
		ShardedJedis jedis = null;
		try {
			jedis = shardedJedisPool.getResource();
			List<String> list = jedis.brpop(key);
			if (list != null && list.size() > 0) {
				return JsonTool.getObj(list.get(0), cls);
			}
			return null;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * 取得jedis对象
	 * 
	 * @return
	 */
	public ShardedJedis getShardedJedis() {
		return shardedJedisPool.getResource();
	}

	/** =============== 当DAO层方法需要传递map参数时 E只是用来定位namespace的 =============== **/
	/**
	 * @设置 redis连接池
	 */
	public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
		this.shardedJedisPool = shardedJedisPool;
	}
}
