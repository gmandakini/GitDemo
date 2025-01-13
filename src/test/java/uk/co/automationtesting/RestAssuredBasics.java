package uk.co.automationtesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import resources.payload;
import testResources.ReUsableMethods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredBasics {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String postPlaceResponse = given()
                .log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(payload.AddPlace())
                .when()
                .post("maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

        JsonPath postJS = ReUsableMethods.rawToJson(postPlaceResponse);
        String placeId = postJS.get("place_id");
        String newAddress = "70 Summer walk, USA";
        System.out.println(placeId);

        given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\"place_id\":\""+placeId+"\",\"address\":\""+newAddress+"\",\"key\":\"qaclick123\"}")
            .when().put("maps/api/place/update/json")
    .then().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
    //Add place -> Update Place with New Address -> Get Place to validate if New address is present in response

        String getPlaceResponse = given().log().all()
                .queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200)
                .extract().response().asString();

        JsonPath getJS = ReUsableMethods.rawToJson(getPlaceResponse);
        String actualAddress = getJS.get("address");
        Assert.assertEquals(actualAddress, newAddress);

}
}
