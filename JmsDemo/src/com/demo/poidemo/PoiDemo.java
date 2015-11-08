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

public class PoiDemo {
	public static void main(String[] args) {
		try {
			// ������
			HSSFWorkbook workbook = new HSSFWorkbook();
			//sheet
			HSSFSheet sheet = workbook.createSheet("����");
			//��ʽ
			// ���õ�Ԫ���ʽ
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			HSSFRow row1 = sheet.createRow(0);// ����һ��
			HSSFCell cell = row1.createCell(0);// ��Ԫ��
			cell.setCellValue("����");
//			row1.createCell(1).setCellValue("�Ա�");
			createCell(row1, 1, "�Ա�", cellStyle);
			row1.createCell(2).setCellValue("����");
			row1.createCell(3).setCellValue("����");
			row1.createCell(4).setCellValue("����");
			row1.createCell(5).setCellValue("����");
			HSSFRow row2 = sheet.createRow(1);
			row2.createCell(0).setCellValue("����");
			row2.createCell(1).setCellValue("��");
			row2.createCell(2).setCellValue(18);
			
			cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
			HSSFCell r2cell3 = row2.createCell(3);
			
			r2cell3.setCellStyle(cellStyle);
			r2cell3.setCellValue(new Date());//����
			//����cell���������ĸ�λ�ֽڽض�
			HSSFCell r2Cell4=row2.createCell(4);
			r2Cell4.setCellValue("����");
			//����cell����
			HSSFCell r2Cell5=row2.createCell(5);
			r2Cell5.setCellType(HSSFCell.CELL_TYPE_ERROR);
			

			OutputStream out = new FileOutputStream("C://Users//hyc//Desktop//myexcel.xls");
			workbook.write(out);
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static HSSFCell createCell(HSSFRow row,int column,String value,HSSFCellStyle style){
		HSSFCell cell=row.createCell(column);
		cell.setCellValue(value);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//����
		cell.setCellStyle(style);
		return cell;
	} 
}
