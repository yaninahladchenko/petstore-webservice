package test.OrderTests;

import endpoint.StoreEndpoint;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class InventoryTest {
    @Steps
    private StoreEndpoint storeEndpoint;

    @Test
    public void verifyStoreInventory(){
        storeEndpoint
                .getStoreInventory()
                .then()
                .log().body()
                .statusCode(200);
    }

}
