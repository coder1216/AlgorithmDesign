package AmazonLocker;

public class Locker {
    // id
    final String lockerID;

    // add
    final String lockerAddress;

    // The size of package that this cell can hold
    final OrderSize lockerSize;

    // the item in this locker
    final Item item;


    public Locker(String lockerID, String lockerAddress, OrderSize lockerSize, Item item) {
        this.lockerID = lockerID;
        this.lockerAddress = lockerAddress;
        this.lockerSize = lockerSize;
        this.item = item;
    }


    public Item getItem() {
        return item;
    }

    public boolean isEmpty() {
        if (item == null) return true;
        return false;
    }

    public OrderSize getLockerSize() {
        return lockerSize;
    }

    public String getLockerAddress() {
        return lockerAddress;
    }

    public String getLockerID() {
        return lockerID;
    }

    public void setItem(Item item) {
        item = item;
    }

    public void clear() {
        setItem(null);
    }
}
