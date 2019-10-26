package model;

public class Order extends BaseEntity {

    private long petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    public long getPetId() {
        return petId;
    }

    public void setPetId(long petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean getComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


    public static Order createNewOrder() {
        Order order = new Order();
        order.setId(123);
        order.setPetId(333);

        order.setQuantity(1);
        order.setShipDate("2019-07-29T18:36:57.480Z");
        order.setStatus("available");
        order.setComplete(true);
        return order;
    }


}
