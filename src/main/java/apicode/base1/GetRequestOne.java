package apicode.base1;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequestOne extends BaseTest1{
	
	public static void getProductdetails() {
		
		Response response=given().contentType(ContentType.JSON).
				when().get("/api/products").then().log().all().statusCode(200).extract().response();
		
		System.out.print(response.toString());
		
		System.out.println("-----------------------");
		
		// Convert response body to JSON
		String jsonString = response.asString();
		JsonPath js = new JsonPath(jsonString);

		// Get array size
		//The $ symbol is from JsonPath syntax, and it represents the root element of the JSON document. 	
		//js.getList("$") → returns the whole array ["Laptop", "Mobile", "T-Shirt"]
		int size = js.getList("$").size();
		System.out.println("Total products: " + size);

		// Get first product
		String firstProduct = js.getString("[0]");
		System.out.println("First product: " + firstProduct);

		// Get second product
		String secondProduct = js.getString("[1]");
		System.out.println("Second product: " + secondProduct);
	}

}
