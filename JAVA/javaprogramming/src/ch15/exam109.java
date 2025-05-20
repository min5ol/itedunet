package ch15;

import java.net.*;

public class exam109
{

	public static void main(String[] args)
	{
		InetAddress ip = null;
		
		try
		{
			ip = InetAddress.getByName("www.daum.com");
			System.out.println("getHostName(): "+ip.getHostName());
			System.out.println("getHostAddress(): "+ip.getHostAddress());
		}
		catch(UnknownHostException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName(): "+ip.getHostName());
			System.out.println("getHostAddress(): "+ip.getHostAddress());
		}
		catch(UnknownHostException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			ip = InetAddress.getByName("http://eieifemiofmeowfmwe.com/");
			System.out.println("getHostName(): "+ip.getHostName());
			System.out.println("getHostAddress(): "+ip.getHostAddress());
		}
		catch(UnknownHostException e)
		{
			e.printStackTrace();
			System.out.println("에러");
		}
		
		/*
		try
		{
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName(): "+ip.getHostName());
			System.out.println("getHostAddress(): "+ip.getHostAddress());
		}
		catch(UnknownHostException e)
		{
			e.printStackTrace()
		}
		*/
	}

}
