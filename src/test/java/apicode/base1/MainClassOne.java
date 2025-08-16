package apicode.base1;

import org.testng.annotations.Test;

public class MainClassOne extends BaseTest1{

	@Test(priority=1)
	public void testGet() {
		GetRequestOne.getProductdetails();
	}
}
