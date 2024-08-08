package RestAssuredDemo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import java.io.File;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class WaysToPosttheRequest {
@Test
public void createProjectUsingJsonObj() {
	JSONObject obj=new JSONObject();
	obj.put("name","kushi");
	obj.put("job","Automation Tester");
	
	given()
	.body(obj)
	.contentType(ContentType.JSON)
	
	.when()
	.post("https://reqres.in/api/users")
	
	.then()
	.log().all()
	.assertThat().statusCode(201)
	.assertThat().contentType(ContentType.JSON)
	.time(lessThan(1200L));
	
}
@Test
public void createProjectUsingHashMap() {
	HashMap map=new HashMap();
	map.put("name","Heshika");
	map.put("job","Manager");
	
	given()
	.body(map)
	.contentType(ContentType.JSON)
	
	.when()
	.post("https://reqres.in/api/users")
	
	.then()
	.log().all()
	.assertThat().statusCode(201)
	.assertThat().contentType(ContentType.JSON)
	.time(lessThan(1200L));
}
@Test
public void createProjectUsingFile() {
	File f=new File("C:\\Users\\EMPULSE\\eclipse-workspace\\RestAssured\\src\\test\\resources\\Files\\create.json.txt");
	given()
	.body(f)
	.contentType(ContentType.JSON)
	
	.when()
	.post("https://reqres.in/api/users")
	
	.then()
	.log().all()
	.assertThat().statusCode(201)
	.assertThat().contentType(ContentType.JSON)
	.time(lessThan(1500L));
	
}

@Test
public void createprojectusingpojo() {
	
	CreatePojo pojo=new CreatePojo("Ishu","Sr Technical Lead");
	given()
	.body(pojo)
	.contentType(ContentType.JSON)
	
	.when()
	.post("https://reqres.in/api/users")
	
	.then()
	.log().all()
	.assertThat().statusCode(201)
	.assertThat().contentType(ContentType.JSON)
	.time(lessThan(2000L));
	
	
	
}
}
