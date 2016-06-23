package testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest1 {

	@Test
	@Parameters({ "browser" })
	public void testCaseOne(String browser) {
		System.out.println("browser passed as :- " + browser);
	}
}