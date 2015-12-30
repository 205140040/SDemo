package c001;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("filter do filter");
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		HttpSession session=request.getSession();
		String username=session.getAttribute("username").toString();
		if(null!=username||!"".equals(username)){
			//执行后面的
			filterChain.doFilter(req, res);
		}else{
			//重定向到登录页面
			response.sendRedirect("/login");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init");
		
	}

}
