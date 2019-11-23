/**
 * 
 * dp[i][j] 表示从i到j先手拿球的人所能拿到的最大的值
 * dp[i][j] max =  (sum[i+1, j] - dp[i+1][j] + val[i] , sum[i, j-1] - dp[i][j-1] + val[j]) ;
 * dp[i][j] = val[i];     
 * 
 */

 class Solution{
     public boolean firsWillWin(int[] values){
         if(values == null || values.length == 0) return false;
         if(values.length <= 2) return true;

         int len = values.length;
         int sum = values[len - 1];
         int dp[] = new int[len];
         dp[len-1][len-1] = values[len-1];
        int sum = 0;
         for(int i = len-1; i >= 0; i--){
             sum += val[i];
             for(int j = 1; j < len; j++){
                 if(i == j){
                    dp[i][j] = val[i];
                    continue;
                 }
                 int a = (i+2 > j - 1)? 0 : dp[i+1, j];
                 int b = (i+1 > j - 1)? 0 : dp[i+1, j-1];
                 int c = (i > j - 2)? 0: dp[i, j-2];
                 dp[i][j] = max(val[i] + Math.min(a,b), val[j] + Math.min(b,c));
             }
         }
         return dp[0][len-1] > sum;
     }
 }