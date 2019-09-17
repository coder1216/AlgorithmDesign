/*

implement stack by listNode

*/

class Solution{
    public void myStack(ListNode node){
        private ListNode head;

        public myStack(){
            head = new LisNode(0);
        } 

        public void push(int val){
            // exp:
            // val - x - x - x 
            // 因为stack先进后出，所以每次都塞在head前面，所以出栈的时候后出
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            if(head == null){
                throw new IllegalArgumentException();
            }
        }

        public int peek(){
            if(head == null){
                return null;
            }
            return head.val;
        }

        public int pop(){
            if(head == null){
                throw new IllegalArgumentException();
            }
            // 进栈的时候不断往head前面加
            ListNode dummy = head;
            head = head.next;
            dummy.next = null;
            return dummy.val;
        }
    }
}