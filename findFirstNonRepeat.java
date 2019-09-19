/*
Given a string, find fitst non-repeating character / first repeating / second non-repeating / second repeating ...

a  b  b  c  d  a  a  b  d  e  f  z  return c
i

s1, 以a(index1)开始，扫一遍，找到，以b(index2)开始，扫一遍找，以b(index3)开始扫一遍...
O(n^2)

hashmap -> int[256] / int[128] / int[26]
traverse 1st time to build hashmap<key = character, value = count>
traverse 2st time to find the first character with count 1, map.get(char[i]) == 1, return chars[i]
Time O(n)
Space O(k)
set.add() -> 1 vs >1
 

s2, bit_map, integer's bit representation 2 pass -> Boolean[26]
用两个hashset，第一个判断有没有这个值，第二个判断这个值有没有重复出现

integer1       0000   0000   0000   0000   0000   0000   0000   1111   有没有出现
integer1       0000   0000   0000   0000   0000   0000   0000   0010   有没有重复



first repeating
case1 先扫一遍，找到reapeating，再扫一遍，找到first repeat

s3, one pass
linkedHashSet, 因为是按时间顺序排列，所以先出现的就firs non-reapeting



*/
// first missing positive LC41
class Solution{
    public int firstMissingPositive(int[] nums){
        // corner case
         for(int i = 0; i < nums.length; i++){
             if(nums[i] != i+1 && nums[i] > 0 && nums[i] <= nums.length){
                 if(nums[nums[i] - 1] == nums[i]) continue;
                 int tmp = nums[nums[i] - 1];
                 nums[nums[i] - 1] = nums[i];
                 nums[i] = tmp;
                 i--;
             }
         }
         for(int i = 0; i < nums.length; i++){
             if(nuims[i] != i + 1) return i + 1;
         }
         return nums.length + 1;
    }
}