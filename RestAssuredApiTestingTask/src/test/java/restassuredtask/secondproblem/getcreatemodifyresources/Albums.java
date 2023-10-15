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
import pojoclassesforrestassured.AlbumsPojo;


public class Albums {
    private RequestSpecification albumsRequest;
    private Response albumsResponse;
    private AlbumsPojo albumsPojo;
    private int statusCode;

    @BeforeTest
    public void setUp(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        albumsRequest =RestAssured.given();
    }

    @Test
    public void testGetAlbum(){
        albumsResponse=albumsRequest.request(Method.GET,"/albums/1");
        albumsPojo=albumsResponse.as(AlbumsPojo.class);
        statusCode=albumsResponse.getStatusCode();
    }

    @Test
    public void testPostAlbum(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userId",101);
        jsonObject.put("id",101);
        jsonObject.put("title","album title");

        albumsResponse=albumsRequest.contentType(ContentType.JSON).body(jsonObject.toString()).request(Method.POST,"/albums");
        albumsPojo=albumsResponse.as(AlbumsPojo.class);
        statusCode=albumsResponse.getStatusCode();
    }

    @Test
    public void testPutAlbum(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userId",1);
        jsonObject.put("id",2);
        jsonObject.put("title","album title updated");

        albumsResponse=albumsRequest.contentType(ContentType.JSON).body(jsonObject.toString()).request(Method.PUT,"albums/2");
        albumsPojo=albumsResponse.as(AlbumsPojo.class);
        statusCode=albumsResponse.getStatusCode();

    }

    @AfterMethod
    public void testVerifyResponse(){
        Assert.assertEquals(albumsResponse.statusCode(),statusCode);
        Assert.assertEquals(albumsPojo.getUserId(),albumsResponse.jsonPath().getInt("userId"));
        Assert.assertEquals(albumsPojo.getId(),albumsResponse.jsonPath().getInt("id"));
        Assert.assertEquals(albumsPojo.getTitle(),albumsResponse.jsonPath().getString("title"));
    }
}
