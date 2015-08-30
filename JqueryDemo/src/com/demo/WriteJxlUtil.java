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
 * jxl������
 * @date 2015��8��30��
 * @author hyc
 * @description
 */
public class WriteJxlUtil {

	public static void main(String[] args) {
		try {
			File file=new File("D://win7�ҵ��ĵ�-����-�ղؼ�//Desktop//test.xls");
			OutputStream os=new FileOutputStream(file);
			// ����һ����������������excel
			WritableWorkbook workbook=Workbook.createWorkbook(os);
			//����������,sheet
			WritableSheet sheet1=workbook.createSheet("�γ̱�", 0);
			/**
			 * ��ӵ�Ԫ���ʽ��,
			 * ��Ҫ�Ǹı䵥Ԫ�񱳾������塢��ɫ�ȵȡ�
			 */
			WritableCellFormat wcf=new WritableCellFormat();
			//���þ���
			wcf.setAlignment(Alignment.CENTRE);
			//���ñ߿���
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			//���ñ���ɫ
			wcf.setBackground(Colour.LIGHT_GREEN);
			
			String[] titles={"����","����"};
			//д��titles
			for (int i = 0; i < titles.length; i++) {
				sheet1.addCell(new Label(i, 0, titles[i],wcf));
			}
			//д��content
			User u1=new User("����1","zs1123");
			User u2=new User("����2","zs2123");
			User u3=new User("����3","zs3123");
			
			
			List<User> users=new ArrayList<>();
			users.add(u1);
			users.add(u2);
			users.add(u3);
			for(int j=0;j<users.size();j++){
				sheet1.addCell(new Label(0, j+1, users.get(j).getUname(),wcf));
				sheet1.addCell(new Label(1, j+1, users.get(j).getUpwd(),wcf));
			}
			
			//������ǩ��label,���������ֱ��ʾcol+1�У�row+1�У�����������title��
//			Label label1=new Label(0, 0, "�ܼ�",wcf);
//			sheet1.addCell(label1);
//			Label label2=new Label(1, 0, "���",wcf);
//			sheet1.addCell(label2);
//			//��ǩ���뵽��������
//			//���string
//			Label label3=new Label(0, 1, "��һ",wcf);
//			sheet1.addCell(label3);
//			//�������
//			Number n1=new Number(1, 1, 3.1415,wcf);
//			sheet1.addCell(n1);
			
			
			//������д���ļ�
			workbook.write();
			System.out.println("д��excel���");
			workbook.close();
			os.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				
	}
	

}
