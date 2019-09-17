/*
Stone Cut
exp:
n stonr, mark the possible cutable position at cut[]
cut[] = {0, 2, 6 9, 14}
n = 14
0  1  2  3  4  5  6  7  8  9  10  11  12  13  14
|     |           |        |                   |
0     1           2        3                   4

14 + 6 + 8 = 28    2 -> 1 -> 3
14 + 12 + 8 = 34   1 -> 2 -> 3

S1,
dfs[i, j] = cost[i, j] + min(dfs[i, k] + dfs[k, j])

首先一整块搬上去需要cost，长度从i到j， cost[i, j]
其次从中间切一刀，k, 所以 需要算从 i到k 和 k到j 最小值. min(dfs[i, k] + dfs[k, j])

but 有重复计算

S2, dp

base case: 已经切刀最小，切不动的时候
dp[0][1] = 0
dp[1][2] = 0
dp[2][3] = 0
dp[3][4] = 0

答问题等于小问题加起来，小问题gurantee 历史上一定出现过
dp[0][2] = 6 + dp[0][1] + dp[1][2] //根据上面的图 example
dp[1][3] = 
dp[2][4] = 

dp[0][3] = case1: 9 + dp[0][1] + dp[1][3]
         = case2: 9 + dp[0][2] + dp[2][3]

dp[1][4] = 

状态转移方程
dp[i][j] the smallest cost to deal with the stone from i to j
dp[i][j] = cost(i, j) + min(dp[i][k] + dp[k][j]) for every possible k
dp[0][n]


*/