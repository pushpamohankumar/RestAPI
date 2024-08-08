package RestAssuredDemo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.opentelemetry.sdk.logs.data.Body;
import static io.restassured.RestAssured.*;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;


//with out BDD

public class CreateRepo {
	
	@Test(priority=0)
	public void createProjectwithoutBDD() {
		JSONObject obj=new JSONObject();
		obj.put("name", "preethu");
		obj.put("job","Manager");
		
		RequestSpecification req = RestAssured.given();
		req.body(obj);
		req.contentType(ContentType.JSON);
		Response res = req.post("https://reqres.in/api/users");
		Response response = res.prettyPeek();
		System.out.println(response);
		
		int statuscode = res.getStatusCode();
		Assert.assertEquals(201, statuscode);
		
//		String contenttype = res.getContentType();
//		Assert.assertEquals("application/json", contenttype);
		long time = res.getTime();
		System.out.println("Response Time is :"+time);
}
	@Test(priority=1)
	public void getAllUsers() {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		Response response = res.prettyPeek();
		System.out.println(response);
		
		int statuscode = res.getStatusCode();
		Assert.assertEquals(200, statuscode);
		long time = res.getTime();
		System.out.println("Response Time is :"+time);
	}
	@Test(priority=2)
	public void singleuserwithoutBDD() {
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		Response response = res.prettyPeek();
		System.out.println(response);
		
		int statuscode = res.getStatusCode();
		Assert.assertEquals(200,statuscode);
		
		long time = res.getTime();
		System.out.println("Response Time is: "+time);
	}
	
	@Test(priority=3)
	public void patch() {
		JSONObject obj=new JSONObject();
		obj.put("name", "IshuPreethi");
		obj.put("job", "HR Manager-I");
		
		RequestSpecification req = RestAssured.given();
		req.body(obj);
		req.contentType(ContentType.JSON);
		Response res = req.put("https://reqres.in/api/users/2");
		Response response = res.prettyPeek();
		
		System.out.println(response);
		
		int statuscode = res.getStatusCode();
		Assert.assertEquals(200,statuscode);
		
		long time = res.getTime();
		System.out.println("Response Time is: "+time);
		
		String contenttype = res.getContentType();
		System.out.println("Content Type is :"+contenttype);
	}
	
	@Test(priority=4)
	public void update() {
		JSONObject obj=new JSONObject();
		obj.put("name", "kushi");
		obj.put("job", "Automation Tester");
		
		RequestSpecification req = RestAssured.given();
		req.body(obj);
		req.contentType(ContentType.JSON);
		Response res = req.patch("https://reqres.in/api/users/2");
		Response response = res.prettyPeek();
		System.out.println(response);
		
		int statuscode = res.getStatusCode();
		Assert.assertEquals(200, statuscode);
		
		long time = res.getTime();
		System.out.println("Response Time is :"+time);
		
		String contenttype = res.getContentType();
		System.out.println("Content Type is :"+contenttype);
	}
	
	@Test(priority=5)
	public void delete() {
		Response del = RestAssured.delete("https://reqres.in/api/users/2");
		Response response = del.prettyPeek();
		System.out.println(response);
	}
	
	//with BDD
	@Test(priority=6)
	public void createprojectwithBDD() {
		JSONObject obj=new JSONObject();
		obj.put("name", "Heshika Gowda");
		obj.put("job","Manager");
		
		given()
		.contentType(ContentType.JSON)
		.body(obj)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.log().all()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);
		
	}
	@Test(priority=7)
	public void getAllProject() {
		when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.log().all()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON);
	}
	@Test(priority=8)
	public void singleUserwithBDD() {
		when()
		.get("https://reqres.in/api/users/2")
		
		.then()
		.log().all()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON);
		
	}
	
	@Test(priority=8)
	public void deletewithBDD() {
		when()
		.delete("https://reqres.in/api/users/2")
		
		.then()
		.log().all()
		.assertThat().statusCode(204);
		
		
	}
	
	
}

