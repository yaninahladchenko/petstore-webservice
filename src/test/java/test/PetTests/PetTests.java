package test.PetTests;

import endpoint.PetEndpoint;
import model.Pet;
import com.google.common.collect.ImmutableList;
import model.Category;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class PetTests {

    public static final PetEndpoint PET_STORE_PET_ENDPOINT = new PetEndpoint();

    @Test
    public void verifyStatusCode() {
        PET_STORE_PET_ENDPOINT
                .getPetByStatus("available")
                .then()
                .statusCode(200);
    }

    @Test
    public void verifyBody() {
        PET_STORE_PET_ENDPOINT
                .getPetByStatus("available")
                .then()
                .assertThat()
                .body(is(not(isEmptyOrNullString())));
    }

    @Test
    public void verifyNotExistingPetReturn404() {
        PET_STORE_PET_ENDPOINT
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

        PET_STORE_PET_ENDPOINT
                .createPet(cat)
                .then()
                .statusCode(200);
    }
}
