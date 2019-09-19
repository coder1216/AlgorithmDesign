/**
 * 
 * random5 → random25
0
1
2
3
4

random5 + random5
0                    	0
1		1
2		2
3		3
4		4

random5 + random5 ＋ 5
0                    	5
1		6
2		7
3		8
4		9

random5 → random25 → random21 → random7
random5 * 5 + random5
0                    	0
5		1
10		2
15		3
20		4

0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 /21 22 23 24
/3	%7

 * random 25 0 ~ 24
 * random 21, 0 ~ 20
 * 从random 25 到 21，就是random25 舍去21~24，if call到了 21~24，就重新来过
 * 
 * 把0，1，2当做0，3，4，5等于1，在等概率条件条，把3个当做一个小但愿，对7取余或者除以3，采用hash code映射方案，得到random7
 * 
 * 
 */
// s1, recursion
 class Solution{
     public int random7(){
        int val = random5() * 5 + random5();
        if(val > 20) return random7(); // 如果没有取到 重来一次
        return val % 7; // return val / 3; 
     }
 }

 public int random7(){
    int val = random5() * 5 + random5();
    if(val > 20) return random7();
    return val / 3;
}

 // s2, in case stack overflow
class Solution(){
     public int random7(){ 
         while(true){
             int val = random5() * 5 + random5();
             if(val > 20) continue;
             return val % 7 // return val / 3;
         }
     }
 }

 public int random7(){
     while(true){
         int val = random5() * 5 + random5();
         if(val > 20) continue;
     }
     return val / 3;
 }

 /**
  * 用 random m 得到 random n
  m 和 n 谁大
  m 是不是远大于 n

  如果m只是稍微大于n， 只要把大于的那几个数字删掉就好了，比如摇到了重新摇
  如果远大于,就取n的整数倍
  

  random2 -- random n

0 1个 random2
1 1个 random2
3 2个 random2
7 3个 random2
.
.
.
255 8个 random2 然后删掉多余的56个

rand(2) * 2^0 + rand(2) * 2^1 + rand(2) * 2^2 + ... + rand(2) * 2^31

10 bit → 1024 → 1000 1k	→ 1k
20 bit → 1024 * 1024 → 1 million	→ 1M
30 bit → 1024 * 1024 * 1024 → 1 billion	→ 1G			1Byte →  8bit


  */
