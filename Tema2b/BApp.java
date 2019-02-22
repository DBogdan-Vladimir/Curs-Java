package BogdanVladimir.Tema2b;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

@SuppressWarnings("restriction")
public class BApp 
{
	public static void main(String[] args) throws IOException 
	{
	//creates web server service
	HttpServer server = HttpServer.create(new InetSocketAddress(8001), 0);
	//set handler to specified path
	server.createContext("/", new MyStringHandler());
	server.createContext("/html", new MyHtmlHandler());
	server.createContext("/Empty", new MyEmptyHandlerEmpty());
	server.createContext("/QuerySize", new MyReplyToQuerySize());
	server.createContext("/PassHandler", new MyPassHandler());
	
	server.createContext("/ArrayHandler", new MyArrayHandler());
	
	//creates a default executor
	server.setExecutor(null);
	//start the server
	server.start();
	System.out.println("Server Started on port 8001");
	}

}
