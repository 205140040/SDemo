package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.StuInfoMapper;
import com.demo.vo.StuInfo;
@Service("StudentServiceImpl")
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private StuInfoMapper mapper;
	@Override
	public int deleteByPrimaryKey(Integer id){
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public  int insert(StuInfo record){
    	return mapper.insert(record);
    }

	@Override
	public  int insertSelective(StuInfo record){
    	return mapper.insertSelective(record);
    }

	@Override
	public  StuInfo selectByPrimaryKey(Integer id){
    	return mapper.selectByPrimaryKey(id);
    }

	@Override
	public int updateByPrimaryKeySelective(StuInfo record){
    	return mapper.updateByPrimaryKeySelective(record);
    }

	@Override
	public int updateByPrimaryKey(StuInfo record){
    	return mapper.updateByPrimaryKey(record);
    }
}
