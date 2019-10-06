package test.OrderTests;

import endpoint.StoreEndpoint;
import model.Order;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class CreateOrder {
    private static final StoreEndpoint STORE_ENDPOINT = new StoreEndpoint();
    private int orderId = 111;

    /**
     * - Create order
     * - Get created order by ID
     */
    @Test
    public void verifyOrderCanBeCreated() {
        Order order = new Order();
        order.setId(orderId);
        order.setPetId(555);

        order.setQuantity(3);
        order.setShipDate("2019-07-28T15:49:03.288Z");
        order.setStatus("available");
        order.setComplete(true);

        STORE_ENDPOINT
                .placeOrder(order)
                .then()
                .log().all()
                .body(not(isEmptyString()))
                .body("id", equalTo(orderId))
                .body("status", is("available"))
                .statusCode(200);

        STORE_ENDPOINT
                .getPurchaseOrderById(orderId)
                .then()
                .log().all()
                .statusCode(200);
    }
}

