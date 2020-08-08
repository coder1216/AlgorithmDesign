package AmazonLocker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    //
    Mechant mechant;
    //The id of the order
    private final String orderId;

    //The id of the user who made this order
    private final String userId;

    //The shipping address of this order
    private final String shipaddress;

    // client add
    private final String clientAddress;

    //The list of the items in this order
    private List<Item> itemsList;

    //The shipping status of this order
    private OrderStatus orderStatus;

    //ship time
    private long shiptime;
    
    //arrive time
    private long arrivetime;
    
    // in which locker
    private Locker locker;
    
    // address of locker
    private String lockeraddress;
    
    // extra info
    private final Map<Order, String> info;


    public Order(String orderId, String userId, String shipaddress, String clientAddress, List<Item> itemsList, OrderStatus orderStatus, long shiptime, long arrivetime, Locker locker, String lockeraddress, Map<Order, String> info) {
        this.orderId = orderId;
        this.userId = userId;
        this.shipaddress = shipaddress;
        this.clientAddress = clientAddress;
        this.itemsList = itemsList;
        this.orderStatus = orderStatus;
        this.shiptime = shiptime;
        this.arrivetime = arrivetime;
        this.locker = locker;
        this.lockeraddress = lockeraddress;
        this.info = new HashMap<>();
    }

    public void setArrivetime(long arrivetime) {
        this.arrivetime = arrivetime;
    }

    public void setShiptime(long shiptime) {
        this.shiptime = shiptime;
    }

    public void setLockeraddress(String lockeraddress) {
        this.lockeraddress = lockeraddress;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public Locker getLocker() {
        return locker;
    }

    public long getArrivetime() {
        return arrivetime;
    }

    public long getShiptime() {
        return shiptime;
    }

    public Map<Order, String> getInfo() {
        return info;
    }

    public String getShipaddress() {
        return mechant.address;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
