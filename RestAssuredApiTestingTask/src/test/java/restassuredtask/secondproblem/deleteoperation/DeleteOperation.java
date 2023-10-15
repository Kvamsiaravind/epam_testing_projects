package restassuredtask.secondproblem.deleteoperation;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.equalTo;

public class DeleteOperation {

    private RequestSpecification deleteRequest;
    private Response resourceResponse;
    @BeforeTest
    public void setUp(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        deleteRequest=RestAssured.given();
    }
    @Test
    public void testDeletePost() {
        resourceResponse=deleteRequest.delete("/posts/1");
    }

    @Test
    public void testDeleteComment() {
        resourceResponse=deleteRequest.delete("/comments/1");
    }

    @Test
    public void testDeleteAlbum() {
        resourceResponse=deleteRequest.delete("/albums/1");
    }

    @Test
    public void testDeletePhoto() {
        resourceResponse=deleteRequest.delete("/photos/1");
    }

    @Test
    public void testDeleteTodo() {
        resourceResponse=deleteRequest.delete("/todos/1");
    }

    @Test
    public void testDeleteUser() {
        resourceResponse=deleteRequest.delete("/users/1");
    }

    @AfterMethod
    public void testVerifyStatusCode(){
        Assert.assertEquals(resourceResponse.statusCode(),204);
    }
}
