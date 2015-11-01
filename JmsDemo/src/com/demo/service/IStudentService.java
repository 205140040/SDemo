package com.demo.service;

import java.util.List;
import java.util.Map;

import com.demo.vo.StuInfo;

public interface IStudentService {

	int deleteByPrimaryKey(Integer id);

	int insert(StuInfo record);

	int insertSelective(StuInfo record);

	StuInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(StuInfo record);

	int updateByPrimaryKey(StuInfo record);
	
	Map<Object, Object> selectUserMap(Integer id);
	
	List<StuInfo> selectOne(StuInfo search);

}