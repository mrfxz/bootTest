/** */
package com.boot.test.common.base.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;


public class TimestampConvert implements Converter<String, Timestamp> {

	/**
	 * @方法重写
	 */
	@Override
	public Timestamp convert(String source) {
		if (!StringUtils.isEmpty(source)) {
			try {
				String format = "yyyy-MM-dd HH:mm:ss.SSS".substring(0, source.length());
				return new Timestamp(new SimpleDateFormat(format).parse(source).getTime());
			} catch (ParseException e) {
				return new Timestamp(Long.valueOf(source));
			}
		}
		return null;
	}

}
