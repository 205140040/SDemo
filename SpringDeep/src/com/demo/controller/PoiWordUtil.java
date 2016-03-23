package com.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

public class PoiWordUtil {
	public static void main(String[] args) throws Exception {
		/**
		 * 目录 1 读word doc文件 1.1 通过WordExtractor读文件 1.2 通过HWPFDocument读文件 2 写word
		 * doc文件
		 * 
		 * Apache poi的hwpf模块是专门用来对word
		 * doc文件进行读写操作的。在hwpf里面我们使用HWPFDocument来表示一个word
		 * doc文档。在HWPFDocument里面有这么几个概念： l
		 * Range：它表示一个范围，这个范围可以是整个文档，也可以是里面的某一小节（Section），也可以是某一个段落（Paragraph），
		 * 还可以是拥有共同属性的一段文本（CharacterRun）。 l
		 * Section：word文档的一个小节，一个word文档可以由多个小节构成。 l
		 * Paragraph：word文档的一个段落，一个小节可以由多个段落构成。 l
		 * CharacterRun：具有相同属性的一段文本，一个段落可以由多个CharacterRun组成。 l Table：一个表格。 l
		 * TableRow：表格对应的行。 l TableCell：表格对应的单元格。
		 * Section、Paragraph、CharacterRun和Table都继承自Range。
		 */
		File inFile = new File("C:\\Users\\20514\\Desktop\\wordTemplate.doc");
		InputStream in = new FileInputStream(inFile);
		// doc
		HWPFDocument doc = new HWPFDocument(in);
		// 根据模板替换类容
		Range range = doc.getRange();
		// 把range范围内的${reportDate}替换为当前的日期
		range.replaceText("${wdate}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		range.replaceText("${title}", "poi写word");
		range.replaceText("${pname}", "提莫宠物");
		range.replaceText("${pmoney}", "6666.66");
		OutputStream os = new FileOutputStream("C:\\Users\\20514\\Desktop\\write.doc");
		// 把doc输出到输出流中
		doc.write(os);
		in.close();
		os.close();
		System.out.println("写成功---------------");
	}
}
