package com.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadJxlUtil {

	public static void main(String[] args) {
		try {
			List<String[]> result=new ArrayList<>();
			File file=new File("D://win7我的文档-桌面-收藏夹//Desktop//test.xls");
			InputStream inputStream=new FileInputStream(file);
			Workbook workbook=Workbook.getWorkbook(inputStream);
			//获取第一个sheet
			Sheet sheet=workbook.getSheet(0);
			//获取rows
			sheet.getRows();
			//行数
			for (int i = 1; i < sheet.getRows(); i++) {
				//创建一个数组，存储每一列的值
				String[] strings=new String[sheet.getColumns()];
				//列数
				for(int j=0;j<sheet.getColumns();j++){
					//获取cell
					Cell cell=sheet.getCell(j, i);
					strings[j]=cell.getContents();
					System.out.print(cell.getContents()+"\t");
				}
				System.out.println();
				result.add(strings);//将一列结果添加到list中
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
