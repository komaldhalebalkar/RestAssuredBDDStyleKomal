package RestTEST;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

/*1) Verifying Single content in XML Response
2) Verifying Multiple contents in XML Response
3) Verifying all the content in XML response in one go
4) XPath with text() function
5) Find values using XML Path in XML response */

public class Rest_validationofXML {
	
	//1) Verifying Single content in XML Response
	@Test
	public void validate_singleusercontent()
	{
		given()
		.when()
		.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
		//.body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
		.body("CUSTOMER.ID",equalTo("15"))
		.log().all();
	}

	//2) Verifying Multiple content in XML Response
		@Test
		public void validate_multipleusercontent()
		{
			given()
			.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
			.then()
			.body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
			.body("CUSTOMER.ID",equalTo("15"))
			.body("CUSTOMER.LASTNAME",equalTo("Clancy"))
			.body("CUSTOMER.STREET",equalTo("319 Upland Pl."))
			.body("CUSTOMER.CITY",equalTo("Seattle"));
		}
		
		//3) Verifying Multiple content in XML Response in one go
				@Test
				public void validate_multipleusercontentinoneGo()
				{
					given()
					.when()
					.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
					.then()
					.body("CUSTOMER.text()",equalTo("15BillClancy319 Upland Pl.Seattle"));
					
				}
				
				//4) Find values using XML Path in XML response 
				@Test
				public void validate_xmlResponse()
				{
					given()
					.when()
					.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
					.then()
					.body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill")))
					.log().all();
					
				}
				
				//5) Find values using XML Path in XML response 2nd way
				@Test
				public void validate_xmlResponse2ndWay()
				{
					given()
					.when()
					.get("http://thomas-bayer.com/sqlrest/CUSTOMER")
					.then()
					.body(hasXPath("/CUSTOMERList/CUSTOMER[text()='30']"))
					.log().all();
					
				}
}
