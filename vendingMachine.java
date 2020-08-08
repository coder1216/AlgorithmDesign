public class Bucket<E1,E2> {

    private final E1 first;
    private final E2 second;

    public Bucket(final E1 first, final E2 second){
        this.first = first;
        this.second = second;
    }

    public E1 getFirst(){
        return first;
    }

    public E2 getSecond(){
        return second;
    }
}

public enum Coin {
    PENNY(1),

    NICKLE(5),

    DIME(10),

    QUATER(25);

    private int value;

    Coin(final int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}

public class Inventory<T> {

    private Map<T, Integer> inventory = new HashMap<T, Integer>();

    public int getQuantity(T item){
        final Integer num = inventory.get(item);
        return num == null ? 0 : num;
    }

    public void add(T item){
        Integer count = inventory.get(item);

        count = (count == null) ? 0 : count;

        inventory.put(item,count + 1);
    }

    public void deduct(T item){
        if(hasItem(item)){
            inventory.put(item,inventory.get(item) - 1);
        }
    }

    public boolean hasItem(T item){
        return getQuantity(item) > 0;
    }

    public void clear(){
        inventory.clear();
    }

    public void put(T item, int num){
        inventory.put(item,getQuantity(item) + num);
    }
}

public enum Item {

    COKE("Coke",25),

    PEPSI("Pepsi",35),

    FANTA("Fanta", 45);

    private String name;

    private int price;

    Item(final String name, final int price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }
}

public interface IVendingMachine {

    long selectItemAndGetPrice(Item item);

    void insertCoin(Coin coin);

    List<Coin> refund();

    Bucket<Item, List<Coin>> collectItemAndChange();

    void reset();

}

public class NotFullPaidException extends RuntimeException {

    private String message;
    private long remaining;

    public NotFullPaidException(String message, long remaining) {
        this.message = message; this.remaining = remaining;
    }

    public long getRemaining(){
        return remaining;
    }

    @Override
    public String getMessage(){
        return message + remaining;
    }

}
public class NotSufficientChangeException extends RuntimeException {
    private String message;

    public NotSufficientChangeException(String string)
    {
        this.message = string;
    }

    @Override
    public String getMessage(){
        return message;
    }

}
public class SoldOutExcepton extends RuntimeException {

    private String message;

    public SoldOutExcepton(String string)
    {
        this.message = string;
    }

    @Override
    public String getMessage(){ return message; }

}
public class VendingMachineFactory {
    public static NormalVendingMachine createVendingMachine(){
        return new NormalVendingMachine();
    }
}




public interface IVendingMachine {

    long selectItemAndGetPrice(Item item);

    void insertCoin(Coin coin);

    List<Coin> refund();

    Bucket<Item, List<Coin>> collectItemAndChange();

    void reset();

}