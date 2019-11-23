/**
 * dp[i] 表示从i到len-1，先手玩家拿到的最大value
 * 值允许从左边取，可以取1个或者2个，怎么做到先取的人赢
 * A拿i
 * dp[i+1] 表示第二个人取的
 * sum[i+1] 表示第一个人拿完i，剩下的i+1的值
 * sum[i+1] - dp[i+1] + val[i] 表示剩下的减去B，A的值
 * 
 * A拿i和i+1
 * sum[i+2] - dp[i+2] + val[i] + val[i+1]
 * 
 * 
 * 
 * 不用sum
 * a,
 * 当A拿i，B可以拿i+1或者i+1，i+2
 * 当B拿i+1的时候，A可以拿i+2。
 * 当B拿i+1和i+2的时候，A可以拿i+3
 * 因为B拿完了留下来的肯定是不好的，所以从不好的里面取好的取min value
 * dp[i] = val[i] + min(dp[i+2], dp[i+3]); 
 * b,
 * 当A拿i和i+1,B拿i+2 或者 B拿i+2，i+3
 * 当B 拿i+2的时候，A拿i+3
 * 当B拿i+2，i+3的时候，A拿i+4
 * dp[i] = val[i] + val[i+1] + min(dp[i+3] + dp[i+4])
 * 
 * 最后 Math.max(a+b)
 */

