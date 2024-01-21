package RestAPI;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DemoTests {

	@Test
	public void test_1() {
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test
	public void test_2() {
		baseURI = "https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[2].id", equalTo(9)).
		log().all();
	}
}
