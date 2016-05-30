package com.demo.aopdemo;

public class WaiterServiceImpl implements IWaiterService {
	/* (non-Javadoc)
	 * @see com.demo.aopdemo.IWaiterService#sayHello(java.lang.String)
	 */
	@Override
	public void sayHello(String customerName) {
		System.out.println(customerName + ",你好");
	}
	
	@Override
	@NeedTest
	public String annationTest(){
		System.out.println("1+1=2");
		return "hello";
	}
	
	@Override
	public void joinPointArround(String name,String sex){
		System.out.println("名称:"+name+"\t性别"+sex);
	}
}
