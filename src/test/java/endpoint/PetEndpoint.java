package endpoint;

import model.Pet;
import io.restassured.response.Response;


public class PetEndpoint extends BaseEndpoint {

    public Response getPetById(long id) {
        return given()
                .when()
                .get(Config.PET_BY_ID, id)
                .then().extract().response();
    }

    public Response getPetByStatus(String status) {
        return given()
                .queryParam("status", status)  //when to use? difference between query and path param?
                .when()
                .get(Config.FIND_BY_STATUS)
                .then()
                .extract().response();
    }

    public Response createPet(Pet pet) {
        return given()
                .body(pet)
                .when()
                .post(Config.CREATE_PET)
                .then().extract().response();
    }

}
