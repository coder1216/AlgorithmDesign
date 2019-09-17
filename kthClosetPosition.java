/*
kth closet position in 2D, 3D, 4D, kD space from m sorted array (all postive number)
array1 2, 4, 7, 9 ... a
          i
array2 1, 3, 8, 11, 14 ... b
       j


1, define the cost a[i] ^ 2 + b[j] ^ 2
2, start state <a[0], b[0]>
3, expand / generate rule <i, j> -> <i+1, j> <i, j+1> with minHeap
4, temination: kth poll()
5, duplication: 歧异需要沟通 1 同一个圆上 2 generate 同一个位置 i j
Time klogk
Space o(k)


*/