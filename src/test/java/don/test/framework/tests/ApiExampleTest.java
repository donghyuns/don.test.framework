package don.test.framework.tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import don.test.framework.library.CoreRestAssured;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiExampleTest extends CoreRestAssured {
    @Test (groups = { "template_api" })
    public void verifyGetPublicTourAPI() {
        given()
            .log().all()
        .when()
            .get("/tor/p/tours/user/" + TOUR_PUBLIC_UUID)
        .then()
            .assertThat().body("msgCode", equalTo("OK"));
    }

    @Test (groups = { "template_api" })
    public void verifyTourLogin() {
        String pathUrl = "/aun/p/authn/login/";

        HashMap<String, Object> jsonPayload = new HashMap<>();
        jsonPayload.put("email", "");
        jsonPayload.put("password", "");

        // Sending POST request with Rest-Assured
        response =
            given()
                .contentType(ContentType.JSON)
                .body(jsonPayload)
                .log().all()
            .when()
                .post(pathUrl)
            .then()
                .body("msgCode", equalTo("OK"))
                .extract().response();

        //jsonAsString = response.asString();
        String token = response.path("data.tokens.accessToken");
        System.out.println(token);
    }

}
