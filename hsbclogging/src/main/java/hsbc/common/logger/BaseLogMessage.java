package hsbc.common.logger;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseLogMessage 
{
	//Static variable to mention the direction of logging
	public static final String ENTERING = new String("ENTERING");
	public static final String EXITING = new String("EXITING");

	private Date currentDateTime = null;
	private String threadId = null;
	private String hostname = null;

	//Attributes available from ThreadLocal
	private String correlationId = null;
	private String userId = null;

	public BaseLogMessage()
	{
		currentDateTime = new Date();
		Thread currentThread = Thread.currentThread(); 
		threadId = currentThread.getId()+"-"+currentThread.getName()+"("+currentThread.getThreadGroup().getName()+")";
		//correlationId = ServiceContext.getCorrelationId();
		//userId = ServiceContext.getUserId();
		try
		{
			hostname = InetAddress.getLocalHost().toString();
		} 
		catch (UnknownHostException e)
		{
			//ignore
		}
	}
	public String getBaseLog()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSSZ");

		StringBuffer sb = new StringBuffer();
		sb.append("|datetime:"+sdf.format(currentDateTime));
		sb.append("|hostname:"+hostname);
		sb.append("|threadId:"+threadId);
		//sb.append("|userId:"+userId);
		//sb.append("|correlationId:"+correlationId);
		
		return sb.toString();
	}
}
