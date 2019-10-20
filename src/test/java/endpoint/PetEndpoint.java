package endpoint;

import io.restassured.response.Response;
import model.Pet;
import net.thucydides.core.annotations.Step;

public class PetEndpoint extends BaseEndpoint {

    @Step
    public Response getPetById(long id) {
        return given()
                .when()
                .get(Config.PET_BY_ID, id)
                .then().extract().response();
    }

    @Step
    public Response getPetByStatus(String status) {
        return given()
                .queryParam("status", status)  //when to use? difference between query and path param?
                .when()
                .get(Config.FIND_BY_STATUS)
                .then()
                .extract().response();
    }

    @Step
    public Response createPet(Pet pet) {
        return given()
                .body(pet)
                .when()
                .post(Config.CREATE_PET)
                .then().extract().response();
    }

}
