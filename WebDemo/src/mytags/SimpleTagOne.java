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
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter jspWriter = this.getJspContext().getOut();
		jspWriter.println("<b>hello World!</b>");
	}
}
