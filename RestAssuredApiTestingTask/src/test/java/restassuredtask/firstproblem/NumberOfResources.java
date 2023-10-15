package restassuredtask.firstproblem;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class NumberOfResources {
    private RequestSpecification countRequest;
    private Response response;
    private int numberOfResources;
    @BeforeTest
    public void setUp(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        countRequest=RestAssured.given();
    }
    @Test
    public void testCountPosts() {
        response=countRequest.request(Method.GET,"/posts");
        numberOfResources = response.jsonPath().getList("$").size();
        Assert.assertEquals(numberOfResources,100);

//        System.out.println("Total posts count :" + numberOfResources);
    }

    @Test
    public void testCountComments() {
        response=countRequest.request(Method.GET,"/comments");
        numberOfResources = response.jsonPath().getList("$").size();
        Assert.assertEquals(numberOfResources,500);

//        System.out.println("Total comments count :" + numberOfResources);
    }

    @Test
    public void testCountAlbums() {
        response=countRequest.request(Method.GET,"/albums");
        numberOfResources = response.jsonPath().getList("$").size();
        Assert.assertEquals(numberOfResources,100);

//        System.out.println("Total albums count :" + numberOfResources);
    }

    @Test
    public void testCountPhotos() {
        response=countRequest.request(Method.GET,"/photos");
        numberOfResources = response.jsonPath().getList("$").size();
        Assert.assertEquals(numberOfResources,5000);

//        System.out.println("Total photos count :" + numberOfResources);
    }

    @Test
    public void testCountTodos() {
        response=countRequest.request(Method.GET,"/todos");
        numberOfResources = response.jsonPath().getList("$").size();
        Assert.assertEquals(numberOfResources,200);

//        System.out.println("Total todos count :" + numberOfResources);
    }

    @Test
    public void testCountUsers() {
        response=countRequest.request(Method.GET,"/users");
        numberOfResources = response.jsonPath().getList("$").size();
        Assert.assertEquals(numberOfResources,10);

//        System.out.println("Total users count :" + numberOfResources);

    }


}
