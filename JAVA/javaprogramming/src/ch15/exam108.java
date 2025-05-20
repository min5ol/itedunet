package ch15;

import java.net.*;

public class exam108
{

	public static void main(String[] args)
	{
		InetAddress ip = null;
		
		try
		{
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName(): "+ip.getHostName());
			System.out.println("getHostAddress(): "+ip.getHostAddress());
		}
		catch(UnknownHostException e)
		{
			e.printStackTrace();
		}
	}

}
