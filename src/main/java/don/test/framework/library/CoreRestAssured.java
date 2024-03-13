package don.test.framework.library;

import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CoreRestAssured {

    public static Response response;
    public static String jsonAsString;
    public static String TOUR_PUBLIC_UUID = "dbe87688-1507-4d19-b10e-ac368062a99b";

    @Parameters({ "configfile" })
    @BeforeSuite(groups = { "abstract_api" })
    public void initFramework(@Optional("src/test/resources/config.properties") String configfile) throws Exception {
        baseURI = "https://api.pivo.dev";
    }

}
