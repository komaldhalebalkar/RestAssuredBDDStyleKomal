package RestTEST;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

//import static io.restassured.response.Response.*;

public class Rest_DeleteMethod {
	@Test
public void testData() {
		baseURI="https://reqres.in";
		basePath="/api/users/2";
	//Response res=
		given()

	.when()
	     .delete()
	.then()
	     .statusCode(204)
	     .and()
	     .statusLine("HTTP/1.1 204 No Content")
	    .log().all()
	    .extract().response();
	//String jsonasString=res.asString();
	//Assert.assertEquals(jsonasString, null);
}
}


