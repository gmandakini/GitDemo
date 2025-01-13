package uk.co.automationtesting;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class GraphQLScript {

    public static void main(String[] args) {

        // Graph QL MUTATION
        String newCharacter = "MinnieMouse";
        String mutationResponse = given().log().all().header("Content-Type","application/json")
                .body("{\"query\":\"mutation\\n{\\n  createLocation(location:{name:\\\"Australia\\\", type:\\\"SouthZone\\\",dimension:\\\"234\\\"})\\n  {\\n    id\\n  }\\n  \\n  createCharacter(character:{name:\\\""+newCharacter+"\\\", type:\\\"DisneyCharacter\\\", status:\\\"alive\\\", species:\\\"Fiction\\\", gender:\\\"female\\\",image:\\\"mouse\\\",originId:15768,locationId:15768 })\\n  {\\n    id\\n  }\\n  createEpisode(episode:{name:\\\"Salaame Ishq\\\",air_date:\\\"20NOV2020\\\", episode:\\\"Episode 20\\\"})\\n  {\\n    id\\n  }\\n  deleteLocations(locationIds:[15668,15669,15770])\\n  {\\n    locationsDeleted\\n  }\\n  editLocation(locationId:15772,newLocationData:{name:\\\"Aus\\\", type:\\\"SafeZone\\\", dimension:\\\"345\\\"})\\n  {\\n    status\\n  }\\n  \\n}\",\"variables\":{\"characterId\":8868,\"episodeId\":10532}}")
                .when().post("https://rahulshettyacademy.com/gq/graphql")
                .then().extract().response().asString();

        System.out.println(mutationResponse);
        JsonPath js2 = new JsonPath(mutationResponse);
        String mutCharacterId = js2.getString("data.createCharacter.id");
        System.out.println(mutCharacterId);

        //Graph QL QUERY
        String response = given().log().all().header("Content-Type","application/json")
                .body("{\"query\":\"query($characterId : Int!, $episodeId : Int!) \\n{\\n  \\n  character(characterId:$characterId) {\\n    name\\n    gender\\n    status\\n    id\\n    type\\n    location {\\n      id\\n    }\\n    episodes {\\n      id\\n    }\\n  }\\n  location(locationId:15779)\\n  {\\n    name\\n    dimension\\n    type\\n  }\\n  episode(episodeId:$episodeId)\\n  {\\n    name\\n    air_date\\n    episode\\n  }\\n  characters(filters:{name : \\\"Rahul\\\"})\\n  {\\n    info\\n    {\\n      count\\n    }\\n    result\\n    {\\n      id\\n      name\\n      type\\n    }\\n  }\\n  episodes(filters:{episode:\\\"hulu\\\"})\\n  {\\n    result\\n    {\\n      id\\n      name\\n      air_date\\n      episode\\n    }\\n  }\\n  \\n}\\n\\n\",\"variables\":{\"characterId\":"+mutCharacterId+",\"episodeId\":11668}}")
                .when().post("https://rahulshettyacademy.com/gq/graphql")
                .then().extract().response().asString();

        System.out.println(response);
        JsonPath js = new JsonPath(response);
        String characterName = js.getString("data.character.name");
        System.out.println(characterName);
        Assert.assertEquals(characterName, "MinnieMouse");


    }

}
