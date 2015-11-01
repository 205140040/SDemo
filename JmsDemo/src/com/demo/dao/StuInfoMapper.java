package com.demo.dao;

import java.util.List;
import java.util.Map;

import com.demo.vo.StuInfo;

public interface StuInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StuInfo record);

    int insertSelective(StuInfo record);

    StuInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StuInfo record);

    int updateByPrimaryKey(StuInfo record);

    Map<Object, Object> selectUserMap(Integer id);

	List<StuInfo> selectOne(StuInfo search);

	List<StuInfo> selectGenSql(StuInfo search);
	
	
}