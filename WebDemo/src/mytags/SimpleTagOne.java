package mytags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * �Զ����ǩ
 * @author 20514
 *
 */
public class SimpleTagOne extends SimpleTagSupport {
	/**
	 * 自定义属性
	 */
	private String userName;
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter jspWriter = this.getJspContext().getOut();
		jspWriter.println("<b>"+this.getUserName()+"你好!</b>");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
