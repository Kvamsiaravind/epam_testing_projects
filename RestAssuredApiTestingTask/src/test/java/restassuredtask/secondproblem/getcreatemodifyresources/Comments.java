package restassuredtask.secondproblem.getcreatemodifyresources;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojoclassesforrestassured.CommentsPojo;

public class Comments {
    private RequestSpecification commentsRequest;
    private Response commentsResponse;
    private CommentsPojo commentsPojo;
    private int statusCode;

    @BeforeTest
    public void setUp(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        commentsRequest =RestAssured.given();
    }

    @Test
    public void testGetComment(){
        commentsResponse=commentsRequest.request(Method.GET,"/comments/1");
        commentsPojo=commentsResponse.as(CommentsPojo.class);
        statusCode=commentsResponse.getStatusCode();
    }

    @Test
    public void testPostComment(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("postId",12);
        jsonObject.put("id",11);
        jsonObject.put("name","gouse");
        jsonObject.put("email","gouse@gmail.com");
        jsonObject.put("body","comment body.");
        commentsResponse=commentsRequest.contentType(ContentType.JSON).body(jsonObject.toString()).request(Method.POST,"/comments/");
        commentsPojo=commentsResponse.as(CommentsPojo.class);
        statusCode=commentsResponse.getStatusCode();
    }

    @Test
    public void testPutComments(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("postId",1);
        jsonObject.put("id",1);
        jsonObject.put("name","gousea");
        jsonObject.put("email","gouse@gmail.com");
        jsonObject.put("body","comment body updated.");
        commentsResponse=commentsRequest.contentType(ContentType.JSON).body(jsonObject.toString()).request(Method.PUT,"/comments/1");
        commentsPojo=commentsResponse.as(CommentsPojo.class);
        statusCode=commentsResponse.getStatusCode();
    }

    @AfterMethod
    public void testVerifyResponse(){
        Assert.assertEquals(commentsResponse.statusCode(),statusCode);
        Assert.assertEquals(commentsPojo.getPostId(),commentsResponse.jsonPath().getInt("postId"));
        Assert.assertEquals(commentsPojo.getId(),commentsResponse.jsonPath().getInt("id"));
        Assert.assertEquals(commentsPojo.getName(),commentsResponse.jsonPath().getString("name"));
        Assert.assertEquals(commentsPojo.getEmail(),commentsResponse.jsonPath().getString("email"));
        Assert.assertEquals(commentsPojo.getBody(),commentsResponse.jsonPath().getString("body"));
    }


}
