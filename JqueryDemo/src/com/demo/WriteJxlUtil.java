package com.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * 
 * jxl工具类
 * @date 2015年8月30日
 * @author hyc
 * @description
 */
public class WriteJxlUtil {

	public static void main(String[] args) {
		try {
			File file=new File("D://win7我的文档-桌面-收藏夹//Desktop//test.xls");
			OutputStream os=new FileOutputStream(file);
			// 创建一个工作簿，即整个excel
			WritableWorkbook workbook=Workbook.createWorkbook(os);
			//创建工作表,sheet
			WritableSheet sheet1=workbook.createSheet("课程表", 0);
			/**
			 * 添加单元格的式样,
			 * 主要是改变单元格背景、字体、颜色等等。
			 */
			WritableCellFormat wcf=new WritableCellFormat();
			//设置居中
			wcf.setAlignment(Alignment.CENTRE);
			//设置边框线
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			//设置背景色
			wcf.setBackground(Colour.LIGHT_GREEN);
			
			String[] titles={"姓名","密码"};
			//写入titles
			for (int i = 0; i < titles.length; i++) {
				sheet1.addCell(new Label(i, 0, titles[i],wcf));
			}
			//写入content
			User u1=new User("张三1","zs1123");
			User u2=new User("张三2","zs2123");
			User u3=new User("张三3","zs3123");
			
			
			List<User> users=new ArrayList<>();
			users.add(u1);
			users.add(u2);
			users.add(u3);
			for(int j=0;j<users.size();j++){
				sheet1.addCell(new Label(0, j+1, users.get(j).getUname(),wcf));
				sheet1.addCell(new Label(1, j+1, users.get(j).getUpwd(),wcf));
			}
			
			//创建标签，label,三个参数分别表示col+1列，row+1行，标题内容是title。
//			Label label1=new Label(0, 0, "周几",wcf);
//			sheet1.addCell(label1);
//			Label label2=new Label(1, 0, "金额",wcf);
//			sheet1.addCell(label2);
//			//标签加入到工作表中
//			//填充string
//			Label label3=new Label(0, 1, "周一",wcf);
//			sheet1.addCell(label3);
//			//填充数字
//			Number n1=new Number(1, 1, 3.1415,wcf);
//			sheet1.addCell(n1);
			
			
			//将工作写成文件
			workbook.write();
			System.out.println("写出excel完毕");
			workbook.close();
			os.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				
	}
	

}
