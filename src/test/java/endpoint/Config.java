package endpoint;

public class Config {
    public static final String PETSTORE_BASE_URL = "https://petstore.swagger.io/v2";

    public static final String PET_BY_ID = "/pet/{petId}";

    public static final String CREATE_PET = "/pet";

    public static final String FIND_BY_STATUS = "/pet/findByStatus";

    public static final String STORE_INVENTORIES = "/store/inventory";

    public static final String PLACE_ORDER = "/store/order";

    public static final String FIND_PURCHASE_ORDER_BY_ID = "/store/order/{orderId}";

    public static final String DELETE_PURCHASE_ORDER_BY_ID = "/store/order/{orderId}";
}
