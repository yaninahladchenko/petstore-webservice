package test.order;

import endpoint.StoreEndpoint;
import model.Order;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class DeleteOrderTest {
    @Steps
    private StoreEndpoint storeEndpoint;
    private int orderId = 111;

    @Before
    public void createOrder(){
        Order order = new Order();
        order.setId(orderId);
        order.setPetId(555);

        order.setQuantity(3);
        order.setShipDate("2019-07-28T15:49:03.288Z");
        order.setStatus("available");
        order.setComplete(true);

        storeEndpoint
                .placeOrder(order)
                .then()
                .log().all()
                .statusCode(200);

        storeEndpoint
                .getPurchaseOrderById(orderId)
                .then()
                .statusCode(200);
    }

    /**
     * Precondition:
     * - Create order
     *
     * Scenario:
     * - Delete order
     * - Get deleted order
     */
    @Test
    public void verifyOrderCanBeDeletedById(){

        storeEndpoint
                .deletePurchaseOrderById(orderId)
                .then()
                .statusCode(200);

        storeEndpoint
                .getPurchaseOrderById(123)
                .then()
                .log().all()
                .statusCode(404);

    }

}
