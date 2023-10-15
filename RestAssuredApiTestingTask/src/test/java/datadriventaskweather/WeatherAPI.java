package datadriventaskweather;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class WeatherAPI {
    @Test
    public void testWeatherApi() {
        Response coordinatesResponse = given().when()
                .get("http://api.openweathermap.org/data/2.5/weather?q=hyderabad&appid=80148a27fa7ad3e7f13e3061c307f5a2");


        float longitude = coordinatesResponse.jsonPath().get("coord.lon");
        float latitude = coordinatesResponse.jsonPath().get("coord.lat");

//        System.out.println(latitude+" "+longitude);

        Response weatherResponse = given().when()
                .get("http://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=80148a27fa7ad3e7f13e3061c307f5a2");


        weatherResponse.then().assertThat().body("name", equalTo("Hyderabad"));
        weatherResponse.then().assertThat().body("sys.country", equalTo("IN"));
        weatherResponse.then().assertThat().body("main.temp_min", greaterThan(0.0f));
        weatherResponse.then().assertThat().body("main.temp", greaterThan(0.0f));


//        weatherResponse.prettyPrint();
    }
}
