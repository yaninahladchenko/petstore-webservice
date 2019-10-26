package test.OrderTests;

import endpoint.StoreEndpoint;
import model.Order;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class CreateOrderTest {
    @Steps
    private StoreEndpoint storeEndpoint;
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

        storeEndpoint
                .placeOrder(order)
                .then()
                .log().all()
                .body(not(isEmptyString()))
                .body("id", equalTo(orderId))
                .body("status", is("available"))
                .statusCode(200);

        storeEndpoint
                .getPurchaseOrderById(orderId)
                .then()
                .log().all()
                .statusCode(200);
    }
}

