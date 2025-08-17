package apicode.base1;

import static io.restassured.RestAssured.*;

import apicode.base1.utils.FetchBodyDetails;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRelated extends BaseTest1{

	public static void addDetails() {
		
		Response response=given().contentType(ContentType.JSON).body(FetchBodyDetails.addProduct("Clothes"))
				.when().post("/api/products").then().log().all().statusCode(200).extract().response();
	}
}
