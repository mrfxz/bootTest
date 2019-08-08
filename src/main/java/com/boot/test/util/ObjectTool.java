/** */
package com.boot.test.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class ObjectTool {
	/** 日志 */
	protected static Logger logger = LogManager.getLogger(ObjectTool.class);

	/**
	 * 用反射方法，将map中的值设置给对象对应属性
	 * 
	 * @param obj
	 * @param valMap
	 * @return
	 * @throws Exception
	 */
	public static <T> T setValue(T obj, Map<String, Object> valMap) throws Exception {
		return setValue(obj, valMap, true);
	}

	/**
	 * 用反射方法，将map中的值设置给对象对应属性
	 * 
	 * @param obj
	 * @param valMap
	 * @return
	 * @throws Exception
	 */
	public static <T> T setValue(T obj, Map<String, Object> valMap, boolean skipEmpty) throws Exception {
		Field field = null;
		Class<?> clazz = obj.getClass();
		for (Entry<String, Object> entry : valMap.entrySet()) {
			if (ObjectUtils.isEmpty(obj) && skipEmpty) {
				continue;
			}
			field = ReflectionUtils.findField(clazz, entry.getKey());
			field.setAccessible(true);
			if (field.getType().equals(int.class)) {
				field.set(obj, Integer.valueOf(entry.getValue().toString()).intValue());
			} else if (field.getType().equals(Integer.class)) {
				field.set(obj, Integer.valueOf(entry.getValue().toString()));
			} else if (field.getType().equals(long.class)) {
				field.set(obj, Long.valueOf(entry.getValue().toString()).longValue());
			} else if (field.getType().equals(Long.class)) {
				field.set(obj, Long.valueOf(entry.getValue().toString()));
			} else if (field.getType().equals(float.class)) {
				field.set(obj, Float.valueOf(entry.getValue().toString()).floatValue());
			} else if (field.getType().equals(Float.class)) {
				field.set(obj, Float.valueOf(entry.getValue().toString()));
			} else if (field.getType().equals(double.class)) {
				field.set(obj, Double.valueOf(entry.getValue().toString()).doubleValue());
			} else if (field.getType().equals(Double.class)) {
				field.set(obj, Double.valueOf(entry.getValue().toString()));
			} else {
				field.set(obj, entry.getValue());
			}
		}
		return obj;
	}

	/**
	 * 判断string是否为空或空字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static <T> boolean isEmpty(T obj) {
		if (obj instanceof String) {
			return obj == null || obj.toString().trim().length() < 1;
		} else if (obj instanceof Collection) {
			return obj == null || ((Collection<?>) obj).size() == 0;
		} else {
			return obj == null;
		}
	}

	/**
	 * 判断string是否不为空或空字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static <T> boolean isNotEmpty(T obj) {
		return !isEmpty(obj);
	}

	/**
	 * 如果obj为空，返回trueVal,否则返回自己
	 * 
	 * @param obj
	 * @param trueVal
	 * @return
	 */
	public static <T> T ifObjEmpty(T obj, T trueVal) {
		return isEmpty(obj) ? trueVal : obj;
	}

	public static void main(String[] args) throws Exception {
		// JedisPoolConfig cfg = new JedisPoolConfig();
		// HashMap<String, Object> map = new HashMap<String, Object>();
		// map.put("minIdle", 1);
		// ObjectTool.setValue(cfg, map);
		// System.out.println(JsonTool.getString(cfg));

		String s = null;
		System.out.println(isEmpty(s));
		s = "";
		System.out.println(isEmpty(s));

		List<String> list = null;
		System.out.println(isEmpty(list));
		list = new ArrayList<String>();
		System.out.println(isEmpty(list));
		list.add(s);
		System.out.println(isEmpty(list));

	}
}
