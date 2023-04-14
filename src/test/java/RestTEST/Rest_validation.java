package RestTEST;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
public class Rest_validation {
	
	//1)test status code
@Test(priority=0)
public void validate_Statuscode() {
	given()
	.when()
	.get("https://reqres.in/api/users")
	.then()
	.statusCode(200);
	//.log().all();
}

//2) test log response
@Test(priority=1)
public void validate_logging() {
	given()
	.when()
	.get("https://reqres.in/api/users/2")
	.then()
	.statusCode(200)
	.log().all();
}
//3) find single user content in response body
@Test(priority=2)
public void validate_SingleUsercontent() {
	given()
	.when()
	.get("https://reqres.in/api/users")
	.then()
	.statusCode(200)
	.body("data[2].first_name",equalTo("Emma"));
}

@Test(priority=3)
public void validate_MultipleUsercontent() {
	given()
	.when()
	.get("https://reqres.in/api/users")
	.then()
	.statusCode(200)
	.body("data.first_name",hasItems("Janet","George","Eve"));
}


@Test(priority=4)
public void validate_ParamAndHeader() {
	given()
	.param("name","komal")
	.header("Server","cloudflare")

	.when()
	.get("https://reqres.in/api/users")
	.then()
	.statusCode(200)
	.log().all();
}

}
