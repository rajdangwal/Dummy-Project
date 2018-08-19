
class Display
{
	public void wish(String name)// declaring synchronized here is inefficient
	{
		;;;;;; //1 lakh lines of code
		synchronized(this)//entire for loop is synchronized
		{
			for(int i=0;i<1000;i++)
			{
				// if we use synchronized here we will get regular output but not all at once
				
				System.out.print("Good Morning: ");
				try
				{
					Thread.sleep(5);

				}
				catch(InterruptedException e)
				{

				}
				System.out.print(name+"\n");
			}
		}
		
		//Hey there this comment is added on a branch
	}
}

class MyThread extends Thread
{
	Display d;
	String name;

	MyThread(Display d, String name)
	{
		this.d = d;
		this.name = name;

	}

	public void run()
	{
		d.wish(name);
	}

}

public class SynchronizedDemo
{
	public static void main(String [] args)
	{
		Display d = new Display();
		MyThread t1 = new MyThread(d,"Raju");
		MyThread t2 = new MyThread(d,"Pawan");

		t1.start();
		t2.start();
	}
}
