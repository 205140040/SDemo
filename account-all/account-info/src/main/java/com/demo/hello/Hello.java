package com.demo.hello;
import com.alibaba.fastjson.JSON;

public class Hello {

	public static void main(String[] args) {
		System.out.println(JSON.parse("5555"));
		/**
		 * maven中a依赖b，b依赖c，a可以关联到c的依赖，间接依赖
		 * 2.通过dependency:list查看该项目的依赖：
		 * 3.通过dependency:tree查看该项目的依赖树：
		 * 4.通过dependency:analyze分析依赖的必须和非必须的
		 * 5.仓库分为本地仓库，和远程仓库，先看本地仓库有没有，没有再看远程仓库，
		 * 没有，再进行下载到本地仓库
		 * 6.在maven，settings.xml中对仓库进行认证，配置id和远程仓库一样的id，
		 * 输入用户名，密码认证
		 * 7.	<!-- 配置镜像，仓库X可以提供仓库Y的所有类容，那么X就是Y的镜像,加快访问 -->
		 *   <mirrors>
			    <mirror>
			      <id>maven.net.cn</id>
			      <mirrorOf>central</mirrorOf>
			      <name>center rep in china</name>
			      <url>http://maven.net.cn/content/groups/pulbic/</url>
			    </mirror>
  			</mirrors>
  			8.maven插件，通过maven官网上的plugins查找
		 */
	}

}
