package parameterizedtask;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Parameterization {

    private RequestSpecification userRequest;
    private Response userResponse;
    @BeforeTest
    public void setUp(){
        RestAssured.baseURI="https://gorest.co.in/public/v2";
        userRequest=RestAssured.given();
    }
    @Test
    void testGetPostCount() {

        userResponse=userRequest
                .auth()
                .oauth2("f976c39b7914ce2ceb09cf19627ea618fc6c01aeabc4eb22f2148d504c17bffa")
                .get("/posts");
        Assert.assertEquals(userResponse.jsonPath().getList("$").size(),10);
        userResponse.then().statusCode(200)
                .header("Content-type", "application/json; charset=utf-8")
                .header("content-Encoding", "gzip")
                .statusLine("HTTP/1.1 200 OK");
        userResponse.prettyPrint();
    }

    @Test
    public void testCreatePost() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", 9986);
        jsonObject.put("name","gouse");
        jsonObject.put("email", "gousiyaabegum@gmail.com");
        jsonObject.put("gender", "male");
        jsonObject.put("status", "active");

        userResponse=userRequest
                .auth()
                .oauth2("f976c39b7914ce2ceb09cf19627ea618fc6c01aeabc4eb22f2148d504c17bffa")
                .contentType(ContentType.JSON)
                .header("content-Encoding","gzip")
                .body(jsonObject.toString())
                .post("/users");
        userResponse.prettyPrint();
        userResponse.then()
                .statusCode(201)
                .header("Content-type", "application/json; charset=utf-8")
                .statusLine("HTTP/1.1 201 Created");
        String contentEncoding = userResponse.getHeader("content-Encoding");
        Assert.assertEquals("gzip", contentEncoding);

    }

    @Test(priority = 1)
    public void testCountAfterPost() {

        Response userResponse=userRequest
                .auth()
                .oauth2("f976c39b7914ce2ceb09cf19627ea618fc6c01aeabc4eb22f2148d504c17bffa")
                .get("/posts");
        Assert.assertEquals(userResponse.jsonPath().getList("$").size(),10);
        userResponse.then().statusCode(200)
                .header("Content-type", "application/json; charset=utf-8")
                .header("content-Encoding", "gzip")
                .statusLine("HTTP/1.1 200 OK");
        userResponse.prettyPrint();
    }

    @Test(priority = 2)
    public void testCreatedResponse() {

        userResponse= userRequest
                .auth()
                .oauth2("f976c39b7914ce2ceb09cf19627ea618fc6c01aeabc4eb22f2148d504c17bffa")
                .get("/users/387390" );
        userResponse.prettyPrint();
        userResponse.then()
                .assertThat()
                .body("id",equalTo(387390))
                .body("name", equalTo("gouse"))
                .body("email", equalTo("gousiyaabegum@gmail.com"))
                .body("gender", equalTo("male"))
                .body("status", equalTo("active"))
                .statusCode(200)
                .header("Content-type", "application/json; charset=utf-8")
                .header("content-Encoding", "gzip")
                .statusLine("HTTP/1.1 200 OK");
    }

    @Test(priority = 3)
    public void testUpdateUser() {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("name", "gousia");
        jsonObject.put("gender", "female");
        jsonObject.put("email", "gousiyacutie@gmail.com");
        jsonObject.put("status", "inactive");
        String token = "f976c39b7914ce2ceb09cf19627ea618fc6c01aeabc4eb22f2148d504c17bffa";
        userResponse=userRequest
                .auth()
                .oauth2("f976c39b7914ce2ceb09cf19627ea618fc6c01aeabc4eb22f2148d504c17bffa")
                .body(jsonObject.toString())
                .header("Content-type", "application/json")
                .when()
                .put("/users/387390");
        userResponse.then()
                .statusCode(200)
                .header("Content-type", "application/json; charset=utf-8")
                .header("content-Encoding", "gzip")
                .statusLine("HTTP/1.1 200 OK");
    }

    @Test(priority = 4)
    public void verifyUpdatedUser() {
        String bearerToken = "f976c39b7914ce2ceb09cf19627ea618fc6c01aeabc4eb22f2148d504c17bffa";
        userResponse = userRequest
                .auth()
                .oauth2("f976c39b7914ce2ceb09cf19627ea618fc6c01aeabc4eb22f2148d504c17bffa")
                .when()
                .get("/users/387390");
        userResponse.then()
                .assertThat()
                .body("name", equalTo("gousia"))
                .body("email", equalTo("gousiyacutie@gmail.com"))
                .body("status", equalTo("inactive"))
                .body("gender", equalTo("male"))
                .statusCode(200)
                .header("Content-type", "application/json; charset=utf-8")
                .header("content-Encoding", "gzip")
                .statusLine("HTTP/1.1 200 OK");
    }

    @Test(priority = 5)
    public void testDeleteUser() {
        userResponse=userRequest
                .auth()
                .oauth2("f976c39b7914ce2ceb09cf19627ea618fc6c01aeabc4eb22f2148d504c17bffa")
                .delete("/users/387390");
        userResponse.then()
                .statusCode(204)
                .statusLine("HTTP/1.1 204 No Content");
    }
}