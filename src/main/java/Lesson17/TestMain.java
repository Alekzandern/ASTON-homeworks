package Lesson17;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestMain {
    @Test
    public void WhenGetRequest_statusCode() {
        given().baseUri("https://postman-echo.com").when().get("/get").then().assertThat().statusCode(200);
    }

    @Test
    public void WhenDeleteRequest_status() {
        given().baseUri("https://postman-echo.com").when().delete("/delete").then()
                .assertThat().statusCode(200);
    }

    @Test
    public void WhenDeleteRequest_body() {
        given().baseUri("https://postman-echo.com").body("zzz").when().delete("/delete").then().log().body().and()
                .body("data", equalTo("zzz"));
    }
}


