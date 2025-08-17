package apicode.base1;

import org.testng.annotations.Test;

public class MainClassOne extends BaseTest1{

	@Test(priority=2)
	public void testGet() {
		GetRequestOne.getProductdetails();
	}
	
	@Test(priority=1)
	public void testPost() {
		PostRelated.addDetails();
		
	}
	@Test(priority=3)
	public void testdelete() {
		DeleteRequest.deleteRequest();
		
	}
	
	@Test(priority=4)
	public void testPut() {
		PutERequestRealted.putrquestRelated();
	}
	
	
}
