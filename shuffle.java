/**
 * 
 * 洗牌 shuffle
 * random(k) → [0, k) integer
step1: number x0 by random(52), swap(x0, 0), P(card in position 0) = 1 / 52
抽到任何一张牌在position 0 的概率 是 1/52

step2: number x1 by random(51) + offset, swap(x1,1), P(card in position 1) = 51/52 * 1/51 = 1/52
第一步没被选中 X 第二步被选中

step3: number x2 by random(50) + offset, swap (x2, 2),  P(card in position 2) = (1 - 1/52) ( 1 - 1/51) * 1/50 = 1 / 52
……..
step52: number x51 by random(1) + offset, swap (x51, 51),  P(card in position 51) = (1 - 1/52) ( 1 - 1/51) … 1 = 1 / 52

洗牌，假设52张，洗好后随即抽一张放在位置1，洗剩下21张，洗好后随即抽一张到位置2，洗剩下的50张

 * 
 */
// 用card.size()不用52 因为不知道有几副牌
 class Solution{
     get(index)
     set(index, card)
     Random random = new Random();
     public void shuffle(){
         for(int i = 0; i < card.size(); i++){
            int val = random.nextInt(card.size() - 1) + i; // 洗牌，假设52张，洗好后随即抽一张放在位置1，洗剩下21张，洗好后随即抽一张到位置2，洗剩下的50张
            Card card1 = card.get(i); // 把洗好的牌取出来
            Card card2 = card.get(val); 
            // 重新排列扑克牌
            card.set(i, card2); // 交换位置,洗好的牌重新按1，2，3，4排列
            card.set(val, card1);

         }
     }
 }

 /**
  * [0, k)
  [0, k)如果是8.99  
  Math.random()  (0, 1]  -> (int) Math.random() * k

  Random
  Random rand = new Random();
  rand.nextInt(k) -> [0, k)
  */
  