package tests;

import org.testng.annotations.Test;
import static helpers.HelperGet.testGetPage;
import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class TestAPI {

    @Test
    public void testGetUserOfPagination() {
        String checkUser = null;

        for (int i = 1; i <= testGetPage(); i++) {
            String response = given().
                    param("page", i).
                    get("https://reqres.in/api/users?{i}", i).asString();

            checkUser = from(response).get("data.find{it.first_name=='Michael' && it.last_name=='Lawson' }.email");
            if (checkUser != null) {
                break;
            }
        }
        assertThat(checkUser, is("michael.lawson@reqres.in"));
    }

    @Test
    public void testGetUser() {

        given()
                .get("https://reqres.in/api/users")
                .then()
                .body("data.find{it.first_name=='George' && it.last_name=='Bluth'}.email",
                        equalTo("george.bluth@reqres.in"));
    }


}
