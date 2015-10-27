package com.demo.service;

import com.demo.vo.StuInfo;

public interface IStudentService {

	int deleteByPrimaryKey(Integer id);

	int insert(StuInfo record);

	int insertSelective(StuInfo record);

	StuInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(StuInfo record);

	int updateByPrimaryKey(StuInfo record);

}