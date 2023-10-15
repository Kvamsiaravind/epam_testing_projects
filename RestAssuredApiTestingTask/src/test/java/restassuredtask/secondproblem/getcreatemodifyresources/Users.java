package restassuredtask.secondproblem.getcreatemodifyresources;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pojoclassesforrestassured.Address;
import pojoclassesforrestassured.Company;
import pojoclassesforrestassured.Geo;
import pojoclassesforrestassured.UsersPojo;

import static org.hamcrest.Matchers.equalTo;

public class Users {

    private RequestSpecification userRequest;
    private Response userResponse;


    @BeforeTest
    public void setUp(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        userRequest =RestAssured.given();
    }

    @Test
    public void testGetUsers(){
        userResponse=userRequest.request(Method.GET,"/users/1");

        userResponse.then().statusCode(200);
        userResponse.then().assertThat().body("id", equalTo(1));
        userResponse.then().assertThat().body("name", equalTo("Leanne Graham"));
        userResponse.then().assertThat().body("username", equalTo("Bret"));
        userResponse.then().assertThat().body("email", equalTo("Sincere@april.biz"));
        userResponse.then().assertThat().body("address.street", equalTo("Kulas Light"));
        userResponse.then().assertThat().body("address.suite", equalTo("Apt. 556"));
        userResponse.then().assertThat().body("address.city", equalTo("Gwenborough"));
        userResponse.then().assertThat().body("address.zipcode", equalTo("92998-3874"));
        userResponse.then().assertThat().body("address.geo.lat", equalTo("-37.3159"));
        userResponse.then().assertThat().body("address.geo.lng", equalTo("81.1496"));
        userResponse.then().assertThat().body("phone", equalTo("1-770-736-8031 x56442"));
        userResponse.then().assertThat().body("website", equalTo("hildegard.org"));
        userResponse.then().assertThat().body("company.name", equalTo("Romaguera-Crona"));
        userResponse.then().assertThat().body("company.catchPhrase", equalTo("Multi-layered client-server neural-net"));
        userResponse.then().assertThat().body("company.bs", equalTo("harness real-time e-markets"));
    }

    @Test
    public void testPostUsers(){
        UsersPojo usersPojo=new UsersPojo();
        usersPojo.setId(11);
        usersPojo.setName("gouse");
        usersPojo.setUsername("gouseiya");
        usersPojo.setEmail("gouse@epam.com");

        Address address=new Address();
        address.setStreet("chabol");
        address.setCity("nandyal");
        address.setSuite("Apt. 338");
        address.setZipcode("512009");

        Geo geo=new Geo();
        geo.setLng("37");
        geo.setLat("39");
        address.setGeo(geo);
        usersPojo.setAddress(address);
        usersPojo.setPhone("9885914511");
        usersPojo.setWebsite("gouse.org");

        Company company=new Company();
        company.setName("IT");
        company.setCatchPhrase("Multi-layered");
        company.setBs("harness-real-time");
        usersPojo.setCompany(company);

        Response userResponse=userRequest.contentType(ContentType.JSON).body(usersPojo).request(Method.POST,"/users/");
        int statusCode=userResponse.getStatusCode();

        Assert.assertEquals(statusCode,userResponse.statusCode());
        Assert.assertEquals(userResponse.jsonPath().getInt("id"),11);
        Assert.assertEquals(userResponse.jsonPath().getString("name"),"gouse");
        Assert.assertEquals(userResponse.jsonPath().getString("username"),"gouseiya");
        Assert.assertEquals(userResponse.jsonPath().getString("email"),"gouse@epam.com");
        Assert.assertEquals(userResponse.jsonPath().getString("address.street"),"chabol");
        Assert.assertEquals(userResponse.jsonPath().getString("address.suite"),"Apt. 338");
        Assert.assertEquals(userResponse.jsonPath().getString("address.city"),"nandyal");
        Assert.assertEquals(userResponse.jsonPath().getString("address.zipcode"),"512009");
        Assert.assertEquals(userResponse.jsonPath().getString("address.geo.lat"),"39");
        Assert.assertEquals(userResponse.jsonPath().getString("address.geo.lng"),"37");
        Assert.assertEquals(userResponse.jsonPath().getString("phone"),"9885914511");
        Assert.assertEquals(userResponse.jsonPath().getString("website"),"gouse.org");
        Assert.assertEquals(userResponse.jsonPath().getString("company.name"),"IT");
        Assert.assertEquals(userResponse.jsonPath().getString("company.catchPhrase"),"Multi-layered");
        Assert.assertEquals(userResponse.jsonPath().getString("company.bs"),"harness-real-time");
    }


    @Test
    public void testPutUsers(){
        UsersPojo usersPojo=new UsersPojo();
        usersPojo.setId(11);
        usersPojo.setName("gousee");
        usersPojo.setUsername("gousesea");
        usersPojo.setEmail("gouse@epam.com");

        Address address=new Address();
        address.setStreet("chaabol");
        address.setCity("nandyyal");
        address.setSuite("Apt. 338");
        address.setZipcode("512009");

        Geo geo=new Geo();
        geo.setLng("32");
        geo.setLat("40");
        address.setGeo(geo);
        usersPojo.setAddress(address);
        usersPojo.setPhone("9888282111");
        usersPojo.setWebsite("gousee.org");

        Company company=new Company();
        company.setName("IT");
        company.setCatchPhrase("Multi-layered");
        company.setBs("harness-real-time");
        usersPojo.setCompany(company);

        Response userResponse=userRequest.contentType(ContentType.JSON).body(usersPojo).request(Method.PUT,"/users/1");
        int statusCode=userResponse.getStatusCode();
        userResponse.prettyPrint();

        Assert.assertEquals(statusCode,userResponse.statusCode());
        Assert.assertEquals(userResponse.jsonPath().getInt("id"),1);
        Assert.assertEquals(userResponse.jsonPath().getString("name"),"gousee");
        Assert.assertEquals(userResponse.jsonPath().getString("username"),"gousesea");
        Assert.assertEquals(userResponse.jsonPath().getString("email"),"gouse@epam.com");
        Assert.assertEquals(userResponse.jsonPath().getString("address.street"),"chaabol");
        Assert.assertEquals(userResponse.jsonPath().getString("address.suite"),"Apt. 338");
        Assert.assertEquals(userResponse.jsonPath().getString("address.city"),"nandyyal");
        Assert.assertEquals(userResponse.jsonPath().getString("address.zipcode"),"512009");
        Assert.assertEquals(userResponse.jsonPath().getString("address.geo.lat"),"40");
        Assert.assertEquals(userResponse.jsonPath().getString("address.geo.lng"),"32");
        Assert.assertEquals(userResponse.jsonPath().getString("phone"),"9888282111");
        Assert.assertEquals(userResponse.jsonPath().getString("website"),"gousee.org");
        Assert.assertEquals(userResponse.jsonPath().getString("company.name"),"IT");
        Assert.assertEquals(userResponse.jsonPath().getString("company.catchPhrase"),"Multi-layered");
        Assert.assertEquals(userResponse.jsonPath().getString("company.bs"),"harness-real-time");
    }


}
