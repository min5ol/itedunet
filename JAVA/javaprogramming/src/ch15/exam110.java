package ch15;

import java.net.*;
import java.io.*;

public class exam110
{

	public static void main(String[] args)
	{
		ServerSocket serverSocket = null;
		try
		{
			serverSocket = new ServerSocket(8000);
			System.out.println("서버가 준비되었습니다.");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		while(true)
		{
			try
			{
				System.out.println("연결 요청을 기다리는 중 ...");
				
				Socket socket = serverSocket.accept();
				System.out.println((socket.getInetAddress()+"연결 요청이 들어왔습니다."));
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				dos.writeUTF("TEST 확인");
				System.out.println("메세지를 전송합니다.");
				dos.close();
				socket.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
