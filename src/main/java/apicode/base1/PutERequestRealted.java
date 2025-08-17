package apicode.base1;

import static io.restassured.RestAssured.*;

import apicode.base1.utils.FetchBodyDetails;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutERequestRealted extends BaseTest1{
	
	public static void putrquestRelated() {
		
		System.out.println("Add Product Request: " + FetchBodyDetails.addProduct("Mobile"));
		


		// Step 2: Update "Mobile" -> "smartPhone"
		given()
		    .contentType(ContentType.JSON)
		    .body(FetchBodyDetails.updatename("smartPhone"))
		.when()
		    .put("/api/products/Mobile")
		.then()
		    .statusCode(200)
		    .log().all();
		
		System.out.println("Update Product Request: " + FetchBodyDetails.updatename("smartPhone"));
	}

}
