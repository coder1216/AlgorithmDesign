/**
 * 
 * implement stack by ListNode
 * 
 */
class Solution{
    public void myStack(ListNode node){
        private ListNode<Integer> head;

        public void myStack(){
            head = new ListNode(0);
        }

        public void push(int val){
            ListNode<Integer> newNode = new ListNode(val);
            // stack 先进后出
            newNode.next = head;
            head = newNode；
            if(head == null){
                throw new IllegalArgumentException();
            }
        }
        public void peek(){
            if(head == null) return null;
            return head.val;
        }

        public int pop(){
            if(head == null) throw new IllegalArgumentException();
            ListNode<Integer> dummy = head;
            head = head.next;
            dummy.next = null;
            return dummy.val;
        }
    }
}