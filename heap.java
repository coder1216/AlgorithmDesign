import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/*

functionality fro heap
offer
poll
peek
update

heapify()
pUp()
pDown()


*/

class Solution{
    public class MinHeap{
        // fields
        int[] array;
        int size;

        // methods
    public MinHeap(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException();
        }
        array = new int[capacity];
        size = 0;
    } 
    public MinHeap(int[] inputArray){
        //CC
        array = Arrays.copyOf(inputArray, inputArray.length * 2);
        size = inputArray.length;
        heapify();
    }  
    // 最后一个leaf node 是size-1，parent就是 (size - 2)/2 ->最后一个非leaf node 的index
    private void heapify(){
        for(int i = (i-2)/2; i >= 0; i--){
            pDown(i);
        }
    }
    private void pUp(int index){
        while(index > 0){ // 只要我有parent，我就可以pUp, pUP的过程中，index一直在减小，只要index还大于0，说明有parent
            int parent = (index - 1)/2;
            if(array[parent] > array[index]){ // parent 的值比当前值大，当前值才pUp
                swap(array, parent, index);
            }else{
                break; // 当parent比index小的时候，跳出while loop
            }
            index = parent; // 新的index就是以前parent的位置，因为患上来了
        }
    }
    private void pDown(int index){
        while(index <= (size-2) / 2){ // 当node为非leaf node 时，才可以做pDown 
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int swapIndex = left; // 防止没有right node, 先把leftnode 保存在需要swap的变量中
            if(right < size){ // if 存在右边node
                if(array[right] < array[left]){ // 如果右边是最小的
                    swapIndex = right; // 把右边保存起来
                } // 否则默认保存到左边
            }
            if(array[index] > array[swapIndex]){ // 如果保存在swapindex的值比要换的值小，就交换
                swap(array, index, swapIndex);
            }else{
                break; // 否则说明已经不能再往下了，因为swapIndex的值比target大
            }
            index = swapIndex;
        }
    }
    private void swap(int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    private void offer(int val){
        if(array.length == size){ // offer的时候，如果heap满了，就需要expand
            int[] newArray = new int[size * 2];
            newArray = Arrays.copyOf(array, size);
            array = newArray;
        }
        array[size] = val; // 新值加到heap的最下面
        pUp(size); //向上调整
        size++; // 完成了pUp才能size++ 不然size位置不对
    }
    private Integer poll(){
        if(size == 0){ // 如果没有，就poll不出来东西
            return null;
        }
        int smallest = array[0]; // 先把第一个保存在smalles里
        array[0] = array.size[size - 1]; // 把最后一个值放到第一个
        pDown(0); // 往下做 p Dwon
        size--; 
        return smallest;
    }
    public void update(int index, int val){
        if(index < 0 || index > size){
            throw new IllegalArgumentException();
        }
        int tmp = array[index]; //老值
        array[index] = val; // 新值
        if(tmp > val){  // 新值小于老值，新值up
            pUp(index);
        }else if(tmp < val){ // 新值大于老值，新值down
            pDown(index);
        }
    }
}
}