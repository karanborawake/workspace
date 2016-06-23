package pom;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Driver {
	static WebDriver driver;
	static int reportFlag = 0;
	@Test
	public void TestCaseSuit() throws Exception {
		String dtTablePath = "/Users/sonali/Desktop/TestCasePom.xls";	
		String[][] recData = ReusableMethod.readXlSheet(dtTablePath , "Sheet1");
		//ITestResult result = null;
		for (int i = 1; i <= recData.length; i++) {
			if(recData[i][1].equalsIgnoreCase("Y")) {
				reportFlag = 0;
				String testCase = recData[i][2];
				ReusableMethod.startReport(testCase, "/Users/sonali/workspace/Logs/");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				
				Method testScript = AutomationScript.class.getMethod(testCase);
				testScript.invoke(testScript);
				
				ReusableMethod.bw.close();
				driver.quit();
				
				if(reportFlag == 0){
					ReusableMethod.writeXlSheet(dtTablePath, "Sheet1", i, 3, "Pass");
				}else{
					ReusableMethod.writeXlSheet(dtTablePath, "Sheet1", i, 3, "Fail");
				}
				
			}else {
				System.out.println("In row number "+ i + " test case " + recData[i][2]+ " is not executed");
			}
			
		}

	}

}
