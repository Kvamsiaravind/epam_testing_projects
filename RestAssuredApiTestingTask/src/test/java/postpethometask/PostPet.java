package postpethometask;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojoclassesforpostpet.Category;
import pojoclassesforpostpet.Pet;
import pojoclassesforpostpet.Tags;

import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;
import static org.hamcrest.Matchers.equalTo;

public class PostPet {

    private RequestSpecification petRequest;
    private Response petResponse;



    @BeforeTest
    public void setUp(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
        petRequest=RestAssured.given();

    }
    @Test
    public void testPostPet() {

        Pet pet=new Pet();
        pet.setId(12345);

        Category category=new Category();

        category.setId(1);
        category.setName("dog");
        pet.setCategory(category);

        pet.setName("snoopie");
        pet.setStatus("pending");

        List<String> photoUrls=new ArrayList<>();
        photoUrls.add("string");

        Tags tags=new Tags();
        tags.setId(0);
        tags.setName("string");

        List<Tags> tagsList=new ArrayList<>();
        tagsList.add(tags);

        petResponse  = petRequest.header("Content-Type", "application/json").body(pet).request(Method.POST);
    }

    @Test(dependsOnMethods = "testPostPet")
    public void testValidGetPet() {
        petResponse  = petRequest.request(Method.GET,"/12345");
        Assert.assertEquals(petResponse.statusCode(),200);
        Assert.assertEquals(petResponse.getHeader("Content-Type"),"application/json");
        Assert.assertEquals(petResponse.jsonPath().getString("category.name"),"dog");
        Assert.assertEquals(petResponse.jsonPath().getString("name"),"snoopie");
        Assert.assertEquals(petResponse.jsonPath().getString("status"),"pending");
    }
}



