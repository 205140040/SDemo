package com.demo.xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * 自定义xsream日期转换器
 * 
 * @author admin 2016年5月21日
 * @description
 * @ClassName DateConverter
 */
public class DateConverter implements Converter {

	@SuppressWarnings("unchecked")
	public boolean canConvert(Class type) {
		return Date.class.isAssignableFrom(type);
	}

	// java对象到xml转换逻辑
	@Override
	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext arg2) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		writer.setValue(dateFormat.format(value));
	}

	// xml到java转换逻辑
	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext arg1) {
		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			calendar.setTime(dateFormat.parse(reader.getValue()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar.getGregorianChange();
	}
}
