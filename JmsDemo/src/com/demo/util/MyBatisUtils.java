package com.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.jdbc.SqlBuilder;

import com.demo.vo.StuInfo;

/**
 * 使用sqlBuidler动态构建sql
 * 
 * @date 2015年11月1日
 * @author hyc
 * @description
 */
public class MyBatisUtils extends SqlBuilder {
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String selectGenSql(String name) {
		BEGIN();
		SELECT("s.id,s.name,s.sex,s.bir_day");
		FROM("stu_info s");
		if (null != name && !name.isEmpty()) {
			WHERE("name like '%" + name + "%'");
		}
		return SQL();
	}

	public static String deleteSql() {
		BEGIN();
		DELETE_FROM("UserDto");
		WHERE("username = #{username}");
		return SQL();
	}

	public static String insertSql(StuInfo info) {
		BEGIN();
		INSERT_INTO("stu_info");
		VALUES("name","'"+info.getName()+"'");
		VALUES("sex","'"+info.getSex()+"'");
		VALUES("bir_day","'"+sdf.format(info.getBirDay())+"'");
		return SQL();
	}

	public static String updateSql(StuInfo info) {
		BEGIN();
		UPDATE("stu_info");
		SET("name=" + info.getName());
		WHERE("id = " + info.getId());
		return SQL();
	}

	public static void main(String[] args) {
		String name = "张";
		MyBatisUtils myBatisUtils = new MyBatisUtils();
		StuInfo info = new StuInfo();
		info.setId(4);
		info.setName("酱紫");
		info.setSex("女");
		info.setBirDay(new Date());
		System.out.println("查询 = " + myBatisUtils.selectGenSql(name));
		System.out.println("----------------------------------------------------");
		// System.out.println("删除 = " + myBatisUtils.deleteSql());
		System.out.println("插入 = " + myBatisUtils.insertSql(info));
		System.out.println("----------------------------------------------------");
		System.out.println("更新 = " + myBatisUtils.updateSql(info));
	}
}
