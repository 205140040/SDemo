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
			File file=new File("D://win7�ҵ��ĵ�-����-�ղؼ�//Desktop//test.xls");
			InputStream inputStream=new FileInputStream(file);
			Workbook workbook=Workbook.getWorkbook(inputStream);
			//��ȡ��һ��sheet
			Sheet sheet=workbook.getSheet(0);
			//��ȡrows
			sheet.getRows();
			//����
			for (int i = 1; i < sheet.getRows(); i++) {
				//����һ�����飬�洢ÿһ�е�ֵ
				String[] strings=new String[sheet.getColumns()];
				//����
				for(int j=0;j<sheet.getColumns();j++){
					//��ȡcell
					Cell cell=sheet.getCell(j, i);
					strings[j]=cell.getContents();
					System.out.print(cell.getContents()+"\t");
				}
				System.out.println();
				result.add(strings);//��һ�н����ӵ�list��
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
