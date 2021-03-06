/*
LC739
[78, 76, 75, 80, 81, 74, 77]
[3, 2, 1, 1, 0, 1, 0]


exp
[2, 1, 5, 6, 2, 3] 为高度
要找到5的面积，比5大的可以包含，第一个比5小的就是他的边界，然后乘以底的长度
 


S1: 
height: 2, 1, 5, 6, 2, 3
面积： 2, 6, 10, 6, 8, 3
找到每一个的左右边界， 2扫全部，1扫全部，5扫全部...
Time: O(n^2), Space O(1)


s2,
heigh  0  2  1  5  6  2  3  0
index -1  0  1  2  3  4  5  6
left     -1 -1  1  2  1  4
right     1  6  4  4  6  6



先最左和最右两边补0
2的左边界是0，右边界是第一个比自己小的，也就是1
1的左边界是比自己小的，0， 右边边界是比自己小的，0
5的左边边界是比自己小的1，右边边界是2，所以index 是4

all in all 找各个点的左右边界
时间复杂度等于完成表格

Time O(n)
Space O(2n)

*/