import java.util.*;

public class HashTable<K, V> {
	
	private static final double LOAD_FACTOR = 0.75d;
	private int MAX_SIZE = 256;
	private List<Cell<K, V>>[] items;
	private int size;

	public HashTable() {
		this.items = (List<Cell<K, V>>[]) new LinkedList[MAX_SIZE];
		this.size = 0;
	}
	
	public int hashCodeOfKey(K key) {
		return (key == null 
? 0 
: Math.abs(key.hashCode() % MAX_SIZE));
	}
	
	public void put(K key, V value) {
		Cell<K, V> newCell = new Cell<K, V>(key, value);
		int index = hashCodeOfKey(key);
		if (items[index] == null) {
			items[index] = new LinkedList<Cell<K, V>>();
		}
		 
		List<Cell<K, V>> slot = items[index];
		for (Cell<K, V> cell : slot) { 
			if (newCell.equals(cell)) {
				slot.remove(cell); //directly update value of cell
				this.size--;
				break;
			}
		}
		
		this.size++;
		slot.add(newCell);
		
		if (this.size > MAX_SIZE * LOAD_FACTOR ) {
			rehashing();
		}
	}
	
	public V get(K key) {
		int index = hashCodeOfKey(key);
		
		if (items[index] == null)	return null;
		
		List<Cell<K, V>> slot = items[index];
		for (Cell<K, V> cell : slot) {
			if (cell.keyEquals(key)) {
				return cell.getValue();
			}
		}
		
		return null;
	}
	
	private void rehashing() {
		// double the size of hash table
		MAX_SIZE *= 2;
		List<Cell<K, V>>[] newItems =
 (List<Cell<K, V>>[]) new LinkedList[MAX_SIZE];
		
		for (List<Cell<K, V>> slot : items) {
			if (slot != null) {
				for (Cell<K, V> cell : slot) {
					int index = hashCodeOfKey(cell.getKey());
					if (newItems[index] == null) {
						newItems[index] =
new LinkedList<Cell<K, V>>();
					}
					newItems[index].add(cell);
				}
			}
		}
		
		this.items = newItems;
	}
	
	public static void main(String[] args) {
		HashTable<String, Integer> table =
 new HashTable<String, Integer>();
		
		String[] keys = {"abc", "xyz", "abc", "vv", "x"};
		Integer[] values = {1,10,2,5,null};
		
		int len  = keys.length;
		
		System.out.println(table.get(""));
		System.out.println(table.get(null));
		
		for (int i = 0; i < len; i++) {
			table.put(keys[i], values[i]);
			Integer val = table.get(keys[i]);
			System.out.println(val);
		}
		
		
		System.out.println(table.get(""));
		
		for (int i = 0; i < len; i++) {
			System.out.println(table.get(keys[i]));
		}
	}

}

class Cell<K, V> {
	private K key;
	private V value;
	
	public Cell(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return this.key == null ? 0 : this.key.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Cell<?, ?>) {
			Cell<K, V> that = (Cell<K, V>) o;
			if (key == null) {
				return that.key == null;
			} else {
				return key.equals(that.key);
			}
		} else {
			return false;
		}
	}
	
	public boolean keyEquals(K key) {
		if (this.key == null) {
			return key == null;
		} else {
			return this.key.equals(key);
		}
	}
	
	public K getKey() {
		return this.key;
	}
	
	public V getValue() {
		return this.value;
	}
}
