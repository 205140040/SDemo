package com.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.demo.bean.User;

public interface UserMapper {
	@Select("select * from t_user where user_name=#{userName}")
	public User selectByUserName(@Param("user_name")String userName );
}
