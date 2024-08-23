package bodies;

public class Body {
	
public static String userBody() {
		
		String body=("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}");
		return body;
		
	}
public static String updateUserBody() {
	
	String body=("{\r\n"
			+ "    \"name\": \"morpheus\",\r\n"
			+ "    \"job\": \"zion resident\"\r\n"
			+ "}");
	return body;
	
}

}
