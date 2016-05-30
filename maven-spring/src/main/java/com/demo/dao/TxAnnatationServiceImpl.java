package com.demo.dao;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 使用注解配置事务
 * 
 * @author admin 2016年5月18日
 * @description
 * @ClassName TxAnnatationServiceImpl
 */
@Transactional
public class TxAnnatationServiceImpl {
	/**
	 * 定义在方法上的事务注解，
	 * 会在方法上的事务起效，和类上的事务注解不冲突
	 * 
	 * @author admin
	 * @date 2016年5月18日
	 * @description void
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void addData() {

	}
}
