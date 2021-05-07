package tests;

import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.annotations.Test;


public class TestAPI {

    @Test
    public Integer testGetPage() {
        Response responce = get("https://reqres.in/api/users?page=1");
        JsonPath extractor = responce.jsonPath();
        return extractor.get("total_pages");
    }

    @Test
    public void testGetUserOfPagination(){
        String checkUser = null;
        for (int i = 1; i <= testGetPage(); i++) {
        String response = get("https://reqres.in/api/users?page={i}",i).asString();
        checkUser  = from(response).get("data.find{it.first_name=='Michael' && it.last_name=='Lawson' }.email");
    }
        assertThat(checkUser, is("michael.lawson@reqres.in"));
    }

    @Test
    public void testGetUser() {
        Response responce = get("https://reqres.in/api/users");

        given()
                .get("https://reqres.in/api/users")
                .then()
                .body("data.find{it.first_name=='George' && it.last_name=='Bluth'}.email",
                        equalTo("george.bluth@reqres.in" ));
    }


}
