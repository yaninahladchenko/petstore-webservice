package endpoint;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class BaseEndpoint {

    protected RequestSpecification given() {
        return SerenityRest.given()
                .log().uri()
                .log().body()
                .baseUri(Config.PETSTORE_BASE_URL)
                .contentType(ContentType.JSON);
    }
}
