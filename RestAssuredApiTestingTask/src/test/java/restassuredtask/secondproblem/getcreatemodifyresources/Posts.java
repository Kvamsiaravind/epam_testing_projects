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
import pojoclassesforrestassured.PostsPojo;

import static io.restassured.RestAssured.given;

public class Posts {

    private RequestSpecification postsRequest;
    private Response postsResponse;
    private PostsPojo postsPojoResponse;
    private int statusCode;


    @BeforeTest
    public void setUp(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        postsRequest =RestAssured.given();
    }
    @Test
    public void testGetPosts(){
        postsResponse= postsRequest.request(Method.GET,"/posts/1");
        postsPojoResponse=postsResponse.as(PostsPojo.class);
        statusCode=postsResponse.getStatusCode();
    }

    @Test
    public void testPostPosts(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userId",101);
        jsonObject.put("id",121);
        jsonObject.put("title","post title for posts");
        jsonObject.put("body","post body for posts");
        postsResponse= postsRequest.contentType(ContentType.JSON).body(jsonObject.toString()).request(Method.POST,"/posts/");

        postsPojoResponse=postsResponse.as(PostsPojo.class);
        statusCode=postsResponse.getStatusCode();
    }

    @Test
    public void testPutPosts(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userId",1);
        jsonObject.put("id",101);
        jsonObject.put("title","post title.");
        jsonObject.put("body","post body.");
        postsResponse= postsRequest.contentType(ContentType.JSON).body(jsonObject.toString()).request(Method.PUT,"/posts/1");

        postsPojoResponse=postsResponse.as(PostsPojo.class);
        statusCode=postsResponse.getStatusCode();
    }

    @AfterMethod
    public void testVerifyResourceResponse(){
        Assert.assertEquals(postsResponse.statusCode(),statusCode);
        Assert.assertEquals(postsPojoResponse.getUserId(),postsResponse.jsonPath().getInt("userId"));
        Assert.assertEquals(postsPojoResponse.getId(),postsResponse.jsonPath().getInt("id"));
        Assert.assertEquals(postsPojoResponse.getTitle(),postsResponse.jsonPath().getString("title"));
        Assert.assertEquals(postsPojoResponse.getBody(),postsResponse.jsonPath().getString("body"));
    }

}
