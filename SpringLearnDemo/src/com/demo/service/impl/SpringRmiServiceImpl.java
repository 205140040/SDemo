package com.demo.service.impl;

import com.demo.service.ISpringRmiService;

/**
 * spring RMI服务实现类
 * @author Administrator
 *
 */
public class SpringRmiServiceImpl implements ISpringRmiService {
	
	/* (non-Javadoc)
	 * @see com.demo.service.impl.ISP#sayHello()
	 */
	@Override
	public void sayHello(){
		System.out.println("hello");
	}
}
