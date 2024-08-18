package TestsAssured;

import static io.restassured.RestAssured.get;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.response.Response;
import java.util.Map;
import model.BookRequestModel;
import org.junit.jupiter.api.Test;

public class DemoqaTestGroovy extends TestBase {

  @Test
  void successfulGetBooks() {
    Response responce = get("/Books");
    String isbn = responce.path("books[9781593275846].isbn");
    BookRequestModel getParam = new BookRequestModel();
    getParam.setIsbn(isbn);
    Response responseIsbnOneBooks = get("/Book?ISBN=" + getParam.getIsbn());
    String oneIsbn = responseIsbnOneBooks.path("isbn");
    assertEquals(getParam.getIsbn(), oneIsbn);
  }

  @Test
  void successfulGetBooksAutors() {
    Response responce = get("/Books");
    Map<String, ?> book = responce.path("books.find{ it.isbn =9781449325862}");
    System.out.println(book);
    assertEquals(book.get("author"), "Richard E. Silverman");

  }
}
