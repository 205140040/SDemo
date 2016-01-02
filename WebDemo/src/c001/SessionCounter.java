package c001;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounter implements HttpSessionListener{
	private Integer totalCount=0;
	private Integer currentCount=0;
	private Integer maxCount=0;
	private ServletContext servletContext;
	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		System.out.println("session sessionCreated");
		totalCount++;
		currentCount++;
		if(maxCount<currentCount){
			maxCount=currentCount;
		}
		if(servletContext==null){
			HttpSession session=sessionEvent.getSession();
			servletContext=session.getServletContext();
			//把当前对象,存放如context属性中
			servletContext.setAttribute("sessionCount", this);
		}
		System.out.println(totalCount);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		System.out.println("session destroy");
		currentCount--;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(Integer currentCount) {
		this.currentCount = currentCount;
	}

	public Integer getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(Integer maxCount) {
		this.maxCount = maxCount;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
