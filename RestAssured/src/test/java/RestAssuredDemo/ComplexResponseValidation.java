
package RestAssuredDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.*;

public class ComplexResponseValidation {
@Test
public void staticResponseValidation() {
	String expectedData="lindsay.ferguson@reqres.in";
	
	Response res = when()
	.get("https://reqres.in/api/users?page=2");
	
	
	Object email = res.jsonPath().get("data[1].email");
	res.then()
	.log().all();
	Assert.assertEquals(email, expectedData);
}
@Test
public void dynamicResponseValidation() {
	String expectedData="lindsay.ferguson@reqres.in";
	Response res = when().get("https://reqres.in/api/users?page=2");
	
	List<String> email = res.jsonPath().get("email");
	for(String list:email)
	{
		if(list.equals(expectedData))
		{
			System.out.println(expectedData);
			break;
		}
	}
	
	
}
}
