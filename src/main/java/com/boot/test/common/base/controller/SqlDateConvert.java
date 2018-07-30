/** */
package com.boot.test.common.base.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;


public class SqlDateConvert implements Converter<String, Date> {

	/**
	 * @方法重写
	 */
	@Override
	public Date convert(String source) {
		if (!StringUtils.isEmpty(source)) {
			try {
				String format = "yyyy-MM-dd HH:mm:ss.SSS".substring(0, source.length());
				return new Date(new SimpleDateFormat(format).parse(source).getTime());
			} catch (ParseException e) {
				return new Date(Long.valueOf(source));
			}
		}
		return null;
	}
}
