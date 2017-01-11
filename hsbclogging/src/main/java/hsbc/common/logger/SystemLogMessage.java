package hsbc.common.logger;

import java.util.Map;

public class SystemLogMessage extends BaseLogMessage
{
	//Attributes applicable for logs from point-cuts
	private String className = null;
	private String methodName = null;

	//Attributes applicable for logs from http filters
	private String requestUrl = null;
	private Map<String,String> httpHeaders = null;
	private String httpResponseCode = null;
	private String payload = null;

	//Caller provided details
	private String logMessage = null;
	private String direction = null;
	
	public SystemLogMessage(String logMessage)
	{
		super();
		this.logMessage = logMessage;
	}
	public SystemLogMessage(String className, String methodName,String logMessage)
	{
		super();
		this.className = className;
		this.methodName = methodName;
		this.logMessage = logMessage;
	}
	public SystemLogMessage(String direction,String className, String methodName,String payload)
	{
		super();
		this.direction = direction;
		this.className = className;
		this.methodName = methodName;
		this.payload = payload;
	}
	public SystemLogMessage(String direction,String requestUrl)
	{
		super();
		this.direction = direction;
		this.requestUrl = requestUrl;
	}
	public SystemLogMessage(String direction,String requestUrl, Map<String,String> httpHeaders)
	{
		super();
		this.direction = direction;
		this.requestUrl = requestUrl;
		this.httpHeaders = httpHeaders;
	}
	public SystemLogMessage(String direction,String requestUrl, Map<String,String> httpHeaders,String payload)
	{
		super();
		this.direction = direction;
		this.requestUrl = requestUrl;
		this.httpHeaders = httpHeaders;
		this.payload = payload;
	}
	public SystemLogMessage(String direction,String requestUrl, String httpResponseCode, Map<String,String> httpHeaders)
	{
		super();
		this.direction = direction;
		this.requestUrl = requestUrl;
		this.httpResponseCode = httpResponseCode;
		this.httpHeaders = httpHeaders;
	}
	public SystemLogMessage(String direction,String requestUrl, String httpResponseCode, Map<String,String> httpHeaders,String payload)
	{
		super();
		this.direction = direction;
		this.requestUrl = requestUrl;
		this.httpResponseCode = httpResponseCode;
		this.httpHeaders = httpHeaders;
		this.payload = payload;
	}

	public String toString()
	{
		StringBuffer sb = new StringBuffer();

		sb.append("SYSLOG->");
		sb.append(getBaseLog());
		sb.append("|direction:"+direction);
		sb.append("|requestUrl:"+requestUrl);
		sb.append("|httpResponse:"+httpResponseCode);
		sb.append("|httpHeaders:"+formatHeaders(httpHeaders));
		sb.append("|className:"+className);
		sb.append("|methodName:"+methodName);
		sb.append("|logMessage:"+logMessage);
		sb.append("|payload:"+payload);
		
		return sb.toString();
	}
	private String formatHeaders(Map<String, String> headers) 
	{
		StringBuffer sb = new StringBuffer();
		for(String key:headers.keySet())
		{
			sb.append(key+"={"+headers.get(key)+"};");
		}
		return sb.toString();
	}
}
