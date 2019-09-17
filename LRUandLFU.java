/*
LRU: Least Recently Used based on timestamp
LFU: Leasr Frequently Used based on frequency
MRU: Most **** 同上缩写
MFU: Most **** 同上缩写

local catch 
cpu 中的 l1,l2,l3级 catch， 每级都比上一级快


key value -> url html

2  3  2  4  5  6  5  7  ...


old        new        size       4
         4 6 5 7

case1, check whether the new url is inside the LRU cache or not with O(1), if hits
case2, update the order of the hit url as new one(move to new side), move based on timestamp, return node's value
case3, otherwise not hit O(1)
caseA, if not full, insert the new entry to new side
caseB if full, deleted the oldest entry & insert the new entry new side

linkedList / Array 
Array --> 查找，删除 复杂度太高 不可以 O1 
linkedList --> 找不到前驱
deque 只能头尾两端操作

=> doubleLinkedList 可以从中间操作

hashset  --> 可以O1 找到，但是需要 key 和 url 一一对应，set不行 要hashmap

=> hashmap

所以 
doubleLinkedList + hashmap

<url html>
hashmap: <key = url, value = reference of listnode<url, html> >

APIs:
get(key)  -->  get(ket) return html
put(key, value)  -->  put(url, html) 


if 要排序 基于进hashmap 的时候的 timestamp
linkedHashMap 不仅有hashmap的功能，还有排序能力based on time / linkedHashSet
design LRU
return linkedHashMap 


LFU 基于frequency
hashMap + minHeap
因为 踢掉最小的, 剃掉frequency最低的 

frequency 实时uodate， heap 无法实现update
case1 自己写一个heap， myHeap(reference to heap Node / pup down after updating)? bad -> remove -> treeMap

class HeapNode{
    K key/url; 
    D value/data/html;
    int frequency;

}

hashMap + double linkedList  
1 <=> 2 <=> 3 <=> 4 <=> 5 <=> 6
5     6     7     7     7     8

case1, 如果新来一个frequency， 已满的情况下， 插不进去
case2，如果来了一个frequency为9， 就要删掉一个，如果把最小的5删掉，之后来了2个5，就不是5+2 = 7 而是0+2=2，错了
可以把html文件删掉，5留着继续计数.

以上是和面试官说的
解法 solution: 3个 hashmap


*/