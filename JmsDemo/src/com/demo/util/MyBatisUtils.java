package com.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.jdbc.SqlBuilder;

import com.demo.vo.StuInfo;

/**
 * ʹ��sqlBuidler��̬����sql
 * 
 * @date 2015��11��1��
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
		String name = "��";
		MyBatisUtils myBatisUtils = new MyBatisUtils();
		StuInfo info = new StuInfo();
		info.setId(4);
		info.setName("����");
		info.setSex("Ů");
		info.setBirDay(new Date());
		System.out.println("��ѯ = " + myBatisUtils.selectGenSql(name));
		System.out.println("----------------------------------------------------");
		// System.out.println("ɾ�� = " + myBatisUtils.deleteSql());
		System.out.println("���� = " + myBatisUtils.insertSql(info));
		System.out.println("----------------------------------------------------");
		System.out.println("���� = " + myBatisUtils.updateSql(info));
	}
}
