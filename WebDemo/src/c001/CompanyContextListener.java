package c001;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CompanyContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("company destroy");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("company init");
		//得到context
		ServletContext context=event.getServletContext();
		String companyName=context.getInitParameter("companyName");
		context.setAttribute("companyName", companyName);
		
		
	}

}
