package com.demo.c18.iodemo;

import java.io.File;
import java.io.FileInputStream;

public class IoDemo {
	public static void main(String[] args) {
		try {
			FileInputStream bufferedReader = new FileInputStream(new File("C://Users//20514//Desktop//testIo.txt"));
			StringBuffer sBuffer = new StringBuffer();
			while (bufferedReader.read() != -1) {
				System.out.println((char) bufferedReader.read());
			}
			bufferedReader.close();
			System.out.println(sBuffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
