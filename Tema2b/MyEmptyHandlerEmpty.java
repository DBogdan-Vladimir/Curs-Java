package BogdanVladimir.Tema2b;

import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


@SuppressWarnings("restriction")
public class MyEmptyHandlerEmpty implements HttpHandler 
{
	public void handle(HttpExchange t) throws IOException
	{
		//set the response as a string containing html code
		String response = " ";
		//set headers and status code
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		//send response
		os.write(response.getBytes());
		//close request
		os.close();
	}
	
}
