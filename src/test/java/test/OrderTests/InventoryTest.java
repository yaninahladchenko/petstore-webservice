package test.OrderTests;

import endpoint.StoreEndpoint;
import org.testng.annotations.Test;


public class InventoryTest {

    private static final StoreEndpoint STORE_ENDPOINT = new StoreEndpoint();

    @Test
    public void verifyStoreInventory(){
        STORE_ENDPOINT
                .getStoreInventory()
                .then()
                .log().body()
                .statusCode(200);
    }

}
