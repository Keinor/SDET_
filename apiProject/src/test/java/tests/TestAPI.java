package tests;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;


public class TestAPI {

    @Test
    public void testGet() {
        Response responce = get("https://reqres.in/api/users");
       // System.out.println(responce.getBody().asString());
        given()
                .get("https://reqres.in/api/users")
                .then()
                .body("data.find{it.first_name=='George' && it.last_name=='Bluth'}.email",
                        equalTo("george.bluth@reqres.in" ));
    }

    @Test
    public void testGetPagination(){
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .body("data.find{it.first_name=='Michael' && it.last_name=='Lawson'}.email",
                        equalTo("michael.lawson@reqres.in" ));
    }
}
