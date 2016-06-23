package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	
	@Test(dataProvider = "getData")
	public static void setData(int id , String name){
		System.out.println(" id is :: " + id + " name is :: " + name);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[3][2];
		
		data[0][0] = 1 ;
		data[0][1] = "Sonali";
		
		data[1][0] = 1 ;
		data[1][1] = "Sangita";
		
		data[2][0] = 1 ;
		data[2][1] = "Snehal";
		
		return data;
	}

}
