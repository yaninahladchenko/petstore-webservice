package definition;

import cucumber.api.java.en.Given;
import endpoint.PetEndpoint;
import net.thucydides.core.annotations.Steps;

public class Definitions {
    @Steps
    public PetEndpoint petEndpoint;

    @Given("^I get Pet with id (\\d+)$")
    public void iGetPetWithId(int arg0) {
        petEndpoint.getPetById(arg0);
    }

    @Given("^I delete Pet with id (\\d+)$")
    public void iDeletePetWithId(int arg0) {
        System.out.println("Not implemented!!");
    }

    @Given("^I create new Pet$")
    public void iCreateNewPet() {
        System.out.println("Not implemented!!");
    }
}
