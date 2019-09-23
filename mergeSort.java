/**
 * MergeSort

array:	7 5 3 1 4 2 8 6
l        m          r
7 5 3 1 | 4 2 8 6   mergeSort(array, l, m); mergeSort(array, mid+1, r)
l        r    l        r
7 5 | 3 1 | 4 2 | 8 6
lm r
7 | 5 | 3 1 | 4 2 | 8 6 merge(array, left, right, mid, helper)
l     r
lc   rc
5   7 | 1 3 | 2 4 | 6 8
      c

array: 	*** 1 2 3 4 | 5 7 7 8 9 ***
                          c
array: 	*** 1 3 5 7 | 2 4 6 8 9 ***
                  l         m           r
	      lc
		       rc

helper:	*** 1 3 5 7 | 2 4 6 8 9 ***
                 l        m            r
                             lc           
                                        rc
 */
// MergeSort.java
public class MergeSort {
	
	public int[] mergeSort(int[] array) {
		// Corner case
		if (array == null || array.length <= 1) {
			return array;
		}

		int[] helper = new int[arrray.length];
		mergeSort(array, helper, 0, array.length - 1);
		return array;
	}

	private void mergeSort(int[] array, int[] helper, int left, int right) { // overloading
		// base case
		if (left == right) {
			return;
		}

		int mid = left + (right - left) / 2;
		mergeSort(array, helper, left, mid);
		mergeSort(array, helper, mid + 1, right);
		merge(array, helper, left, mid, right);
	}

	private void merge(int[] array, int[] helper, int left, int mid, int right) {
		for (int i = left; i <= right; i++) { // deep copy
			helper[i] = array[i];
		}
		int leftIndex = left;
		int rightIndex = mid + 1;
		int cur = left;
		while(leftIndex <= mid && rightIndex <= right) {
			if (helper[leftIndex] < helper[rightIndex]) {
				array[cur++] = helper[leftIndex++];
			} else {
				array[cur++] = helper[rightIndex++];
			}
		}
		// remaining elements on left side
		while (leftIndex <= mid) {
			array[cur++] = helper[leftIndex++];
		}
		// remaining elements on right side
	}

	public static void main(String[] args) { －－》 JUnit
		MergeSort solution = new MergeSort();
		
		//test cases to cover all the possible situations
		int[] array = null;
		array = solution.mergeSort(array);
		System.out.println(Arrays.toString(array)); → assert(array, null)
		
		array = new int[0];
		array = solution.mergeSort(array);
		System.out.println(Arrays.toString(array));

array = new int[] {7};
		array = solution.mergeSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {1, 2, 3, 4};
		array = solution.mergeSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {4, 3, 2, 1};
		array = solution.mergeSort(array);
		System.out.println(Arrays.toString(array));
		
		array = new int[] {2, 4, 1, 5, 3};
		array = solution.mergeSort(array);
		System.out.println(Arrays.toString(array));
	}
}

// To HW: 
// 1 O(n) space ArrayList
// 2 O(nlogn) space ArrayList
// 3 input large? → external sort


class ArrayList<E> implements List {
    private E[] array; // the current maximum capacity is
    array.length not arraylist size;
    private int size; // the number of actually used elements
        
        add(E val); // expand, deep copy
    }
    
    // 1 2 3 4 5
    // new arraylist 
    // array = {1, 2, 3, 4, 5, null, null, null, null, null} size = 5, capacity = 10
    // add more until full
    // add 11?
    // check if array is full: size == capacity if full
    // array1 = new Integer[size * 1.5] → (int) casting
    // array1 = deep copy from array
    // size = 10, capacity = 15
    // array = array1
    
    // 6 4 2 0 | 1 3 5 7			            
    //         /		     \      			O(1)		O(n/2)
    //        6  4 | 2  0		1 3 | 5 7	
    //        /	    \		/	\			O(2)		O(n/4) * 2
    //         6 | 4           2 | 0	          1 | 3     5 | 7		
    //       /         \       /       \	          /     \     /     \			O(4)
    //     6          4     2       0          1     3   5      7
    //     ……..			…...				O(n)   = O(2n - 1) = O(n)
    //      \         /         \      /           \       /    \      /
    //         4 6               0 2	           1  3      5  7			O(n)
    //     \              /  		  \          /			O(n)
    //                 0 2 4 6		   1 3 5 7		 	O(nlogn)
    //         \       	                    /
    //            0 1 2 3 4 5 6 7
    
    public class MergeSort {
        public ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
            // Corner case
            if (array == null || array.size() <= 1) {
                return array;
            }
            return mergeSort(array, 0, array.size() - 1);
        }
    
        private ArrayList<Integer> mergeSort(ArrayList<Integer> array, int left, int right) { // overloading
            ArrayList<Integer> res = new ArrayList<>();
    // base case
            if (left == right) {
                res.add(array.get(left));
                return res;
            }
    
            int mid = left + (right - left) / 2;
            ArrayList<Integer> leftRes = mergeSort(array, left, mid);
            ArrayList<Integer> rightRes = mergeSort(array, mid + 1, right);
            merge(leftRes, rightRes, res);
            return res;
        }
    
        private void merge(ArrayList<Integer> leftRes, ArrayList<Integer> rightRes, List<Integer> res) {
            int leftIndex = 0;
            int rightIndex = 0;
            while(leftIndex < leftRes.size() && rightIndex < rightRes.size()) {
                if (leftRes.get(leftIndex) < rightRes.get(rightIndex)) {
                    res.add(leftRes.get(leftIndex++));
                } else {
                    res.add(rightRes.get(rightIndex++));
                }
            }
            // remaining elements on left side
            while (leftIndex < leftRes.size()) {
                res.add(leftRes.get(leftIndex++));
            }
            // remaining elements on right side
            while (rightIndex < rightRes.size()) {
                res.add(rightRes.get(rightIndex++));
            }
            // return
        }
    }
    
    // One application of merge sort is external sort: when the array cannot be fit in memory, doing merge in memory and flush the sorted part into disk.
    
    // 4G Memory, 100G Hardisk, 80G unsorted array.
    
