//package startjetty;
//
//import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.server.ServerConnector;
//
//public class OneConnector {
//	public static void main(String[] args) throws Exception {
//		// The Server
//		Server server = new Server();
//
//		// HTTP connector
//		ServerConnector http = new ServerConnector(server);
//		http.setHost("localhost");
//		http.setPort(8080);
//		http.setIdleTimeout(30000);
//
//		// Set the connector
//		server.addConnector(http);
//
//		// Set a handler
//		server.setHandler(new HelloWorldJetty());
//
//		// Start the server
//		server.start();
//		server.join();
//	}
//}
