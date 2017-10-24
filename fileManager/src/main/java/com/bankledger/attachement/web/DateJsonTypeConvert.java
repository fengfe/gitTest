package com.bankledger.attachement.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * springmvc返回的json串中，
 * 将Date类型转为long类型，
 * 通过此类继承JsonSerializer来自定义格式，
 * 之后在实体类对应的date类型的字段的
 * getter方法上添加注解
 * @JsonSerialize(using=DateJsonTypeConvert.class)
 * @author Admin
 */
public class DateJsonTypeConvert extends 
   JsonSerializer<Date> {
	//用于序列化字符串(例如转换为json格式)
	@Override
	public void serialize(Date arg0, 
			JsonGenerator arg1,
			SerializerProvider arg2)
			throws IOException, 
			JsonProcessingException {
		//自己定义日期格式
		SimpleDateFormat sdf=
		new SimpleDateFormat("yyyy/MM/dd");
		//将数据以json格式输出
		arg1.writeString(sdf.format(arg0));
	}
}
