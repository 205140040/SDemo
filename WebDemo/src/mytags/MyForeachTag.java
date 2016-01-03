package mytags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyForeachTag<T> extends SimpleTagSupport {
	//循环的list
	private List<T> list;
	//循环的对象
	private String var;
	
	 
	@Override
	public void doTag() throws JspException, IOException {
		for (int i = 0; i < list.size(); i++) {
			//通过设置tag内部可访问的属性，设置list每次循环的值
			getJspContext().setAttribute(var, list.get(i));
			getJspBody().invoke(null);
		}
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	
	
}
