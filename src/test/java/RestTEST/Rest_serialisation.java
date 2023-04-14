package RestTEST;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Rest_serialisation {
	public HashMap hm=new HashMap();
	
	@Test
	public void CreatenewUser() {
		hm.put("id", "21");
		hm.put("email","abc@gmail.com");
		hm.put("first_name", "komal");
		hm.put("last_name","patil");
		List<String> arraylist=new ArrayList<String>();
		arraylist.add("java");
		arraylist.add("selenium");
		hm.put("course",arraylist);
		given()
		.contentType(ContentType.JSON)
		.body(hm)
		.when().post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log().all();
		
		
		
	}
@Test
public void getmethod() {
	given()
	.when()
	.get("https://reqres.in/api/users/21")
	.then() 
	.statusCode(200)
	.assertThat()
	.body("last_name",equalTo("patil"));
}
}
