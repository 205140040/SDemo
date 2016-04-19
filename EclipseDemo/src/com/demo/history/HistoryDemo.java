package com.demo.history;

/**
 * 使用eclipse自带历史记录 1.genera-workspace-local history设置历史记录期限，大小 2.team -show
 * local histroy 3.replace local history从本地历史，替换
 * 
 * @author Administrator 2016年4月18日
 * @description
 * @ClassName HistoryDemo
 */
public class HistoryDemo {

	public static void main(String[] args) {
		System.out.println("替换前");
		HistoryDemo historyDemo = createHistoryDemo();
	}

	public static HistoryDemo createHistoryDemo() {
		System.out.println("hello");
		return new HistoryDemo();
	}

}
