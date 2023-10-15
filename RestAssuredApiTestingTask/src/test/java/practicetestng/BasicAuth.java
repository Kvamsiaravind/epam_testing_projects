package practicetestng;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class BasicAuth {
    @Test
    public void testBasicAuth() {
        RequestSpecification basicRequest = RestAssured.given();
        basicRequest.auth()
                .preemptive()
                .basic("vamsi", "vamsi123")
                .when()
                .get("https://gorest.co.in/public/v2/users/1291/posts")
                .then()
                .statusCode(200);

    }
}
