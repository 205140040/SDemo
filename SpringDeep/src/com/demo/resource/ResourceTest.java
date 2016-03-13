package com.demo.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**资源类
 * @author 20514
 * 2016年3月13日
 * @description 
 */
public class ResourceTest {

	public static void main(String[] args) {
		//系统文件资源类
		Resource resource=new FileSystemResource("C://Users//20514//Deskto//ex.xlsx");
		System.out.println("fielResource:"+resource.getFilename());
		Resource cpResource=new ClassPathResource("./WebContent/WEB-INF/web.xml");
		System.out.println("classpath："+cpResource.getFilename());
//		Resource servletR=new ServletContextResource();
	}

}
