package com.demo.poidemo;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/**
 * 写出excel
 * @author hyc
 *
 */
public class WriteExcel {
	public static void main(String[] args) {
		try {
			// 工作薄
			HSSFWorkbook workbook = new HSSFWorkbook();
			// sheet
			HSSFSheet sheet = workbook.createSheet("报表");
			// 样式
			// 设置单元格格式
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			HSSFRow row1 = sheet.createRow(0);// 创建一行
			HSSFCell cell = row1.createCell(0);// 单元格
			cell.setCellValue("姓名");
			// row1.createCell(1).setCellValue("性别");
			createCell(row1, 1, "性别", workbook);
			row1.createCell(2).setCellValue("年龄");
			row1.createCell(3).setCellValue("生日");
			row1.createCell(4).setCellValue("其他");
			row1.createCell(5).setCellValue("错误");
			HSSFRow row2 = sheet.createRow(1);
			row2.createCell(0).setCellValue("张三");
			row2.createCell(1).setCellValue("男");
			row2.createCell(2).setCellValue(18);
//			HSSFCell r2cell3 = row2.createCell(3);
//			r2cell3.setCellStyle(cellStyle);
//			r2cell3.setCellValue(new Date());// 生日
			createCell(row2, 3, new Date(), workbook);
			// 设置cell编码解决中文高位字节截断
			HSSFCell r2Cell4 = row2.createCell(4);
			r2Cell4.setCellValue("其他");
			// 设置cell错误
			HSSFCell r2Cell5 = row2.createCell(5);
			r2Cell5.setCellType(HSSFCell.CELL_TYPE_ERROR);
			//row3
			HSSFRow row3=sheet.createRow(2);
			createCell(row3, 0, "李四", workbook);
			createCell(row3, 1, "女", workbook);
			createCell(row3, 2, 18, workbook);
			createCell(row3, 3, new Date(), workbook);
			createCell(row3, 4, "MM", workbook);
			createCell(row3, 5, "error", workbook);
			OutputStream out = new FileOutputStream("C://Users//hyc//Desktop//myexcel.xls");
			workbook.write(out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 创建cell
	 * @param row
	 * @param column
	 * @param o
	 * @param workbook
	 * @return
	 */
	public static HSSFCell createCell(HSSFRow row, int column,Object o, HSSFWorkbook workbook) {
		HSSFCell cell = row.createCell(column);
		HSSFCellStyle style=workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//居中
		if(o instanceof String){
			cell.setCellValue((String)o);
		}else if(o instanceof Boolean){
			cell.setCellValue((Boolean)o);
		}else if(o instanceof Date){
			//日期格式
			style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
			cell.setCellValue((Date)o);
		}else if(o instanceof Double){
			cell.setCellValue((Double)o);
		}else if (o instanceof Integer) {
			Integer n=(Integer)o;
			String s=n.toString();
			System.out.println(s);
			cell.setCellValue(new Double(s));
		}
		cell.setCellStyle(style);
		return cell;
	}
}
