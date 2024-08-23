package cucumberStepDef;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;

import org.testng.Assert;

import bodies.Body;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import usages.MainMeth;

public class stepDef1 {

	@Given("Taking all the Users from Server")
	public void taking_all_the_users_from_server() throws FileNotFoundException {
		String result=given().spec(MainMeth.request()).queryParam("page", 2).when().get("/api/users"). then().extract().response().asString();
		Assert.assertEquals(MainMeth.Json(result, "total"), "12");
		Assert.assertEquals(MainMeth.Json(result, "data[0].email"), "michael.lawson@reqres.in");
		String result2=given().spec(MainMeth.request()).when().get("/api/users/2"). then().extract().response().asString();
		Assert.assertEquals(MainMeth.Json(result2, "data.id"), "2");
		Assert.assertEquals(MainMeth.Json(result2, "data.email"), "janet.weaver@reqres.in");
	}


@When("Creating the Request and checking the Response whether its having {string} and {string}")
public void creating_the_request_and_checking_the_response_whether_its_having_and(String a, String b)throws FileNotFoundException {
		String result=given().spec(MainMeth.request()).body(Body.userBody()).when().post("/api/users"). then().extract().response().asString();
		Assert.assertEquals(MainMeth.Json(result, "name"), a);
		Assert.assertEquals(MainMeth.Json(result, "job"), b);
	}

	@Then("Updating the request and checking that {string}")
	public void updating_the_request_and_checking_that(String c) throws FileNotFoundException {
		String result=given().spec(MainMeth.request()).body(Body.updateUserBody()).when().put("/api/users/2"). then().extract().response().asString();
		Assert.assertEquals(MainMeth.Json(result, "name"), c);
	}



}
