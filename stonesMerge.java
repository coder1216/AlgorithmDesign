/*
LC 1000
Stone Merge
只有相邻的才可以merge

2 3 5 4
exp 先2和3merge等于5 然后5 和5merge 等于10 然后10 和14merge等于14 然后全加起来 等于cost
5 + 10 + 14 = 29
exp 先3 和5 merge等于8，然后8和4merge等于12，然后12和2merge等于14，然后全部加起来等于cost
8 + 12 + 14 = 34

if 任何merge  -> greedy


do[i][j] the smallest cost to deal with the stone from i to j
dp[i][j] = cost(i, j) + min(dp[i][j] + dp[k][j]) for every possible k

*/