package uk.co.automationtesting;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import pojo.Api;
import pojo.GetCourse;
import pojo.WebAutomation;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientCredentialsOauth {
    public static void main(String[] args) {

        List<String> expectedCourseTitles = List.of(new String[]{"Selenium Webdriver Java", "Cypress", "Protractor"});

// TODO Auto-generated method stub
        RestAssured.baseURI = "https://rahulshettyacademy.com/oauthapi/";

        Map m = new HashMap<>();
        m.put("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com");
        m.put("client_secret", "erZOWM9g3UtwNRj340YYaK_W");
        m.put("grant_type", "client_credentials");
        m.put("scope", "trust");
        String response =
                given().params(m)
                        /*.formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

                        .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

                        .formParams("grant_type", "client_credentials")

                        .formParams("scope", "trust")*/

                        .when().log().all()

                        .post("oauth2/resourceOwner/token").then().extract().response().asString();

        System.out.println(response);

        JsonPath jsonPath = new JsonPath(response);

        String accessToken = jsonPath.get("access_token");

        System.out.println(accessToken);

        GetCourse gc =    given()

                .queryParams("access_token", accessToken)

                .when()

                .get("/getCourseDetails")

                .as(GetCourse.class);

        System.out.println(gc.getInstructor());
        System.out.println(gc.getLinkedIn());
        List<Api> apiCourses = gc.getCourses().getApi();
        List<WebAutomation> webAutomationCourses = gc.getCourses().getWebAutomation();
        List<String> actualCourseTitles = new ArrayList<>();

        for(Api api: apiCourses) {
            if (api.getCourseTitle().contains("SoapUI")) {
                System.out.println("The Course Title : " + api.getCourseTitle());
                System.out.println("The Price for the above course is : £" + api.getPrice());

            }
        }

        for(WebAutomation wa: webAutomationCourses) {
            actualCourseTitles.add(wa.getCourseTitle());
        }

        Assert.assertTrue(actualCourseTitles.equals(expectedCourseTitles));
    }
}
