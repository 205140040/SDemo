//package startjetty;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.eclipse.jetty.server.Request;
//import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.server.handler.AbstractHandler;
//
//public class HelloWorldJetty extends AbstractHandler {
//
//	@Override
//	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
//			throws IOException, ServletException {
//		response.setContentType("text/html; charset=utf-8");
//		response.setStatus(HttpServletResponse.SC_OK);
//		response.getWriter().println("<h1>Hello World handler</h1>");
//		baseRequest.setHandled(true);
//	}
//
//	public static void main(String[] args) {
//		Server server = new Server(8080);
//		server.setHandler(new HelloWorldJetty());
//		try {
//			server.start();
//			server.join();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//}
