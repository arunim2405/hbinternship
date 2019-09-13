package dayNine;

public class Day9 extends Thread {
	static Day9 h= new Day9();
	@Override
	public void run()
	{
		System.out.println("Thread is running"+Thread.currentThread().getName());
		System.out.println("Daemon: "+Thread.currentThread().isDaemon());  
	}

	public static void main(String[] args) {
		try
		{
			h.pro1();
		}catch(InterruptedException e)
		{
			System.out.println(e);  
		}

	}
	public  void pro1() throws InterruptedException
	{
		Day9 t1= new Day9();
		Day9 t2=new Day9();
		
			t1.setDaemon(true);
			t1.start();
			t2.start();
			t1.sleep(35000);
			
			
		
	}
}
