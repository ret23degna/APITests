package specs;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AccountSpec {

  public static RequestSpecification accountBaseRequestSpec = with()
      .log().uri()
      .log().body()
      .log().headers()
      .contentType(JSON)
      .baseUri("https://demoqa.com");

  public static RequestSpecification accountRequestAuthorizedSpec = with()
      .spec(accountBaseRequestSpec)
      .basePath("/Account/v1/Authorized");
  public static RequestSpecification accountRequestGenerateTokenSpec = with()
      .spec(accountBaseRequestSpec)
      .basePath("/Account/v1/GenerateToken");

  public static ResponseSpecification accountResponceSpec = new ResponseSpecBuilder()
      .expectStatusCode(200)
      .log(STATUS)
      .log(BODY)
      .build();
}