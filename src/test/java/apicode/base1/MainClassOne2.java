package apicode.base1;

import org.testng.annotations.Test;

public class MainClassOne2 extends BaseTest1{

	@Test(priority=1)
	public void testPOST() {
		ProductApiTestPost object=new ProductApiTestPost();
		object.getProducts_shouldReturn200_andNonEmptyList();
		object.addProduct_shouldReturn200_andContainMessage();
		object.addProduct_withoutName_shouldReturn400();
		object.deleteProduct_nonExisting_shouldReturn404();
	}
	
}
