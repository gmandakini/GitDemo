package resources;

public class payload {

    public static String AddPlace() {
        return """
                        {\r
                          "location": {\r
                            "lat": -38.383494,\r
                            "lng": 33.427362\r
                          },\r
                          "accuracy": 50,\r
                          "name": "Rahul Shetty Academy",\r
                          "phone_number": "(+91) 983 893 3937",\r
                          "address": "29, side layout, cohen 09",\r
                          "types": [\r
                            "shoe park",\r
                            "shop"\r
                          ],\r
                          "website": "http://rahulshettyacademy.com",\r
                          "language": "French-IN"\r
                        }\r
                        """;
    }

    public static String CoursePrice() {
        return "{\n" +
                "\n" +
                "\"dashboard\": {\n" +
                "\n" +
                "\"purchaseAmount\": 910,\n" +
                "\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "\"courses\": [\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\n" +
                "\"price\": 50,\n" +
                "\n" +
                "\"copies\": 6\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Cypress\",\n" +
                "\n" +
                "\"price\": 40,\n" +
                "\n" +
                "\"copies\": 4\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"RPA\",\n" +
                "\n" +
                "\"price\": 45,\n" +
                "\n" +
                "\"copies\": 10\n" +
                "\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}";
    }

    public static String AddBook(String isbn, String aisle) {
        String payload = "{\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}";
        return payload;

    }

    public static String DeleteBook(String Id) {
        return "{\n" +
                "    \"ID\": \""+Id+"\"\n" +
                "}";
    }
}
