package test.pet;

import endpoint.PetEndpoint;
import model.Pet;
import com.google.common.collect.ImmutableList;
import model.Category;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class PetTest {
    @Steps
    public PetEndpoint petEndpoint;

    @Test
    public void verifyStatusCode() {
        petEndpoint
                .getPetByStatus("available")
                .then()
                .statusCode(200);
    }

    @Test
    public void verifyBody() {
        petEndpoint
                .getPetByStatus("available")
                .then()
                .assertThat()
                .body(is(not(isEmptyOrNullString())));
    }

    @Test
    public void verifyNotExistingPetReturn404() {
        petEndpoint
                .getPetById(113214)
                .then()
                .statusCode(404);
    }

    @Test
    public void verifyPetCanBeCreated() {
        Category category = new Category();
        category.setName("Cats");
        category.setId(123456);

        Pet cat = new Pet();
        category.setName("Bobby");
        cat.setCategory(category);
        cat.setPhotoUrls(ImmutableList.of("someUrl"));
        cat.setStatus("available");

        petEndpoint
                .createPet(cat)
                .then()
                .statusCode(200);
    }
}
