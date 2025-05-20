package ch13;

import java.io.*;

public class exam101
{

	public static void main(String[] args)
	{
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try
		{
			fis = new FileInputStream("prac.txt");
			fos = new FileOutputStream("result2.txt");
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			int data;
			
			while((data = fis.read())!=-1)
			{
				bos.write(data);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bos.close();
				bis.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
