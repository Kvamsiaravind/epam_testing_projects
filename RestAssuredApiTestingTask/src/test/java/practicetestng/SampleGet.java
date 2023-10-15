package practicetestng;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SampleGet {
    @Test
    public void testSample() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response httpResponse = httpRequest.request(Method.GET, "/users/1");
        System.out.println(httpResponse.getStatusCode());
        System.out.println(httpResponse.getContentType());
        System.out.println(httpResponse.getBody());
        System.out.println(httpResponse.getStatusLine());
        System.out.println(httpResponse.asPrettyString());
        String s = httpResponse.asString();
        System.out.println(s);
        Map hashMap = httpResponse.as(HashMap.class);
        Iterator iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            System.out.println(key + " --> " + hashMap.get(key));
        }
    }
}
