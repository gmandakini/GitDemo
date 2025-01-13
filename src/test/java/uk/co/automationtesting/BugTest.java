package uk.co.automationtesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.File;

import static io.restassured.RestAssured.given;

public class BugTest {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://gmandakini.atlassian.net/";

        String createIssueResponse = given().header("Content-Type","application/json")
                .header("Authorization", "Basic Z21hbmRha2luaUB5YWhvby5jb206QVRBVFQzeEZmR0YwUG5ZMzlCcnlWbnF6Q0FLS19PQnQwOUMzMzMwc2Q3dU9uWUlSbkhvRzBFMUNXbVdpcl9vbTh3VGhvYTF0MUg2X0NfX05wSlkyTUltUUMyTl9XeVVEbHJBbWI3ZTd3VGN3X3VGOFVzUkpnZDNyUWlfaVdNUTAycTVsOXVpSGp6MnZoMng3NDdpN09OR1hzOU1yNF9MVnp6YWxzcFh2bkhGM0xlUXM0bG5TdVVnPTRBQ0Q2MERB")
                .body("{"+
                        "\"fields\": {"+
                        "\"project\":{"+
                        "\"key\": \"SCRUM\""+
                        "},"+
                        "\"summary\": \"Web Elements are not working - automation\","+
                        "\"issuetype\": {"+
                        "\"name\": \"Bug\""+
                        "}"+
                        "}}")
                .log().all()
                .when().post("rest/api/3/issue")
                .then().log().all().assertThat().statusCode(201)
                .extract().response().asString();

        JsonPath js = new JsonPath(createIssueResponse);
        String issueId = js.get("id");
        System.out.println("This is the new Issue Id : " + issueId);

        given()
                .pathParam("key", issueId)
                .header("X-Atlassian-Token","no-check")
                .header("Authorization","Basic Z21hbmRha2luaUB5YWhvby5jb206QVRBVFQzeEZmR0YwUG5ZMzlCcnlWbnF6Q0FLS19PQnQwOUMzMzMwc2Q3dU9uWUlSbkhvRzBFMUNXbVdpcl9vbTh3VGhvYTF0MUg2X0NfX05wSlkyTUltUUMyTl9XeVVEbHJBbWI3ZTd3VGN3X3VGOFVzUkpnZDNyUWlfaVdNUTAycTVsOXVpSGp6MnZoMng3NDdpN09OR1hzOU1yNF9MVnp6YWxzcFh2bkhGM0xlUXM0bG5TdVVnPTRBQ0Q2MERB")
                .multiPart("file",new File("src/main/java/resources/Screenshot 2024-11-10 081549.png"))
                .log().all()
                .post("rest/api/3/issue/{key}/attachments")
                .then().log().all().assertThat().statusCode(200);
    }


}
