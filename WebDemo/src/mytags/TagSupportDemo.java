package mytags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagSupportDemo extends TagSupport {
	/**
	 * 输入的值
	 */
	private Integer inputVal;

	/**
	 * @author 20514 2016年1月11日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 标签开始时
	 */
	@Override
	public int doStartTag() throws JspException {
		System.out.println("标签开始");
		JspWriter out = pageContext.getOut();
		try {
			if (1 == inputVal) {
				out.println("<font color=\"red\">哈哈哈中了3等奖</font>");
			} else if (2 == inputVal) {
				out.println("<font color=\"red\">哈哈哈中了布娃娃</font>");
			} else if (3 == inputVal) {
				out.println("<font color=\"red\">没抽中唉</font>");
			} else if (0 == inputVal) {
				System.out.println("跳过标签体的类容");
				return SKIP_BODY;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 输出标签体中的类容
		return EVAL_BODY_INCLUDE;
	}

	/**
	 * 标签结束时
	 */
	@Override
	public int doEndTag() throws JspException {
		System.out.println("标签结束");
		if (88 == inputVal) {
			System.out.println("不在执行后面的jsp类容");
			return SKIP_PAGE;
		}
		// 执行后面的jsp类容
		return EVAL_PAGE;
	}

	public Integer getInputVal() {
		return inputVal;
	}

	public void setInputVal(Integer inputVal) {
		this.inputVal = inputVal;
	}

}