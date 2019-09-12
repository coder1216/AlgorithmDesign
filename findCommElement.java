/*
clarify:
type?
sorted or unsorted?
ascending or descending
duplicate? every array / global
size of each array 
resource limitation size array1 100G array2 100G memory 1G
positive vs negative

exp
m 1, 3, 5, 5, 5, 7
n 2, 4, 5, 5, 6, 7, 10, 12

Sorted ascending O(m+n) O(1)

S1 two pointers whol small move who
O(m+n)

S2 binary search
if m << n
m中的值一一对n做binary search
binary search takes logn
m中所有的值都做一次 mlogn

s1, s2 who is better depends on  size 

s3 hashset O(M + N) space O(m)
hashset the shorter array into hashset O(m)
loop the longer array to find common element O(n)

if it is unsorted arrays
Binary search
if m << n
m -> mlogm + nlogm(n loop m) = (m+n)logm
or
n -> nlogn + mlogn(m loop n) = (m+n)logn

*/

