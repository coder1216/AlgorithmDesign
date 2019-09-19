/**
 * LC169
 * 1/2, 1/3, 1/k
 * given an array of size n, find the majorty element. The majority element is the element that appears more than 1/2 times
 *   1  3  2  2  2  7  2  2
 *   1  2  2  2  2  2  3  7
 *  
 * 
 * S1, assume存在majority number
 * sort, find the middle number O(nlogn)
 * 1  3  3  3  1  3  1  3
 * 1  3  3  3  4  3  2  3
 * 
 * 先从小到大sort，找到中位数，因为是majoritynumber，占据了50%以上，所以中间那个肯定是，如果是偶数，中间靠右那个也是，因为超过50%，所以奇偶问题no matters
 * 
 * s2, O(n)
 * hashmap<key = candidate, value = count>
 * step1, scan from left to right, update hashmap
 * step2, scan hashmap key set, find the count > size/2 return key,, break for loop if you find 1
 * 
 * step1 + step2  -> one pass
 * for(Key key : map.setKey()){
 * 
 * }
 * 
 * s3, assume存在majority number
 * voting sort
 * exp
 * 1  4  3  3  3  5  3  2  3
 * 
 * 1进来，1出现了1次 <1，1>
 * 4进来，4出现了一次，和1抵消 <1, 0>  
 * 3进来，3出现了一次，<3，1>
 * 3进来，3出现了2次，<3, 2>
 * 3进来，3出现了3次，<3, 3>
 * 5进来，5和3抵消1次，<3, 2>
 * 3进来，<3, 3>
 * 2进来，2和3抵消1次，<3, 2>
 * 3进来，<3, 3>
 * 结果 <3, 3>， 3位majority number
 * 
 * 因为，assume存在majority number，他一定是大于50%的，所以全部的数字都和3去抵消，最后剩下的也还是3，因为其他数字占了小于50%的空间。这个算法可以使用的前提条件是，有存在majority number，然后帮你找出这个number.
 */
// 以上图为例子
// <1, 1>
// <cur, count>
// s3, voting sort
class Solution{
    public int majorityNum(int[] nums){
        if(nums == null) throw new IllegalArgumentException();
        int cur = nums[0]; // 当前遍历到的位置
        int count = 1;  // 计数，
        // 把第一个数放进去了，所以跳过0，从1开始count
        for(int i = 1; i < nums.length; i++){
            if(count == 0){   // 新进来的数字，count为0
                count++;
                cur = nums[i];
            }else if(cur == nums[i]){
                count++;   //重复出现的数字，非新，count++
            }else{
                count--; //遇到 cur != nums[i],别的数字，抵消count
            }
        }
        return cur; //输出majority nujmber
    }
}

// class Solution{
//     public int majority(int[] nums){
//         if(nums == null) throw new IllegalArgumentException();
//         int count = 1;
//         int cur = nums[0];
//         for(int i = 1; i < nums.length; i++){
//             if(count == 0){ // 新进来的数字，count为0
//                 count++;
//                 cur = nums[i];
//             }else if(cur == nums[i]){ //重复出现的数字，非新，count++
//                 count++;
//             }else{ //遇到 cur != nums[i],别的数字，抵消count
//                 count--;
//             }
//         }
//         return cur; //输出majority nujmber
//     }
// }

// sol2, hashmap use extra space
class Solution{
    public int majority(int[] nums){
        if(nums == null) throw new IllegalArgumentException();
        Integer res = null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            if(!map.containsKey(n)){
                map.put(n, 1);
            }else{
                map.put(n, map.get(n) + 1);
            }
            if(map.get(n) > nums.length / 2){
                res = n;
                break;
            }
        }
        return res;   
    }
}

/**
 * 1/3? 1/4? 1/k?
 * hashmap<key = candidate, value = count>
 * step1, scan from left to right, update hashmap
 * step2, scan hashmap key set, find the count > size/2 return key,, break for loop if you find 1
 * step2, scan hashmap key set, find the count > size/3 add key,, break for loop if you find 3-1, 最多3-1个，最少0个
 * step2, scan hashmap key set, find the count > size/k add key,, break for loop if you find k-1， 最多k-1个，最少0个
 * 
 * step1 + step2  -> one pass
 * for(Key key : map.setKey()){
 * 
 * }
 * 
 * 
 * 1/3 by using voting alg
 * 
 * 1/3大，最少0个，最多2个
 * 3  3  1  2  2  3  1  1
 * 有空的就塞进空的，没有空的就2个都抵消一次
 * exp
 * 先3进去，<3,1> 第二个空<>
 * 3再进去，<3，2> 第二个空
 * 1再进去，<3, 2>, 占了空<1, 1>
 * 2再进去，两个都抵消一下，<3, 1>, <1, 0>
 * 2再进去，<3, 1>, 占了空<1, 0>变成<2, 1>
 * 3再进去，<3, 2>, <2, 1>
 * 1再进去, 两个都抵消一下，<3, 1>, <2, 0>
 * 1再进去，<3, 1>, 占了空<2, 0>变成<1, 1>
 * 结果<3, 1> <1, 1>
 * 
 * 只能证明是出现次数比较多的，不代表是majority number， 所以需要做 post possessing
 * 
 */

 class Solution{
     public List<Integer> majority(int[] nums){
         List<Integer> list = new ArrayList<>();
         if(nums == null || nums.length == 0) return list;
         int count1 = 0; // 计算第数字出现的次数
         int count2 = 0; 
         int m1 = 0; // 出现超过1/3次数的数字分别是m1, m2
         int m2 = 0;
         for(int i = 0; i < nums.length; i++){
             if(m1 == nums[i]){  // 若出现，count累加
                 count++;
             }else if(count == 0){ // 若被抵消到0，则新数字代替，从新count = 1
                 m1 = nums[i];
                 count = 1;
             }else if(m2 == nums[i]){
                 count2++;
             }else if(count2 == 0){
                 m2 = nums[i];
                 count2 = 1;
             }else{ // 进行抵消
                 count1--;
                 count2--;
             }
         }
         // count 用来计算出现次数，最终辅助得出2个可能大于 1/3 的数字, count清理，做post possessing
         count1 = 0;
         count2 = 0;
         // 从input里loop一遍，对选出的 m1, m2 进行计数，看看是不是真的 大于1/3
         for(int n : nums){
             if(m1 == n) count1++;
             else if(m2 == n) count2++;
         }
         //大于 1/3 才加进去，因为大于1/3的数可以有0个， 1个，最多2个。
         if(count1 > nums.length/3) list.add(m1);
         if(count2 > nums.length/3) list.add(m2);
         return list;
     }
 }
