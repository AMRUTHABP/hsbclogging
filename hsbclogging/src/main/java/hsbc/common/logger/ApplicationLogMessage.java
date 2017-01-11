package hsbc.common.logger;

public class ApplicationLogMessage extends BaseLogMessage
{
	//Attributes applicable for logs from class references
	private String className = null;
	
	//Actual log message
	private String logMessage = null;
	
	public ApplicationLogMessage(String className, String logMessage)
	{
		super();
		this.className = className;
		this.logMessage = logMessage;
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();

		sb.append("APPLOG->");
		sb.append(getBaseLog());
		sb.append("|className:"+className);
		sb.append("|logMessage:"+logMessage);
		
		return sb.toString();
	}
}
