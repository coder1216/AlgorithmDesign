/*
longgest ascending/descending/consecutive 1 subarray/subsequence
Q7.1 streaming flow

1  2  4  5  3  7  6  4  5 -> 最长升序subarray 1 2 4 5 最长升序subsequence 1 2 4 5 7 or 1 2 3 4 5
1  2  3  4  1  2  1  1  2

sbuarray sol
dp[i] represents the longest ascending subarray length including/ending with array[i]
dp[i] = 1 + dp[i-1]        if array[i] > array[i-1]
      = 1                  otherwise

time O(n)  space O(1)

subsequence sol


1  2  4  5  3  7  6  4  5 
1  2  3  4  3  5  5  4  5

因为是subsequence，1的时候是1，2的时候是2 .... 到3的时候，3比前面的5小，所以往前看，找比3小的，看到2，2的长度是2，所以3更新为3，然后到7，7往前看，比7小的最大数是5，5的长度加1等于5，7更新为5，一次类推 ...

S1，
dp[i] represents the longest ascending subsequence length including/ending with array[i]
dp[i] = max(dp[k]) + 1, for all the k < i && array[k] < array[i]
Time O(n^2)
Space O(n)


S2, 

            2  1  4  5  3  7  6  4  5
length      1  2  3  4 
value       1  3  4  5

exp，
2进来，没有length为1，value为2
1进来，没有升序，length为1，value为1
4进来，升序，length更新为2，value为1
5进来，升序，length更新为3，value为5
3进来，跳过4，5，从1看是升序，所以length为2，对应length为2的value更新为3
7进来，升序，1， 4， 5再加7，length为4，对应value为7
6进来，1，4，5，6升序，length为4，把7更新成6，value为6
4进来，1，3，4升序，length为3，把3对应value更新为4
5进来，1，3，4，5升序，把length为4的value更新为5

头尾操作，中间更新值 --> 可以用arrayList， 长度即为list.size()
//寻找比当前值小的最大的，更新他的下一个，没有就加上去，有就更新
exp
2进来，比2小的最大的没有，直接为2
1进来，比1小的最大的没有，更新为1
4进来，比4小的最大的为1，有，更新他(1)的下一个，1没有下一个，所以把4放上去  ，1，4
5进来，比5小的最大的为4，有，更新他(4)的下一个，4没有下一个，所以把5放上去，1，4，5
3进来，比3小的最大的为1，有，更新他(1)的下一个，1有下一个，所以把1的下一个4，更新为3，所以得到1，3，5
7进来，比7小的最大的为5，有，更新他(5)的下一个，5没有下一个，所以把7放上去，1，3，5，7
6进来，比6小的最大的为5，有，更新他(5)的下一个，5有下一个，所以把7更新为6，1，3，5，6
4进来，比4小的最大的为3，有，更新他(3)的下一个，3有下一个，所以把5更新为4，1，3，4，6
5进来，比5小的最大的为4，有，更新他(4)的下一个，4有下一个，所以把6更新为5，1，3，4，5

更新后长度为array.size()
TIME O(nlongn)

list -> arrayList
arraylist.get(i): for all the ascending subsequences of length i, what is the minimum of the largest value(the ending position's vbalue) of all such sequences







*/