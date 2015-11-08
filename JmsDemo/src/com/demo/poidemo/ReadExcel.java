package com.demo.poidemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/**
 * ��ȡexcel
 * @author hyc
 *
 */
public class ReadExcel {
	/**
	 * ����cell���ͣ���ʽ������
	 * @param cell
	 * @return
	 */
	public static String formatValue(HSSFCell cell){
		if(null==cell){
			return "";
		}
		if(HSSFCell.CELL_TYPE_BOOLEAN == cell.getCellType()){
			return String.valueOf(cell.getBooleanCellValue());
		}else if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
			 if (HSSFDateUtil.isCellDateFormatted(cell)) {
                 // �����Date������ת��ΪData��ʽ
                 Date date = cell.getDateCellValue();
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                 return sdf.format(date);
             }
             // ����Ǵ�����
             else {
                 // ȡ�õ�ǰCell����ֵ
                return String.valueOf(cell.getNumericCellValue());
             }
		}else if (HSSFCell.CELL_TYPE_ERROR == cell.getCellType()) {
			return String.valueOf(cell.getErrorCellValue());
		}else{
			return String.valueOf(cell.getStringCellValue());
		}
	}
	
	
	public static void main(String[] args) {
		try {
			
			File file=new File("C://Users//hyc//Desktop//myexcel.xls");
			InputStream in=new FileInputStream(file);
		
			HSSFWorkbook workbook=new HSSFWorkbook(in);
			//��ȡsheet
			HSSFSheet sheet1=workbook.getSheet("����");
			HSSFCellStyle style=workbook.createCellStyle();
			style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
			for (int i = 0; i <=sheet1.getLastRowNum(); i++) {
				HSSFRow row=sheet1.getRow(i);
				for (int j = 0; j <=row.getLastCellNum(); j++) {
					HSSFCell cell=row.getCell(j);
					System.out.print(formatValue(cell)+"\t\t");
				}
				System.out.println();
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
