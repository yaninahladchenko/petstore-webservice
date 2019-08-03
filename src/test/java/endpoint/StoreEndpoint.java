package endpoint;

import model.Order;
import io.restassured.response.Response;


public class StoreEndpoint extends BaseEndpoint {

    public Response getStoreInventory() {
        return given()
                .when()
                .get(Config.STORE_INVENTORIES)
                .then().extract().response();
    }

    public Response placeOrder(Order order) {
        return given()
                .body(order)
                .when()
                .post(Config.PLACE_ORDER)
                .then().extract().response();
    }

    public Response getPurchaseOrderById(long id) {
        return given()
                .when()
                .get(Config.FIND_PURCHASE_ORDER_BY_ID, id)
                .then().extract().response();
    }

    public Response deletePurchaseOrderById(long id) {
        return given()
                .when()
                .delete(Config.DELETE_PURCHASE_ORDER_BY_ID, id)
                .then().extract().response();
    }
}
