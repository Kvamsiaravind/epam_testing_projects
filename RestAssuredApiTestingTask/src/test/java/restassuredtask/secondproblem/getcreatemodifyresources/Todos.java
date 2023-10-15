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
import pojoclassesforrestassured.TodosPojo;

public class Todos {
    private RequestSpecification todosRequest;
    private Response todosResponse;
    private int statusCode;
    private TodosPojo todosPojo;

    @BeforeTest
    public void setUp(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        todosRequest =RestAssured.given();
    }

    @Test
    public void testGetTodos(){
        todosResponse=todosRequest.request(Method.GET,"/todos/1");
        todosPojo=todosResponse.as(TodosPojo.class);
        statusCode=todosResponse.getStatusCode();
    }

    @Test
    public void testPostTodos(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id",101);
        jsonObject.put("userId",111);
        jsonObject.put("title","Todos title");
        jsonObject.put("completed",false);

        todosResponse=todosRequest.contentType(ContentType.JSON).body(jsonObject.toString()).request(Method.POST,"/todos");
        todosPojo=todosResponse.as(TodosPojo.class);
        statusCode=todosResponse.getStatusCode();
    }

    @Test
    public void testPutTodos(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id",1);
        jsonObject.put("userId",1);
        jsonObject.put("title","Todos title updated");
        jsonObject.put("completed",true);

        todosResponse=todosRequest.contentType(ContentType.JSON).body(jsonObject.toString()).request(Method.PUT,"/todos/1");
        todosPojo=todosResponse.as(TodosPojo.class);
        statusCode=todosResponse.getStatusCode();
    }

    @AfterTest
    public void testVerifyResource(){
        Assert.assertEquals(statusCode,todosResponse.statusCode());
        Assert.assertEquals(todosPojo.getId(),todosResponse.jsonPath().getInt("id"));
        Assert.assertEquals(todosPojo.getUserId(),todosResponse.jsonPath().getInt("userId"));
        Assert.assertEquals(todosPojo.getTitle(),todosResponse.jsonPath().getString("title"));
        Assert.assertEquals(todosPojo.isCompleted(),todosResponse.jsonPath().getBoolean("completed"));

    }
}
