/*

substring / subarray   连续的

subsequence 可以是不连续的

Longest Substring/subarray/subsequence between two string.
dp[i][j] represents longest common substring / subarray of first i letters from s1, and first j letters from s2, including s1[i-1], s2[j-1]

dp[i][j] = dp[i-1][j-1]        if s1[i - 1] == s2[j - 1]
         = 0                   otherwise

exp 
yougetoffer
     i
yougetreject
     j

dp[i - 1] 和 dp[j - 1] 相同，dp[i][j] = d[i-1][j-1] + 1


如果是 subsequent 就不一样
exp

yougetoffer
         i
yougetreject
         j



一直走到e为止，后面不再有相同的元素了，sequence 可以跳过中间不同的 结果就是前面youget再加上最后e得到

            g e t o f f  e  r
I           0 0 0 0 0 0  0 0
g           1 x 0 x1 2   3 4 5
e           y x x 2 x    x x x	 y x x x1 x x x x x
t           y z 3 3 			          y z z
r
e
j                      x  x  x



dp[i][j] represents longest common susequence of first i letters from s1, and first j letters from s2, not must including s1[i-1], s2[j-1]

dp[i][j] = dp[i-1][j-1] + 1                  if s1[i-1] == s2[j-1]
         = max(dp[i-1][j], dp[i][j-1])       otherwise

*/

