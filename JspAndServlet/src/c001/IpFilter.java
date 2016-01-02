package c001;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 过滤ip
 * @author 20514
 *
 */
public class IpFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String reqIp=getRemortIP(request);
		String reqRefer=request.getHeader("Referer");
		System.out.println("reqHost"+reqIp);
		System.out.println("reqRefer"+reqRefer);
		if("192.168.207.100".equals(reqIp)){
			PrintWriter out=response.getWriter();
			out.println("<h1>你在黑名单中，无权访问</h1>");
			out.close();
		}else{
			filterChain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init");
		
	}

	/**
	 * 获取ip地址
	 * @param request
	 * @return
	 */
	public String getRemortIP(HttpServletRequest request) {  
	    if (request.getHeader("x-forwarded-for") == null) {  
	        return request.getRemoteAddr();  
	    }  
	    return request.getHeader("x-forwarded-for");  
	}  
}
