package restassuredtask.secondproblem.getcreatemodifyresources;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojoclassesforrestassured.PhotoPojo;

public class Photos {
    private RequestSpecification photoRequest;
    private Response photoResponse;
    private PhotoPojo photoPojo;
    private int statusCode;

    @BeforeTest
    public void setUp(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        photoRequest =RestAssured.given();
    }

    @Test
    public void testGetPhotos(){
        photoResponse=photoRequest.request(Method.GET,"/photos/1");
        photoPojo=photoResponse.as(PhotoPojo.class);
        statusCode=photoResponse.getStatusCode();
    }

    @Test
    public void testPostPhotos(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("albumId",101);
        jsonObject.put("id",101);
        jsonObject.put("title","Photo title");
        jsonObject.put("url","https://dummyurl.com");
        jsonObject.put("thumbnailUrl","https://dummythumbnailUrl.com");

        photoResponse=photoRequest.contentType(ContentType.JSON).body(jsonObject.toString()).request(Method.POST,"/photos/");
        photoPojo=photoResponse.as(PhotoPojo.class);
        statusCode=photoResponse.getStatusCode();
    }

    @Test
    public void testPutPhoto(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("albumId",1);
        jsonObject.put("id",1);
        jsonObject.put("title","Photo title updated");
        jsonObject.put("url","https://dummyurl.com");
        jsonObject.put("thumbnailUrl","https://dummythumbnailUrl.com");

        photoResponse=photoRequest.contentType(ContentType.JSON).body(jsonObject.toString()).request(Method.PUT,"/photos/1");
        photoPojo=photoResponse.as(PhotoPojo.class);
        statusCode=photoResponse.getStatusCode();
    }

    @AfterTest
    public void testVerifyResource(){
        Assert.assertEquals(photoResponse.statusCode(),statusCode);
        Assert.assertEquals(photoPojo.getAlbumId(),photoResponse.jsonPath().getInt("albumId"));
        Assert.assertEquals(photoPojo.getId(),photoResponse.jsonPath().getInt("id"));
        Assert.assertEquals(photoPojo.getTitle(),photoResponse.jsonPath().getString("title"));
        Assert.assertEquals(photoPojo.getUrl(),photoResponse.jsonPath().getString("url"));
        Assert.assertEquals(photoPojo.getThumbnailUrl(),photoResponse.jsonPath().getString("thumbnailUrl"));

    }

}
