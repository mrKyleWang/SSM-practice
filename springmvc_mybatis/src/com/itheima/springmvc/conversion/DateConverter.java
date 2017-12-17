package com.itheima.springmvc.conversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 转换日期类型的数据
 * S : 页面传过来的类型(String)
 * T : 转换后的类型(Date)
 */
public class DateConverter implements Converter<String , Date>{

	@Override
	public Date convert(String source) {
		
		try {
			if(null != source) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return df.parse(source);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
