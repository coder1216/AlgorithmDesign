/**
 * 两次
 * 1  1      p*p
 * 1  0      p*(1-p)    return 1
 * 0  1      (1-p)*p    return 0
 * 0  0      (1-p)*(1-p)
 */

 int yaoHao()

 // s1, recursion
 class Solution{
     public int myYaoHao(){
         //没有base case 因为 肯定会有概率发生 肯定会call 到停止
         int val1 = yaoHao();
         int val2 = yaoHao();
         if(val1 == 1 && val2 == 0){
             return 1;
         }else if(val1 == 0 && val2 == 1){
             return 0;
         }
         // call 到 stack overflow 结束 or 改写成while loop
         return myYaoHao(); // 我要的结果是 1和 0，如果落到了不要的结果 p*p 和 (1-p)*(1-p)，就再摇一次，recursion 直到得到我要的
     }
 }

 // s2, in case stack overflow
 class Solution{
     public int myYaoHao(){
         int val1 = yaoHao();
         int val2 = yaoHao();

         while(true){
             if(val1 == 1 && val2 == 0){
                 return 1;
             }else if(val1 == 0 && val2 == 1){
                 return 0;
             }else if(val1 == 1 && val2 == 1){
                 continue;
             }else if(val1 == 0 && val2 == 0){
                 continue;
             }
         }
         return myYaoHao();
     }
 }