package com.demo.c18.iodemo;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class LockFile {
public static void main(String[] args) throws Exception {
	FileOutputStream fos=new FileOutputStream("C://Users//20514//Desktop//testIo.txt");
	FileLock fileLock=fos.getChannel().tryLock();
	if(fileLock!=null){
		System.out.println("加锁成功");
		TimeUnit.MILLISECONDS.sleep(1000);
		System.out.println("释放锁");
		fileLock.release();
	}
	fos.close();
}
}
