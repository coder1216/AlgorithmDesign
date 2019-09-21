/**
 * 
 * Implement PriorityQueue (a.k.a Heap)
PriorityQueue is one type of implementation of Heap
Heap的逻辑结构 is a tree
		       10
		  / 	     \
		7	    8
	      /         \         /
                 5         3       2   

Heap的存储结构 is an unsorted array in memory → 10 7 8 5 3 2 12
1 heap order ? Min Heap / Max Heap minimum / maximum
2 heap is always a complete binary tree
3 you can only access the top node when you use it.
4 insert(push/offer/add) pop(poll/delete/remove) get update/put
5 initialize heapify
heapify O(n) convert an unsorted array to tree
insert() O(logn) 
delete() O(logn)
update() O(logn) → delete() insert()
get() O(1)
6 Given an element with index x in the unsorted array,
parent (x - 1) / 2
lchild 2x + 1
rchild 2x + 2

 Index of cur = i, what is the index of the two child nodes?
left child of Index i = 2 * i  + 1
right child of Index i = 2 * i + 2
parent of Index i = (i -1) / 2
Heap is a (binary) tree logically, is Array storage
 Index of cur = i, what is the index of the two child nodes?
left child of Index i = 2 * i  + 1
right child of Index i = 2 * i + 2
parent of Index i = (i -1) / 2

Basic Heap Internal Operations
1
/       	 \
                   2             10
I  	 \     	 I          \
5       3      13  	 19
I     \      /  \
        11     8    6   

{1 2 10 5 3 13 19 11 8 6 4}

13 11 4 10 8 7 6 2 3 
             2
	        /         \
	    16              4
	 /       \         /     \
          10        8       7       6
         /    \     
       13     11

k = logn

2^0 * k-1 + 2^1 * (k-2) + 2^2 * (k-3) + …… + 2^(k-2) * 1 = Sum
       2^1 * k-1 + 2^2 * (k - 2) + 2^3 * (k-3) + …. 2^(k-1) * 2  = 2Sum 
-k + 1 + 2 + 2^2 + …. 2^(k-2) + 2^(k-1) = 2^k → 2^logn → n

offer
poll
peek
update
heapify()
percolateUp(index)
percolateDown(index)

public class MinHeap {
	int[] array;
	int size;
	comparator;

	// methods
 public MinHeap(int cap) {
    if (cap <= 0) {
      throw new IllegalArgumentException("capacity can not be <= 0");
    }
    array = new int[cap];
    size = 0;
  }

	public MinHeap(int[] inputArray){ clone vs copyOf
		//corner case
	array = Arrays.copyOf(inputArray, inputArray.length * 2);
	size = inputArray.length;
	this.comparator = cmp;
	heapify();
}

private void heapify() {
	for (int i = (size -2) / 2; i >= 0; i--) {
		percolcateDown(i);
}

}


private void percolcateUp(int index) {
	while (index > 0) {
	int parent = ( index -1 ) / 2;
	if (array[parent] > array[index]) { comparator.compare(array[p], array[index]) > 0
	swap(array, parent, index);
} else {
	break;
}
index = patent;
}
}

private void percolcateDown(int index) {
	while (index  <= (size-2) / 2) {
	int left = index * 2 + 1;
	int right = index * 2 + 2;
	int swapIndex = left;
if (right < size) {
	if (array[right] < array[left]) {
	swapIndex = right;
}
}
if (array[index] > array[swapIndex]) {
	swap(index, swapIndex);
} else {
	break;
}
index = swapIndex;
}
}

private void swap(int i, int j) {
	int tmp = array[i];
	array[i] = array[j];
	array[j] = tmp;
}

public void offer(int val) {
	if (array.length == size) {
	int[] newArray = new int[size * 2];
	newArray = Arrays.copyOf(array, size);
	array = newArray;
}
	array[size] = val;
	percolateUp(size);
size++;
}

public Integer poll() {
	if  (size == 0) {
	return null;
}
int smallest = array[0];
array[0] = array[size - 1];
percolateDown(0);
size--;
return smallest;
}

public void update (int index, int val) {
	if (index < 0 ||index > size) {
	throw new Exception();
}
// int tmp = array[index];
array[index]= val;
// if (tmp > val) {
	percolateUp(index);
// } else if (tmp < val) {
	percolateDown(index);
}
} 
}


limited → unlimited
int → T
comparator

How to pass in a Comparator and use the Comparator to compare and determine the priority  of different elements.

Order / Priority - The PriorityQueue need to know how to compare the elements and
determine which one is smaller/larger.

There are two ways to do so:
The element type/Class implementing Comparable interface
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

 * 
 * 
 * 
 * 
 * 
 * 
 */