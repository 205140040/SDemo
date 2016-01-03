package mytags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 
 * @author 20514
 * 2016年1月3日
 * @description自定义heading标签
 */
public class HeadingTag extends SimpleTagSupport {
	
	private String align;
	private String bgColor;
	private String border;
	private String fontColor;
	private String font;
	private String size;
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out=getJspContext().getOut();
		out.print("<table align=\""+align+"\"\n"
				+"bgcolor=\""+bgColor+"\"\n"
				+"border=\""+border+"\""+">\n");
		out.print("<tr><th>");
		out.print("<span style=\"color:"+fontColor+";\n"
				+"font-family:"+font+";\n"
				+"font-size:"+size+"px;"
				+"\">\n");
		//content body
		getJspBody().invoke(null);
		out.println("</span></th></tr></table>"
				+"<br clear=\"all\"><br>");
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getBorder() {
		return border;
	}

	public void setBorder(String border) {
		this.border = border;
	}

	public String getFontColor() {
		return fontColor;
	}

	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	
}
