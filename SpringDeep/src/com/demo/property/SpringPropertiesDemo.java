package com.demo.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SpringProperties")
public class SpringPropertiesDemo {
	@Value("${tname}")
	private String tname;
	
	@Value("哈哈哈")
	private String tval;

	/*public static void main(String[] args) {
		ApplicationContext ac = new FileSystemXmlApplicationContext(
				"D://JAVASoft//GitProject//GitRep//SpringDeep//WebContent//WEB-INF//applicationContext.xml");
		SpringPropertiesDemo spd = (SpringPropertiesDemo) ac.getBean("SpringPropertiesDemo");
		System.out.println(spd.getTname());
	}*/
	
	@RequestMapping("/testPro")
	public void testPro(){
		System.out.println("spring取得的属性文件赋值："+this.getTname());
		System.out.println("@value设置值:"+this.getTval());
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTval() {
		return tval;
	}

	public void setTval(String tval) {
		this.tval = tval;
	}

	
}
