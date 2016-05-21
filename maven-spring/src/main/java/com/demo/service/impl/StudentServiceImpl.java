package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.demo.bean.Student;
import com.demo.dao.StudentMapper;
import com.demo.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private StudentMapper studentMapper;

	/* (non-Javadoc)
	 * @see com.demo.service.impl.IStudentService#selectById(java.lang.Integer)
	 */
	@Override
	public Student selectById(Integer id) {
		return studentMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.demo.service.impl.IStudentService#addStudent(com.demo.bean.Student)
	 */
	@Override
	public int addStudent(Student student) {
		return studentMapper.insertSelective(student);
	}

	/* (non-Javadoc)
	 * @see com.demo.service.impl.IStudentService#updateStudent(com.demo.bean.Student)
	 */
	@Override
	public int updateStudent(Student student) {
		return studentMapper.updateByPrimaryKeySelective(student);
	}

	/* (non-Javadoc)
	 * @see com.demo.service.impl.IStudentService#addAndUpdate(com.demo.bean.Student)
	 */
	@Override
	public void addAndUpdate(Student student) {
		this.addStudent(student);
		student.setName("改动后");
		this.updateStudent(student);
		Student s = this.selectById(3);
		System.out.println(JSON.toJSONString(s));
	}
}
