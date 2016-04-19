package com.demo.tasks;
/**
 * 1.书签：行号处，添加书签，show view 显示书签
 * 2.任务标签
 * @author Administrator
 * 2016年4月18日
 * @description 
 * @ClassName BookMarkAndTasksDemo
 */
public class BookMarkAndTasksDemo {

	public static void main(String[] args) {
		// TODO 任务标签，表示待完成
		//FIXME 此处带修复
		//XXX 待优化
		//自定义任务标签，java -compeaer-task tags
		//MYWELL 自定义任务标签，表示待优化
		BookMarkAndTasksDemo bmd=createBookMarkAndTasksDemo();
	}

	public static BookMarkAndTasksDemo createBookMarkAndTasksDemo() {
		return new BookMarkAndTasksDemo();
	}

}
