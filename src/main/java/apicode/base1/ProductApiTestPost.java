package apicode.base1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ProductApiTestPost {
	
	
	

		    @Test
		    public void getProducts_shouldReturn200_andNonEmptyList() {
		        given()
		        .when()
		            .get("/api/products")
		        .then()
		            .statusCode(200)
		            .body("size()", greaterThan(0));
		    }

		    @Test
		    public void addProduct_shouldReturn200_andContainMessage() {
		        given()
		            .contentType(ContentType.JSON)
		            .body("{\"name\":\"Shoes\"}")
		        .when()
		            .post("/api/products")
		        .then()
		            .statusCode(200)
		            .body("message", containsString("added successfully"))
		            .body("products", hasItem("Shoes"));
		    }

		    @Test
		    public void addProduct_withoutName_shouldReturn400() {
		        given()
		            .contentType(ContentType.JSON)
		            .body("{}")
		        .when()
		            .post("/api/products")
		        .then()
		            .statusCode(400)
		            .body("error", equalTo("Product name is required"));
		    }

		    @Test
		    public void deleteProduct_nonExisting_shouldReturn404() {
		        given()
		        .when()
		            .delete("/api/products/DOES_NOT_EXIST")
		        .then()
		            .statusCode(404)
		            .body("error", containsString("not found"));
		    }
}
