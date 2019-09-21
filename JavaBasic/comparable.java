/*

How to pass in a Comparator and use the Comparator to compare and determine the priority  of different elements.

Order / Priority - The PriorityQueue need to know how to compare the elements and
determine which one is smaller/larger.

There are two ways to do so:
The element type/Class implementing Comparable interface
*/
interface Comparable<E> {
int compareTo(E ele);
}

class Integer implements Comparable<lnteger> {
private int value;
public lnteger(int value) {
this.value = value;
	}

@Override
public int compareTo(Integer another) {
if (this.value == another.value) {   a == b
return 0;
	}
return this.value < another.value ? -1 : 1;
// return this.value - another.value;
}
}

The element type/Class implementing Comparator interface
interface Comparator<E> {
int compare(E ele1, E ele2);
}

class Cell {
public int row;
public int col;
public int value;
public Cell(int row, int col, int value) {
this.row = row;
this.cell = cell;
this.value = value;
	}
}

class MyComparator implements Comparator<CelI> {
@Override
public int compare(Cell c1, Cell c2) {
if (c1.value == c2.value) {
return 0;
	}
return c1.value < c2.value ? -1 : 1;
	}
}

Most frequently used constructors of PriorityQueue
1. PriorityQueue<Cell> heap = new PriorityQueue<>();
initialize the internal array with default capacity(11)
class Cell must implements Comparable<Cell> !

2. PriorityQueue<Cell> heap = new PriorityQueue<>(20);
initialize the internal array with specified capacity(20)
class Cell implements Comparable<Cell>

3. PriorityQueue<Cell> heap = new PriorityQueue<>(16, new MyComparator(){});
initialize the internal array with specified capacity(16)
class MyComparator implements Comparator<Cell>

new Comparator<Cell>(){
	@Override
	int compare(Cell c1, Cell c2)
	…..
}

→ lambda expression  (c1, c2) -> {return c1.value - c2.value}


// Smallest K Elements In Unsorted Array

public List<Integer> smallestK(List<Integer> array, int k) {
	if(array == null || array.length < k) return array;
	List<Integer> res = new ArrayList<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>(){
	@Override
	public int compare(integer a, integer b) {
		return b - a;

		if (a == b) return 0 ?
		return a < b ? -1 : 1;
	}
}); 
for(int i = 0; i < array.length; i++) {
	if(maxHeap.size() < k) {
		maxHeap.offer(array[i]);
	} else if(maxHeap.peek() > array[i]) {
		maxHeap.poll();
		maxHeap.offer(array[i]);
	}
}

while(!maxHeap.isEmpty()) res.add(maxHeap.poll());
return res;
}




