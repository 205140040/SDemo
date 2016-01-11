package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过response对象实现文件下载
 * 
 * @author 20514 2016年1月11日
 * @description
 */
public class FileDownload extends HttpServlet {

	/**
	 * @author 20514 2016年1月11日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		HttpServletResponse response = (HttpServletResponse) res;
		// 设置字符集
		response.setCharacterEncoding("UTF-8");
		// 设置文件下载响应类容格式
		response.setContentType("application/x-msdownload");

//		File file = new File("D:\\图片\\txSmm.png");
		
		File file = new File("C:\\Users\\20514\\Desktop\\工作簿1.xlsx");

		//文件名称，包含后缀名
		String fileName = "";
		fileName = file.getName();
		System.out.println("文件名称："+fileName);
		// 读取文件
		InputStream in = new FileInputStream(file);
		byte[] b = new byte[(int) file.length()];
		in.read(b, 0, (int) file.length());
		// 设置文件名
		response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
		ServletOutputStream out = response.getOutputStream();
		out.write(b);
		in.close();
		out.close();
	}

}
