package practicetestng;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.equalTo;

public class PatchDemo {
    @Test
    public void testPatchPost(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id",111);
        jsonObject.put("title","title updated using patch");

        Response patchResponse=given()
                .when()
                .body(jsonObject.toString())
                .patch("https://jsonplaceholder.typicode.com/posts/1");
        patchResponse.prettyPrint();
    }



    @Test
    public void testUsePojo(){
        Response pojoResponse=given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1");
        PostsPojo postsPojo=new PostsPojo();
        postsPojo.setBody("Body for pojo");
        postsPojo.setId(131);
        postsPojo.setTitle("title for pojo");
        postsPojo.setUserId(321);
        PostsPojo postsPojo1=pojoResponse.as(PostsPojo.class);
        System.out.println(postsPojo.getTitle());
        pojoResponse.prettyPrint();
    }

    @Test
    public void testCreatePost() throws JsonProcessingException {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id",111);
        jsonObject.put("title","title updated using patch");
        jsonObject.put("body","body updated using patch");
        jsonObject.put("userId",178);

        Response jsonResponse=given().when().contentType("application/json").body(jsonObject.toString())
                .get("https://jsonplaceholder.typicode.com/posts");


        JSONArray jsonArray = new JSONArray(jsonResponse.asPrettyString());


//        for(int i=0;i<jsonArray.length();i++)
//        {
//            Response singleResponse=jsonArray.get(i);
//        }


        ObjectMapper objectMapper = new ObjectMapper();
        PostsPojo[] persons = objectMapper.readValue(jsonResponse.asString(), PostsPojo[].class);
        for(PostsPojo po:persons)
        {

        }


//        jsonResponse.prettyPrint();
//

//        Response patchResponse=given()
//                .when()
//                .body(jsonObject.toString())
//                .patch("https://jsonplaceholder.typicode.com/posts/1");
//        patchResponse.prettyPrint();
    }


    @Test
    public void testBasicAuth(){
        String authBody="{\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"title check\",\n" +
                "    \"body\": \"body check\"\n" +
                "}";
        given()
                .auth()
                .basic("vamsi","vamsi123")

                .contentType(ContentType.JSON)
                .body(authBody)
                .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(201)
                .body("userId",equalTo(1))
                .body("title",equalTo("title check"))
                .body("body",equalTo("body check"));

    }

    @Test
    public void testMultiPart(){
        File file=new File("C:/Users/Vamsi_Kuruva/Documents/File.json");
        Response restResponse=given()
                .multiPart("file",file,"multipart/form-data")
                .post("https://the-internet.herokuapp.com/upload")
                .thenReturn();
        restResponse.prettyPrint();
        restResponse.then().statusCode(200);
    }
}
