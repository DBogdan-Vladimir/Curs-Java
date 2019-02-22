package BogdanVladimir.Tema2b;

import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


@SuppressWarnings("restriction")
public class MyReplyToQuerySize implements HttpHandler {

	public void handle(HttpExchange t) throws IOException 
	{
		String response;
		//set the response as a string containing html code
		if (t.getRequestURI().getQuery().toString()!=null && t.getRequestURI().getQuery().toString().length()>5)
		{
		response = "Your account is ready! "+ t.getRequestURI().getQuery().toString()+ " " + t.getProtocol() + " " + t.getRequestMethod();
		}else response = "The size of your typed query: " + t.getRequestURI().getQuery().toString().length();
		
		//set headers and status code
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		//send response
		os.write(response.getBytes());
		//close request
		os.close();
	}
}

