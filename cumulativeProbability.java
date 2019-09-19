/**
 * 
 * Q6 Cumulative Probability
Recall: Majority Number ½ ⅓ 1/k → 1 1 1 3 3 3 5 5 3 3 3 5 5 3 3 → QA Test to meet the percentile of customers such as the browser support.
a, 40%
b, 20%
c, 10%
d: 3%
other: 

Country getCountry() {
	
}

<China, Poputation> 7
<US, Poputation> 2
<Japan, Poputation> 1

 * 
 *  [0, PCahina) [Pchina ~ Pchina + PUS) → 239823192
       0   7	9	10
    CN	    US	    JP

 * 使用hashmap
 * 分成3段，起点不同但是间距相同，一一对应关系不是range，是起点，左闭右开，取小于等于
 * 
 * 
 * implement random without random method
 *  
 * random(n) 可以由 random(2)得到，random(2) 可以由 getCurrentTime() % 2得到
 * 因为自然界中even和odd是等概率，所以可以用系统时间取余得到0 和 1来完成 random(2) 从而完成random(n)
 * 
 * 因为计算机是2进制，所以对2取余random(2)
 * 
 * sol2，基于sol1, 可以直接getCurrentTime() % n 得到 random(n)
 */