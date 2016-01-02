package c001;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class MyRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("requestDestroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent requestEvent) {
		System.out.println("---------------------------------------------------");
		System.out.println("requestInitialized");
		HttpServletRequest request = (HttpServletRequest) requestEvent.getServletRequest();
		System.out.println("getRemoteHost" + request.getRemoteHost());
		System.out.println("getRemotePort" + request.getRemotePort());
		System.out.println("---------------------------------------------------");
	}

}
