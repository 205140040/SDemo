package mytags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 自定义if标签
 * @author 20514
 * 2016年1月4日
 * @description
 */
public class MyIfTag extends SimpleTagSupport {
	/**
	 * 条件id
	 */
	private Integer ifId;

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
//		out.println("<c:if test=\"${"+ifId+"==1}\">");
		System.out.println(ifId);
		if(1==ifId){
			// 输出标签类容
			getJspBody().invoke(null);
		}
		
//		out.println("</c:if>");
	}

	public Integer getIfId() {
		return ifId;
	}

	public void setIfId(Integer ifId) {
		this.ifId = ifId;
	}

}
