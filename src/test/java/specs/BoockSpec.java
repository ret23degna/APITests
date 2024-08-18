package specs;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BoockSpec {

  public static RequestSpecification boockBaseRequestSpec = with()
      .log().uri()
      .log().body()
      .log().headers()
      .contentType(JSON)
      .baseUri("https://demoqa.com");


  public static RequestSpecification boockRequestGetBookSpec = with()
      .spec(boockBaseRequestSpec)
      .basePath("/BookStore/v1/Book");


  public static RequestSpecification boockRequestGetBooksSpec = with()
      .spec(boockBaseRequestSpec)
      .basePath("/BookStore/v1/Books");

  public static ResponseSpecification boockResponceSpec = new ResponseSpecBuilder()
      .expectStatusCode(200)
      .log(STATUS)
      .log(BODY)
      .build();
}