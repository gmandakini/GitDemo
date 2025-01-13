package uk.co.automationtesting;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.payload;
import testResources.ReUsableMethods;

import static io.restassured.RestAssured.given;


public class DynamicJson {

    @Test(dataProvider = "getData")
    public void addDeleteBook(String isbn, String aisle) {
       RestAssured.baseURI = "http://216.10.245.166";
       String addResponse = given().header("Content-Type", "application/json")
                .body(payload.AddBook(isbn, aisle))
                .when().post("/Library/Addbook.php")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js = ReUsableMethods.rawToJson(addResponse);
        Assert.assertEquals(js.get("Msg"), "successfully added");
        String bookId = js.get("ID");
        System.out.println("The Book ID added is : " + bookId);

        String deleteResponse = given().header("Content-Type", "application/json")
                .body(payload.DeleteBook(bookId))
                .when().post("/Library/DeleteBook.php")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        js = ReUsableMethods.rawToJson(deleteResponse);
        Assert.assertEquals(js.get("msg"), "book is successfully deleted");
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][] {{"efghi","787"}, {"fghij","898"}, {"ghijk","090"}};
    }
}
