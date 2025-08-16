package apicode.base1;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseTest1 {
	
	 @BeforeClass
	public void basetestOne() {
		//Get-http://localhost:5000
		
		RestAssured.baseURI="http://localhost:5000";
	}

}
