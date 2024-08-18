package TestsAssured;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.AccountSpec.accountRequestAuthorizedSpec;
import static specs.AccountSpec.accountRequestGenerateTokenSpec;
import static specs.AccountSpec.accountResponceSpec;
import static specs.BoockSpec.boockRequestGetBookSpec;
import static specs.BoockSpec.boockResponceSpec;

import model.AccountBodyModel;
import model.AccountResponcesModel;
import model.BookResponcesModel;
import org.junit.jupiter.api.Test;

public class DemoqaTests {

  @Test
  void successfulAuthorized() {
    AccountBodyModel autologin = new AccountBodyModel();
    autologin.setUserName("Krokodile234");
    autologin.setPassword("321qweASD!");
    given()
        .spec(accountRequestAuthorizedSpec)
        .body(autologin)
        .when()
        .post()
        .then()
        .spec(accountResponceSpec);
  }

  @Test
  void successfulGenerateToken() {
    AccountBodyModel autologin = new AccountBodyModel();
    autologin.setUserName("Krokodile234");
    autologin.setPassword("321qweASD!");
    AccountResponcesModel responce = given()
        .spec(accountRequestGenerateTokenSpec)
        .body(autologin)
        .when()
        .post()
        .then()
        .spec(accountResponceSpec)
        .extract().as(AccountResponcesModel.class);
    assertEquals("Success", responce.getStatus());

  }

  @Test
  void successfulGetBook() {
    BookResponcesModel responce = given()
        .spec(boockRequestGetBookSpec)
        .when()
        .get("?ISBN=9781593275846")
        .then()
        .spec(boockResponceSpec)
        .extract().as(BookResponcesModel.class);
    assertEquals("Eloquent JavaScript, Second Edition", responce.getTitle());
    assertEquals("Marijn Haverbeke", responce.getAuthor());
  }

}
