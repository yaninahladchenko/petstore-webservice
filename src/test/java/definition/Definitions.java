package definition;

import com.google.common.collect.ImmutableList;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import endpoint.PetEndpoint;
import io.restassured.response.Response;
import model.Category;
import model.Pet;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class Definitions {
    @Steps
    public PetEndpoint petEndpoint;

    static Response currentResponse;

    @Given("^I get Pet with id (\\d+)$")
    public void iGetPetWithId(long petId) {
        currentResponse = petEndpoint.getPetById(petId);
    }

    @Given("^I delete Pet with id (\\d+)$")
    public void iDeletePetWithId(long petId) {
        currentResponse = petEndpoint.deletePetById(petId);
    }

    @Given("^I get Pet by status \"([^\"]*)\"$")
    public void iGetPetByStatus(String status) {
        currentResponse = petEndpoint.getPetByStatus(status);
    }

    @Then("^I assert status code is (\\d+)$")
    public void iAssertStatusCodeIs(int expectedStatusCode) {
        currentResponse
                .then()
                .statusCode(expectedStatusCode);
    }

    @Given("^I create new Pet with following data$")
    public void iCreateNewPet(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        long petId = Long.parseLong(list.get(0).get("Pet id"));
        String petName = list.get(0).get("Pet name");
        long categoryId = Long.parseLong(list.get(0).get("Category id"));
        String categoryName = list.get(0).get("Category name");
        String status = list.get(0).get("Status");


        Category category = new Category();
        category.setName(categoryName);
        category.setId(categoryId);

        Pet pet = new Pet();
        pet.setId(petId);
        pet.setName(petName);
        pet.setCategory(category);
        pet.setPhotoUrls(ImmutableList.of("someUrl"));
        pet.setStatus(status);

        currentResponse = petEndpoint.createPet(pet);
    }
}
