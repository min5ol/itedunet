package ch12;

class SleepThread extends Thread
{
	public void run()
	{
		System.out.println("카운트다운 10초");
		for(int i=10;i>=0;i--)
		{
			System.out.println(i);
			if(i!=0)
			{
				try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException ie)
				{
					System.out.println(ie.toString());
				}
			}
		}
		System.out.println("종료");
	}
}

public class exam95
{

	public static void main(String[] args)
	{
		SleepThread t = new SleepThread();
		t.start();
	}

}
