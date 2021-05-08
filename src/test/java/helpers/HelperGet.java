package helpers;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.get;

public class HelperGet {
    static public Integer getDataUsers() {
        Response response = get("https://reqres.in/api/users?page=1");
        JsonPath extractor = response.jsonPath();
        return extractor.get("total_pages");
    }
}
