package practice_testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
@Test(dataProvider="City")
public void travel(String src,String dest,String stop) 
{
	System.out.println(src+" "+dest+" "+stop);
	}

@DataProvider
public Object[] [] City() 
{
Object arr[][]=new Object[4][3];
arr[0][0]="hyderabad";
arr[0][1]="vijayawada";
arr[0][2]="Suryapet";

arr[1][0]="Hyderabad";
arr[1][1]="Vizag";
arr[1][2]="rajamundry";

arr[2][0]="Hyderabad";
arr[2][1]="Bangalore";
arr[2][2]="Kurnool";

arr[3][0]="Hyderabad";
arr[3][1]="Bangalore";
arr[3][2]="Kurnool";

return arr;




		
}
}
