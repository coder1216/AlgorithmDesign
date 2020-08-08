package AmazonLocker;

import java.util.HashMap;
import java.util.Map;

public abstract class Item {
    // id
    private final String id;

    // name
    private final String itemName;

    // package size
    private final OrderSize orderSize;

    // release time
    private final long releasetime;

    // expire time
    private long expiretime;

    // extra info
    private final Map<String, String> info;


    protected Item(String id, String itemName, OrderSize orderSize, long releasetime, long expiretime, Map<String, String> info) {
        this.id = id;
        this.itemName = itemName;
        this.orderSize = orderSize;
        this.releasetime = releasetime;
        this.expiretime = expiretime;
        this.info = new HashMap<>();
    }

    public long getReleasetime() {
        return releasetime;
    }

    public long getExpiretime() {
        return expiretime;
    }

    public OrderSize getOrderSize() {
        return orderSize;
    }

    public boolean isValid() {
        if (System.currentTimeMillis() >= expiretime) return false;
        return true;
    }

    public abstract boolean isPrime();
}
