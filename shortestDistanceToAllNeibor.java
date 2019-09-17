/*
k neibours, some 障碍物，where to build you hospital  -> only nodes NO
how to simulate? 2D Matrix

xxxn1xxxxxxxxxxxxxxx
xxxxxxxxxxxxxxxxxxx
xxxn3xxxxxoxxxxxxxxx
xxxn1xxxxxHxxxn2xxxxx
xxxxxxxxxxxxxxxxxxx
xxxn4xxxxxxxxxxxxxxx
xxxxxxxxxxxxoxxxxxx

最短距离等权重BFS
不等权重 Dij

for every possible hospital position say x, caculate the sm of shortest distance to all neis close to min
n个位置，k个neibours
n-k种可能性
O((n-k)*n)

for every possible neis position say x, caculate the sm of shortest distance to all possible hospital position

O(k*n)


 

*/ 