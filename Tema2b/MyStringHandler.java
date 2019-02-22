package BogdanVladimir.Tema2b;

import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class MyStringHandler implements HttpHandler
{
	
	public void handle(HttpExchange t) throws IOException 
	{
		//set response as normal string
		String response = "This is a string response you filthy animal!";
		System.out.println(response);
		//set headers and status code
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		//send response
		os.write(response.getBytes());
		//close request
		os.close();
	}
}
