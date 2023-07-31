package com.navigation.system.navigation;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;


@SpringBootTest
public class EndpointTests {

    private final String baseURI = "http://localhost:8080";

    @Test
    public void callingScanReturnsCorrectStatusCode(){

        given().get(baseURI+"/scan").then().statusCode(200).log().all();
    }

    @Test
    public void callingLocationWithCorrectIdReturnsCorrectStatusCode(){

        given().get(baseURI+"/location?id=1").then().statusCode(200).log().all();
    }

    @Test
    public void callingLocationWithIncorrectIdReturnsErrorCode(){

        given().get(baseURI+"/location?id=999").then().statusCode(404).log().all();
    }

    @Test
    public void callingLocationWithoutIdReturnsErrorCode(){

        given().get(baseURI+"/location").then().statusCode(400).log().all();
    }

    @Test
    public void callingReportsReturnsCorrectStatusCode(){

        given().get(baseURI+"/reports").then().statusCode(200).log().all();
    }

}
