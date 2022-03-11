package Practice_Scripts;

import org.testng.annotations.Test;

public class SingleTon

{
	
	@Test
	public void sample() 
	{
		System.out.println("Sample");
	}
		public void Demo()
		{
			System.out.println("Demo");
		}
		private SingleTon()
		{
			System.out.println("Constructor Executed");
		}
		public static SingleTon objectSingleton() 
		{
			SingleTon singleTon=new SingleTon();
			return singleTon;
		}
	}

