package RestAPI;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GetPostDemo {

	@Test
	public void testGet() {
		baseURI = "https://reqres.in";
		given().
			get("/api/users?page=2").
		then().
			statusCode(200).
			body("data[5].last_name", equalTo("Howell")).
			body("data.first_name", hasItems("George","Lindsay")).
			log().all();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPost() {
		baseURI = "https://reqres.in";
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "RestAPI");
		jsonObject.put("job", "Testing");
		
		given().
			header("Content-Type","application/json").
			body(jsonObject.toJSONString()).
		when().
			post("/api/users").
		then(). 
			statusCode(201). 
			log().all();
		
	}
}
