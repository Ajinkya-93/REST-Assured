package RestAPI;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class DemoTests {

	@Test
	public void test_1() {
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
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
