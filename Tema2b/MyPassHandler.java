package BogdanVladimir.Tema2b;

import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

@SuppressWarnings("restriction")
public class MyPassHandler implements HttpHandler 
{
	public void handle(HttpExchange t) throws IOException
	{
		
		String response;
		if (t.getRequestURI().getQuery().toString()!=null && t.getRequestURI().getQuery().toString().contentEquals("1234")) 
		{
			response = "Passed";
		}else response = "Incorrect!";
		
		
		//set the response as a string containing html code
		//set headers and status code
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		//send response
		os.write(response.getBytes());
		//close request
		os.close();
	}
	
}
