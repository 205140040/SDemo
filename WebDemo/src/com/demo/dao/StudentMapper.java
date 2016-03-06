package com.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.demo.bean.StudentInfo;

public interface StudentMapper {
	@Select(value = "SELECT s.*, t.tname FROM student s LEFT JOIN teacher t ON s.tid = t.id where sname = #{sname}")
	public StudentInfo selectById(@Param("id") Integer id,@Param("sname")String sname);
}
