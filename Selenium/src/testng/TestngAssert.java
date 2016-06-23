package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngAssert {

	@Test
	public static void demo (){
		Assert.assertEquals(10, 11);
	}
}
