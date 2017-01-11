package hsbc.common.logger;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;



public class LogServletFilter implements Filter 
{
	private final String DEFAULT_PAYLOAD = new String("<Not Configured To Log>");

	private boolean logPayload = false;
	private Logger logger = Logger.getLogger(LogServletFilter.class);

	public LogServletFilter(boolean logPayload)
	{
		this.logPayload = logPayload;
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		if(logPayload)
		{
			HTTPRequestWrapper hreq = new HTTPRequestWrapper((HttpServletRequest)request);
			HTTPResponseWrapper hres = new HTTPResponseWrapper((HttpServletResponse)response);

			logRequest(hreq,logger);
			chain.doFilter(hreq, hres);
			logResponse(hreq,hres,logger);
		}
		else
		{
			logRequest(request,logger);
			chain.doFilter(request, response);
			logResponse(request,response,logger);
		}

	}

	private void logRequest(ServletRequest request, Logger logger) 
	{
		String url = null;
		HashMap<String,String> requestHeaders = null;
		String payload = DEFAULT_PAYLOAD;
		SystemLogMessage slm = null;
		
		if(request instanceof HttpServletRequest)
		{
			HttpServletRequest hsr = (HttpServletRequest) request;
			url = hsr.getRequestURL().toString()+"?"+hsr.getQueryString();
			requestHeaders = getHttpReqParams(hsr);
		}
		if(request instanceof HTTPRequestWrapper)
		{
			payload = ((HTTPRequestWrapper) request).getPayload();
		}
		
		slm = new SystemLogMessage(SystemLogMessage.ENTERING,url,requestHeaders,payload);
		System.out.println("$$$$$$$$$$$"+slm.toString());
		logger.info(slm.toString());
	}
	private HashMap<String,String> getHttpReqParams(HttpServletRequest hsr) 
	{
		HashMap<String,String> hp = new HashMap<String,String>();
		Enumeration<String> headers = hsr.getHeaderNames();
		//Read HTTP Headers
		while(headers.hasMoreElements())
		{
			String key = headers.nextElement();
			hp.put(key, hsr.getHeader(key));
		}
		//Read Query Parameters
		Enumeration<String> params = hsr.getParameterNames();
		while(params.hasMoreElements())
		{
			String key = params.nextElement();
			hp.put(key, hsr.getParameter(key));
		}
		return hp;
	}

	private void logResponse(ServletRequest request, ServletResponse response, Logger logger)
	{
		String url = null;
		HashMap<String,String> responseHeaders = null;
		String httpResponseCode = null;
		String payload = DEFAULT_PAYLOAD;
		SystemLogMessage slm = null;
		
		if(request instanceof HttpServletRequest)
		{
			HttpServletRequest hsr = (HttpServletRequest) request;
			url = hsr.getRequestURL().toString();
		}
		if(response instanceof HttpServletResponse)
		{
			HttpServletResponse hsr = (HttpServletResponse) response;
			responseHeaders = getHttpResParams(hsr);
			httpResponseCode = ""+hsr.getStatus();
		}
		if(response instanceof HTTPResponseWrapper)
		{
			payload = ((HTTPResponseWrapper)response).getPayload();
		}

		slm = new SystemLogMessage(SystemLogMessage.EXITING,url,httpResponseCode,responseHeaders,payload);
		logger.info(slm.toString());
	}
	private HashMap<String, String> getHttpResParams(HttpServletResponse hsr)
	{
		HashMap<String,String> hp = new HashMap<String,String>();
		for(String key:hsr.getHeaderNames())
		{
			hp.put(key, hsr.getHeader(key));
		}
		return hp;
	}

	public void destroy()
	{//ignore
	}

}
