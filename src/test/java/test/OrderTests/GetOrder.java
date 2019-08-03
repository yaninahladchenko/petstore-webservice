package test.OrderTests;

import endpoint.StoreEndpoint;
import model.Order;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetOrder {
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
     * - Verify order is created
     * - Find created order by ID
     */
    @Test
    public void verifyOrderCanBeFoundById() {

        STORE_ENDPOINT
                .getPurchaseOrderById(orderId)
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void verifyOrderCannotBeFoundByInvalidId(){
        STORE_ENDPOINT
                .getPurchaseOrderById(8888)
                .then()
                .log().all()
                .statusCode(404);
    }


}
