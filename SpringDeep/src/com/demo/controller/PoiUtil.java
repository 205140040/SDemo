package com.demo.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class PoiUtil {
	public static <T> void wireExcel(String sheetName, List<TitleObject> titleMap, List<T> content, Class<T> clazz,
			OutputStream outputStream) {
		if (null == sheetName) {
			sheetName = "Sheet1";
		}
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(sheetName);
		// 样式
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		// 三、设置居中:
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中

		HSSFRow row0 = sheet.createRow(0);// 第一行
		ArrayList<String> titleCnList = new ArrayList<>();// 中文名称
		ArrayList<String> titleEnList = new ArrayList<>();// 字段名称
		/**
		 * 设置中文名称list,字段名称list
		 */
		for (TitleObject titleObject : titleMap) {
			titleEnList.add(titleObject.getColumnName());
			titleCnList.add(titleObject.getChinaName());
		}
		// 设置标题
		for (int i = 0; i < titleCnList.size(); i++) {
			HSSFCell cell = row0.createCell(i);
			cell.setCellValue(titleCnList.get(i));
			cell.setCellStyle(cellStyle);
		}
		// 设置类容
		for (int i = 0; i < content.size(); i++) {
			HSSFRow row = sheet.createRow(i + 1);// 创建一行
			JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(content.get(i)));
			Integer titleSize = titleEnList.size();
			for (int j = 0; j < titleSize; j++) {
				HSSFCell cell = row.createCell(j);
				String key = titleEnList.get(j);
				Object cellValue = jsonObject.get(key);
				String cellStr = cellValue == null ? "" : cellValue.toString();
				cell.setCellValue(cellStr);
				cell.setCellStyle(cellStyle);
			}
		}
		try {
			workbook.write(outputStream);
			outputStream.close();
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
