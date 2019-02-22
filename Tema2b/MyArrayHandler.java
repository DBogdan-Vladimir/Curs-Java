package BogdanVladimir.Tema2b;

import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


@SuppressWarnings("restriction")
public class MyArrayHandler implements HttpHandler 
{
	public void handle(HttpExchange t) throws IOException
	{
		
		String url = t.getRequestURI().getQuery().toString();
		//String urlVal[] = url.split("?");
		
		// se blocheaza la urlVal[] ... de ce ??
			
		//set the response as a string containing html code
		String response = t.getRequestURI().getQuery().toString();
		
		//String response = urlVal[1];
		
		//set headers and status code
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		//send response
		os.write(response.getBytes());
		//close request
		os.close();
	}
	
}
