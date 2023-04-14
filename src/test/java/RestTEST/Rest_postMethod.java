package RestTEST;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Rest_postMethod {
	//private static Object name = null;
	public static HashMap mp=new HashMap();

	@BeforeClass
public void postdata() {
	//mp.put("name",RestUtils.getName());
	 mp.put("name","komal");
	mp.put("job","QA");
	mp.put("email","abc@gmail.com");
	baseURI="https://reqres.in";
	basePath="/api/users";
	
}
	@Test
public void testData() {
	given()
	    .contentType("application/json")
	    .body(mp)
	.when()
	     .post()
	.then()
	     .statusCode(201)
	     .statusLine("HTTP/1.1 201 Created")
	     .and()
	     .body("name",equalTo("komal"))
	     .and()
	     .header("X-Powered-By","Express").log().all();
}
}
