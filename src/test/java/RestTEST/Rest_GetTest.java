package RestTEST;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Rest_GetTest {
	@Test
public void GetWeatherDetails() {

given()
.when()
     .get("https://reqres.in/api/users/3")
.then()
     .statusCode(200)
     .statusLine("HTTP/1.1 200 OK")
     .body("first_name",equalTo("Emma"))
     .header("Content-Type","application/json; charset=utf-8").log().all();
     

}
}
