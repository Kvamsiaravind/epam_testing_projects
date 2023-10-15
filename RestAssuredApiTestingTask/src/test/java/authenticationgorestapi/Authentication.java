package authenticationgorestapi;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {

    @Test
    public void testOauthUsingGet() {

        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        RequestSpecification oauthRequest = RestAssured.given();
        oauthRequest
                .auth()
                .oauth2("e0065126ca62160ac404ec4f487725ba3adfe6b9aaad87c0684094d8ddb7f05b")
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200);
    }

    @Test
    public void testOauth2UsingPut() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id",361567);
        jsonObject.put("name","gouseee");
        jsonObject.put("email","gousiy@gmail.com");
        jsonObject.put("status","inactive");
        jsonObject.put("gender","male");

        RequestSpecification todosRequest = RestAssured.given();
        todosRequest
                .auth()
                .oauth2("6f10ef0b69af0ea496991ced290bf21e35509441ebda1fba83644fcbcfc2ebb9")
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .put("https://gorest.co.in/public/v2/users/361567")
                .then()
                .statusCode(200);
    }

    @Test
    public void testOauth2UsingGet() {
        given()
                .auth()
                .oauth2("6f10ef0b69af0ea496991ced290bf21e35509441ebda1fba83644fcbcfc2ebb9")
                .when()
                .get("https://gorest.co.in/public/v2/posts")
                .then()
                .statusCode(200);

    }

    @Test
    public void testOauth2UsingUsers() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id",101);
        jsonObject.put("name","gouse");
        jsonObject.put("email","gouse@gmail.com");
        jsonObject.put("status","active");
        jsonObject.put("gender","female");



        Response response = given()
                .auth()
                .oauth2("35b64a61080c840b5554f6ac0a0e57278f0217563f083ffeae14620a7a962565")
                .contentType(ContentType.JSON)
                .body(jsonObject.toString())
                .when()
                .post("https://gorest.co.in/public/v2/users");
        response.prettyPrint();
        response.then().statusCode(201);
    }
}
