package ch13;

import java.io.*;

public class exam100
{

	public static void main(String[] args) throws IOException
	{
		FileInputStream fis = null;
		fis = new FileInputStream("prac.txt");
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		FileOutputStream fos = null;
		fos = new FileOutputStream("result.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);		
		
		int data;
		
		while((data = fis.read())!= -1)
		{
			bos.write(data);
		}
		
		bos.close();
		bis.close();
	}

}
