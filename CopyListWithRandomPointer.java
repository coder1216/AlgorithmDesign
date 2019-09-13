import java.util.HashMap;

/*
deep copy skipList

shallow  copy vs deep copy -> array
reference vs de -> reference's field



stack                        heap
s1                           student1 object
s2                           student2 object

s2 = s1;


1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
cur

1'  2'   3'
cur'


for()  map.get(cur).next = map.get(cur.next);

ListNode{
    int val;
    ListNode next;
    ListNode random / forward;
}

for()  map.get(cur).next = map.get(cur.next);

    cur1
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
|              |
|______________|


1' -> 2' -> 3' -> 4' -> 5' -> 6' -> null
|                 |
|_________________|


S0, 
check target node exists or not
first pass, build the hashmap for the relationship from the original node to the new node;

s1, 
no need to check target node exists or not 
first pass, deep copy node and record into map, and update next

problem: if a target node has been allocated yet and the allocated node's reference
HashMap <key original node reference, value copied node reference>
HashMap <key original node, value copied node>

S2,
check target exist or not
step1 copy current node, record relationship into hashmap,
step2 if(exist or not) update next, and update forward to build hashmap, 
for loop make a copy of the linked list with next pointer and forward pointer
using hashmap to check the forward or next pointer exist in the hashmap or not.
if exist, get the copied node's reference and assign to forward / next

s3,
// 1 forward 4, now we want 1' forward 4'
1 1' 2 2' 3 3' 4 4'
cur
cur.next.forward = cur.forward.next
*/
// sol2
class Solution{
    // cur1 = head;
    // cur2 = dummy;
    public ListNode copyPointer(ListNode cur1, ListNode cur2){
        if(cur1 == null && cur2 == null){
            return null;
        }
        Map<ListNode, ListNode> map  = new HashMap<>();
        while(cur1 != null){
            if(!map.containsKey(cur1)){
                map.put(cur1, new ListNode(cur1.val));
            }
            cur2.next = map.get(cur1);

            if(cur1.forward != null){
                if(!map.containsKey(cur1.forward)){
                    map.put(cur1.forward, new ListNode(cur1.forward.val));
                }
                cur2.next.forward = map.get(cur1.forward);
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        } 
    }
}


/*
while(cur1 != null){
    if(!map.containsKey(cur1)){
        map.put(cur1, new ListNode(cur1.val));
    }
    cur2.next = map.get(cur1);
    if(cur1.forward != null){
        if(!map.containsKey(cur1.forward)){
            map.put(cur1.forward, new ListNode(cur1.forward.val));
        }
        cur2.next.forward = map.get(cur1.forward);
    }
    cur1 = cur1.next;
    cur2 = cur2.next;
}
*/