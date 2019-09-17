/*
Trapping Rain Water
接雨水
input按高度给


S1, 
for every bar, find min(left_max, right_max)
Time O(n^2) Space O(1)


S2,
scan from left to right update left_max, then right_max array
接雨水，从左往右看，左边的肯定要比右边小才可以接,不然就漏掉了
left_max = [0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3]
接雨水，从右往左看，右边的肯定要比左边大才可以接， 不然就漏掉了
right_max = [3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1]

结果取左右两边最小值
minMax = [0, 1, 1, 2, 2, 2, 2, 3, 2, 2, 2, 1]
 
water +=
for loop water += min(left_max[i], right_max[i]) - height[i]
time O(n)
space O(n)

s3,
left, right, who's max small move who
case1, if left_max < right_max, left++, update left_max to minMax if possible
case2, if left_max > right_max, right--, update right_max to minMax if possible
case3, left_max == right_max, left++, right++, update

time O(n)
space O(n)

s4, O(n) O(1)
int left = 0;
int right = 0;
int left_max_sofar = 0;
int right_max_sofar = 0;
int water = 0;

while(left <= right){
    left_max = max(left_max, height[left]);
    right_max = max(right_max, height[right]);
    if(left_max < right_max){
        water += (left_max - height[left]);
        left++;
    }else{   // 因为可能有多个 peek，所以会出现重复计算，所以index left = right时，统一只移动一边
        water += (right_max - height[right]);
        right--;
    }
}


2D trapping Rain Water

[
    [1, 4, 3, 1, 3, 2],
    [3, 5, 1, 1, 2, 4],
    [2, 3, 3, 2, 3, 1]

]




*/