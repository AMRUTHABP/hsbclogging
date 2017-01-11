package hsbc.common.logger;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class HTTPRequestWrapper extends HttpServletRequestWrapper
{
	byte[] payload = null;
	HTTPServletInputStream hsis = null;
	
	public HTTPRequestWrapper(HttpServletRequest request) 
	{
		super(request);
		try
		{
			InputStream is = request.getInputStream();
			payload = new byte[is.available()];
			is.read(payload);
			hsis = new HTTPServletInputStream(payload);
		}
		catch (IOException e)
		{
			//throw new SystemException(ExceptionMessage.ERROR_READING_HTTP_INPUTSTREAM);
		}
	}

	public String getPayload() 
	{
		return new String(payload);
	}
	
	@Override
	public ServletInputStream getInputStream()
	{
		return hsis;
	}

}
