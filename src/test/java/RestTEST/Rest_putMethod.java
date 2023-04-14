package RestTEST;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Rest_putMethod {


	//private static Object name = null;
	public static HashMap mp=new HashMap();

	@BeforeClass
public void postdata() {
	//mp.put("name",RestUtils.getName());
	 mp.put("employee_name","komal");
	 mp.put("employee_salary","50000");
	 mp.put("employee_age","30");
	mp.put("job",RestUtils.getJob());
	baseURI="https://reqres.in";
	basePath="/api/users/2";
	
}
	@Test
public void testData() {
	given()
	    .contentType("application/json")
	    .body(mp)
	.when()
	     .put()
	.then()
	     .statusCode(200)
	     .and()
	     .statusLine("HTTP/1.1 200 OK")
	     .and()
	     .body("employee_name",equalTo("komal"))
	     .and()
	     .header("X-Powered-By","Express").log().all();
}
}
