package BogdanVladimir.Tema2b;

import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


@SuppressWarnings("restriction")
public class MyHtmlHandler implements HttpHandler 

{
	public void handle(HttpExchange t) throws IOException
	{
		//set the response as a string containing html code
		String response = "<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"  <meta charset=\"utf-8\">\r\n" + 
				"\r\n" + 
				"  <title>Bogdan is testing</title>\r\n" + 
				"  <meta name=\"description\" content=\"Bogdan is testing\">\r\n" + 
				"  <meta name=\"author\" content=\"Bogdan\">\r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"  <h1>Test this, Bogdan</h1>\r\n" + 
				"  <p>This is a paragraph!</p>\r\n" + 
				"  <p>Lorem ipsum dolor sit amet, ex tale iusto mei, ad minimum tacimates est. Utinam option eam ad, vivendo accusam disputationi vix cu. Et utinam nostrud scripserit his, sit graeco audiam euripidis in. Ex sed augue novum. Et pri suscipit phaedrum. Quo mnesarchum consetetur in, no alia imperdiet his, ei enim quot tacimates eos.</p>\r\n" + 
				"  <div class=\"pagination\">\r\n" + 
				"    <a href=\"javascript:void(0)\">Previous Page</a>\r\n" + 
				"    <a href=\"javascript:void(0)\">Next Page</a>\r\n" + 
				"  </div>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>";
		//set headers and status code
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		//send response
		os.write(response.getBytes());
		//close request
		os.close();
	}
	
}

/*
1. <html><body><h1>Response from '/html' servlet</h1><br><br><span>This is the output</span></body></html>
///
2.
<html lang="en">
<head>
  <meta charset="utf-8">

  <title>Bogdan is testing</title>
  <meta name="description" content="Bogdan is testing">
  <meta name="author" content="Bogdan">

</head>

<body>
  <h1>Test this, Bogdan</h1>
  <p>This is a paragraph!</p>
  	<div>
  		<a href="google.ro" target="_blank">Search me on google</a>
  		<a href="google.com">Go to your email</a>
	</div>
</body>
</html>

3.
<html lang="en">
<head>
  <meta charset="utf-8">

  <title>Bogdan is testing</title>
  <meta name="description" content="Bogdan is testing">
  <meta name="author" content="Bogdan">

</head>

<body>
  <h1>Test this, Bogdan</h1>
  <p>This is a paragraph!</p>
  <p>Lorem ipsum dolor sit amet, ex tale iusto mei, ad minimum tacimates est. Utinam option eam ad, vivendo accusam disputationi vix cu. Et utinam nostrud scripserit his, sit graeco audiam euripidis in. Ex sed augue novum. Et pri suscipit phaedrum. Quo mnesarchum consetetur in, no alia imperdiet his, ei enim quot tacimates eos.</p>
  <div class="pagination">
    <a href="javascript:void(0)">Previous Page</a>
    <a href="javascript:void(0)">Next Page</a>
  </div>

</body>
</html>



*
*/