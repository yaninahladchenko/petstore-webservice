package test.OrderTests;

import endpoint.StoreEndpoint;
import model.Order;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteOrder {
    private static final StoreEndpoint STORE_ENDPOINT = new StoreEndpoint();
    private int orderId = 111;

    @BeforeMethod
    public void createOrder(){
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
                .statusCode(200);

        STORE_ENDPOINT
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

        STORE_ENDPOINT
                .deletePurchaseOrderById(orderId)
                .then()
                .statusCode(200);

        STORE_ENDPOINT
                .getPurchaseOrderById(123)
                .then()
                .log().all()
                .statusCode(404);

    }

}
