package usages;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class MainMeth {
	public static String Json(String r, String s) {
		JsonPath jsonPath = new JsonPath(r);
		String value= jsonPath.get(s).toString();
		return value;}
	
	public static RequestSpecification request() throws FileNotFoundException {
		PrintStream file = new PrintStream(new FileOutputStream("log.txt"));
		RequestSpecification rs= new RequestSpecBuilder().setBaseUri("https://reqres.in/").setBaseUri("https://reqres.in/")
				.setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(file)).addFilter(ResponseLoggingFilter.logResponseTo(file)).build();
		return rs;
	}
	
}
