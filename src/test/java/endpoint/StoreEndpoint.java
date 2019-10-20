package endpoint;

import model.Order;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;


public class StoreEndpoint extends BaseEndpoint {

    @Step
    public Response getStoreInventory() {
        return given()
                .when()
                .get(Config.STORE_INVENTORIES)
                .then().extract().response();
    }

    @Step
    public Response placeOrder(Order order) {
        return given()
                .body(order)
                .when()
                .post(Config.PLACE_ORDER)
                .then().extract().response();
    }

    @Step
    public Response getPurchaseOrderById(long id) {
        return given()
                .when()
                .get(Config.FIND_PURCHASE_ORDER_BY_ID, id)
                .then().extract().response();
    }

    @Step
    public Response deletePurchaseOrderById(long id) {
        return given()
                .when()
                .delete(Config.DELETE_PURCHASE_ORDER_BY_ID, id)
                .then().extract().response();
    }
}
