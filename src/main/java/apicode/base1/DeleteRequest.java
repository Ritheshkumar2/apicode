package apicode.base1;


import static io.restassured.RestAssured.*;

import apicode.base1.utils.FetchBodyDetails;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class DeleteRequest extends BaseTest1{

	
	public static void deleteRequest() {
		
		// Delete "Shoes"
		given()
		.when()
		    .delete("/api/products/Clothes")
		.then()
		    .statusCode(200)
		    .log().all();
	}
}
