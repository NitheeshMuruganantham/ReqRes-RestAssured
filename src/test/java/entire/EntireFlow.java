package entire;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import usages.MainMeth;

import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import bodies.Body;
public class EntireFlow {
	
	
	
@Test
	public void getListUsers() throws FileNotFoundException {
		String result=given().spec(MainMeth.request()).queryParam("page", 2).when().get("/api/users"). then().extract().response().asString();
		Assert.assertEquals(MainMeth.Json(result, "total"), "12");
		Assert.assertEquals(MainMeth.Json(result, "data[0].email"), "michael.lawson@reqres.in");
		}
@Test
public void getUser() throws FileNotFoundException {
	String result=given().spec(MainMeth.request()).when().get("/api/users/2"). then().extract().response().asString();
	Assert.assertEquals(MainMeth.Json(result, "data.id"), "2");
	Assert.assertEquals(MainMeth.Json(result, "data.email"), "janet.weaver@reqres.in");
	}

@Test
public void createUser()  throws FileNotFoundException{
	String result=given().spec(MainMeth.request()).body(Body.userBody()).when().post("/api/users"). then().extract().response().asString();
	Assert.assertEquals(MainMeth.Json(result, "name"), "morpheus");
	Assert.assertEquals(MainMeth.Json(result, "job"), "leader");
	}

@Test
public void updateUser() throws FileNotFoundException{
	String result=given().spec(MainMeth.request()).body(Body.updateUserBody()).when().put("/api/users/2"). then().extract().response().asString();
	Assert.assertEquals(MainMeth.Json(result, "name"), "morpheus");
	}







}
