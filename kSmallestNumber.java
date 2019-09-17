/*
kth smallest number in f(x, y, z) = a^x + b^y + c^z (x,y,z >= 0, a,b,c > 1)
extension1 -> x, y, z <= 0
extension2 -> a, b, c <= 0
extension3 -> ax + by + cz   a > 0, b < 0, c > 0

<0, 0, 0>
<0, 0, 0>  -> <1, 0, 0>, <0, 1, 0>, <0, 0, 1>
<1, 1, 1>

1, define the cost f(x, y, z)
2, start state < x=1, y=1, z=1>
3, expand/generate rule <i, j, m> -> <i+1, j, m> <i, j+1, m>, <i, j, m+1>
terminate kth poll()
duplicate(visited) hashSet, hashed, i * n^2 + j * n + m, n at most k vs List<Integer> / int[]
Time K * 4logk  -> O(klogk)
Space O(2k) + O(3k)  -> O(k)
 
*/