package RestAPI;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDeleteDemo {

	@SuppressWarnings("unchecked")
	@Test
	public void testPut() {
		baseURI = "https://reqres.in";
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "RestAPI");
		jsonObject.put("job", "Testing");
		
		given().
			header("Content-Type","application/json").
			body(jsonObject.toJSONString()).
		when().
			put("/api/users/2").
		then(). 
			statusCode(200). 
			log().all();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPatch() {
		baseURI = "https://reqres.in";
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "RestAPI");
		jsonObject.put("job", "Testing");
		
		given().
			header("Content-Type","application/json").
			body(jsonObject.toJSONString()).
		when().
			patch("/api/users/2").
		then(). 
			statusCode(200). 
			log().all();
	}
	
	@Test
	public void testDelete() {
		baseURI = "https://reqres.in";
		
		when().
			delete("/api/users/2").
		then().
			statusCode(204).
			log().all();
	}
}
