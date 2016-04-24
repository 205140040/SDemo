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
		 */
	}

}
