package AmazonLocker;

public interface AmazonLockerServer {

    // user get oder from locker
    boolean getOrder(final String orderId, final String cellId);

    // user receive notification
    String sendNotification(final String orderId);

    // user get info
    String getOrderInfo(final String orderID, final String code);

    // user get ship status
    boolean upDateOrderStatus(final String orderId, final OrderStatus status);

    // user get address
    Locker getLockerAddress(final String lockerId);

    // user get locker number
    Locker getLockerId(final String lockerId);

    // put item to locker
    boolean putOrder(final String orderId, final String cellId);
}
