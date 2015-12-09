package com.demo.c18.iodemo;

import java.io.File;
import java.util.Date;

public class FileDemo {
public static void main(String[] args) {
	File file=new File("D://IOTest");
	DirFilter fileter=new DirFilter("t");
	fileter.accept(new File("D://IOTest/t3.txt"), "txt");
	String[]  list=file.list();
	for(String s:list){
//		System.out.println(s);
	}
	File txtfile=new File("D://IOTest//t3.txt");
	if (txtfile.exists()) {
		System.out.println("绝对路径"+txtfile.getAbsolutePath());
		System.out.println("父目录"+txtfile.getParent());
		System.out.println("路径"+txtfile.getPath());
		System.out.println("名称"+txtfile.getName());
		System.out.println("大小"+txtfile.length());
		System.out.println("可读"+txtfile.canRead());
		System.out.println("可写"+txtfile.canWrite());
		System.out.println("更改"+new Date(txtfile.lastModified()).toLocaleString());
		if(txtfile.isFile()){
			System.out.println("是文件");
//			txtfile.renameTo(new File("D://IOTest//rename.txt"));
			if(txtfile.exists()){
				//存在则删除
//				txtfile.delete();
				System.out.println("删除成功");
			}
			System.out.println("重命名");
		}
		if(txtfile.isDirectory()){
			System.out.println("是目录");
		}
		File file2=new File("D://IOTest//t4.txt");
		if(file2.exists()){
			System.out.println("--------------------------------------------------------------");
			System.out.println("存在");
			System.out.println("绝对路径"+file2.getAbsolutePath());
			System.out.println("父目录"+file2.getParent());
			System.out.println("路径"+file2.getPath());
			System.out.println("名称"+file2.getName());
			System.out.println("大小"+file2.length());
			System.out.println("可读"+file2.canRead());
			System.out.println("可写"+file2.canWrite());
			System.out.println("更改"+new Date(file2.lastModified()).toLocaleString());
		}else{
			file2.mkdirs();
			System.out.println("新建成功");
		}
	}
	

}
}
