package servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImgSevlet extends HttpServlet {
	// 请求次数
	public static Integer reqCount = 0;

	/**
	 * @author 20514 2016年1月11日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		reqCount++;
		HttpServletResponse response = (HttpServletResponse) res;
		// 设置字符集
		response.setCharacterEncoding("UTF-8");
		// 2.在服务器的动态网页中禁止缓存，要加入类似如下脚本
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 设置文件下载响应类容格式
		response.setContentType("image/jpeg");
		BufferedImage bi = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bi.getGraphics();
		graphics.fillRect(0, 0, 80, 20);
		graphics.setColor(Color.BLUE);
		graphics.setFont(new Font(null, Font.BOLD, 18));
		graphics.drawString("露露啦" + reqCount.toString(), 0, 18);
		// 结束绘图
		graphics.dispose();
		// 得到输出流
		ServletOutputStream sos = res.getOutputStream();
		ImageIO.write(bi, "JPEG", sos);
		sos.close();
	}
}
