package uk.co.automationtesting;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;

public class ComplexJsonParse {

    JsonPath js;
    int noOfCourses;

    @Test
    public void printEachCourseAndPrice() throws IOException {
        js = new JsonPath(GenerateStringFromResource("src/main/java/resources/CoursePrice.json"));
        noOfCourses = js.getInt("courses.size()");
        for (int i = 0; i < noOfCourses; i++) {
            String firstTitle = js.get("courses[" + i + "].title");
            int firstPrice = js.get("courses[" + i + "].price");
            System.out.println("Course : " + firstTitle + " & Price : " + firstPrice);
        }
    }

        @Test
        public void getRPACopies() throws IOException {
            js = new JsonPath(GenerateStringFromResource("src/main/java/resources/CoursePrice.json"));
            noOfCourses = js.getInt("courses.size()");
            int rpaCopies = 0;
            for (int i = 0; i < noOfCourses; i++) {
                if (js.get("courses[" + i + "].title").equals("RPA")) {
                    rpaCopies = js.get("courses[" + i + "].copies");
                    break;
                }
            }
            System.out.println("RPA Copies = " + rpaCopies);
        }

        @Test
        public void sumOfAllCourses () throws IOException {
            js = new JsonPath(GenerateStringFromResource("src/main/java/resources/CoursePrice.json"));
            noOfCourses = js.getInt("courses.size()");
            int purchaseAmount = js.get("dashboard.purchaseAmount");
            int sumOfAllCourses = 0;
            for (int i = 0; i < noOfCourses; i++) {
                int copies = js.get("courses[" + i + "].copies");
                int price = js.get("courses[" + i + "].price");
                sumOfAllCourses += copies * price;
            }
            System.out.println("Sum of all Courses = " + sumOfAllCourses);
            Assert.assertEquals(purchaseAmount, sumOfAllCourses);
        }

    public static String GenerateStringFromResource(String path) throws IOException {



        return new String(Files.readAllBytes(Paths.get(path)));



    }

}
