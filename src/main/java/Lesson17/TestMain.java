package Lesson17;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestMain {
    @Test
    public void WhenGetRequest_statusCode() {
        given().baseUri("https://postman-echo.com").when().get("/get").then().assertThat().statusCode(200);
    }

    @Test
    public void WhenGetRequestWithTextBody_statusCode() {
        given().baseUri("https://postman-echo.com").contentType(ContentType.TEXT).body("text").when().get("/get").then().assertThat().statusCode(200);
    }

    @Test
    public void WhenDeleteRequest_status() {
        given().baseUri("https://postman-echo.com").when().delete("/delete").then()
                .assertThat().statusCode(200);
    }

    @Test
    public void WhenPostRequestWithTextBody_statusCode() {
        given().baseUri("https://postman-echo.com").contentType(ContentType.TEXT).body("text").when().post("/post").then().assertThat().statusCode(200);
    }

    @Test
    public void WhenPostRequestWithTextBody_body() {
        given().baseUri("https://postman-echo.com").contentType(ContentType.TEXT).body("text").when().post("/post").then().log().body().and().body("data", equalTo("text"));
    }

    @Test
    public void WhenPostRequestWithFormData_statusCode() {
        given().baseUri("https://postman-echo.com").contentType(ContentType.URLENC).formParam("key", "value").when().post("/post").then().assertThat().statusCode(500);
    }

    @Test
    public void WhenPostRequestWithFormData_body() {
        given().baseUri("https://postman-echo.com").contentType(ContentType.URLENC).formParam("key", "value").when().post("/post").then().log().body().and().body("data", equalTo("key=value"));
    }

    @Test
    public void WhenPutRequest_statusCode() {
        given().baseUri("https://postman-echo.com").when().put("/put").then().assertThat().statusCode(200);
    }

    @Test
    public void WhenPutRequest_body() {
        given().baseUri("https://postman-echo.com")
                .contentType(ContentType.JSON)
                .body("{\"key\": \"value\"}")
                .when().put("/put").then().log().body().and().body("key", equalTo("value"));
    }

    @Test
    public void WhenDeleteRequest_body() {
        given().baseUri("https://postman-echo.com").body("zzz").when().delete("/delete").then().log().body().and()
                .body("data", equalTo("zzz"));
    }
}


