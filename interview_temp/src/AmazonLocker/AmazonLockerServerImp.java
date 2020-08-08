package AmazonLocker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonLockerServerImp implements AmazonLockerServer{

    // list of locker
    private final List<Locker> lockerList;

    // locker map
    private final Map<String, Locker> map;

    // id
    private final Locker locker;

    // Service
    private final AmazonLockerServer service;

    // Order
    Order order;

    public AmazonLockerServerImp(List<Locker> lockerList, Map<String, Locker> map, Locker locker, AmazonLockerServer service) {
        this.lockerList = lockerList;
        this.map = new HashMap<>();
        this.locker = locker;
        this.service = service;
    }

    public Map<String, Locker> getMap() {
        return map;
    }

    public List<Locker> getLockerList() {
        return lockerList;
    }

    public String getLockerId() {
        return locker.lockerID;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public boolean getOrder(String orderId, String cellId) {
        if (!map.containsKey(cellId) || map.get(cellId).isEmpty()) return false;
        map.get(cellId).getItem();
        return true;
    }

    @Override
    public String sendNotification(String orderId) {
        if (getOrder(orderId, locker.lockerID)) return locker.lockerID;
        return null;
    }

    @Override
    public String getOrderInfo(String orderID, String code) {
        return null;
    }

    @Override
    public boolean upDateOrderStatus(String orderId, OrderStatus status) {
        if (order.getOrderId() == orderId) {
            order.setOrderStatus(status);
            return true;
        }
        return false;
    }

    @Override
    public Locker getLockerAddress(String lockerId) {
        return null;
    }

    @Override
    public Locker getLockerId(String lockerId) {
        return null;
    }

    @Override
    public boolean putOrder(String orderId, String cellId) {
        if (!locker.isEmpty()) {
            return false;
        }
        if (locker.lockerSize.compareTo(map.get(cellId).getItem().getOrderSize()) < 0) return false;

        locker.setItem(map.get(cellId).getItem());
        return true;
    }

    public Locker getLocker() {
        return locker;
    }
}
