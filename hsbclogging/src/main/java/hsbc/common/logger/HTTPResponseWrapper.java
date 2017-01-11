package hsbc.common.logger;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class HTTPResponseWrapper extends HttpServletResponseWrapper
{
	private HTTPServletOutputStream hsos = null;
	
	public HTTPResponseWrapper(HttpServletResponse response) 
	{
		super(response);
		try 
		{
			hsos = new HTTPServletOutputStream(response.getOutputStream());
		} 
		catch (IOException e) 
		{
			//new SystemException(ExceptionMessage.ERROR_READING_HTTP_OUTPUTSTREAM);
		}
	}

	public String getPayload() 
	{
		return hsos.getPayload();
	}
	
	@Override
	public ServletOutputStream getOutputStream()
	{
		return hsos;
		
	}

}
