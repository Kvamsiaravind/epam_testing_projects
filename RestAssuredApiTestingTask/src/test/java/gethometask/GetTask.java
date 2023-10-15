package gethometask;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class GetTask {
    @Test
    public void testGetTask() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification jsonRequest = RestAssured.given();
        Response jsonResponse = jsonRequest.request(Method.GET, "/users");

        jsonResponse.then().statusCode(200);
        jsonResponse.then().assertThat().body("size()", greaterThan(3));
        jsonResponse.then().assertThat().body("name", hasItem("Ervin Howell"));


        jsonResponse.prettyPrint();
    }
}
