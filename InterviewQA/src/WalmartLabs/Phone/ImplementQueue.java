package WalmartLabs.Phone;

public class ImplementQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(10);
        queue.offer(1);
        queue.offer(2);
        queue.offer(4);
        queue.poll();
        queue.poll();

        System.out.println(queue.isEmpty());
    }

    public static class MyQueue {
        Node head;
        Node tail;
        int size;
        int cap;

        public MyQueue(int k) {
            size = 0;
            cap = k;

            head = new Node(0);
            tail = new Node(-1);

            head.next = tail;
            tail.prev = head;
        }

        private void offer(int x) {
            if (isFull()) return;

            Node node = new Node(x);

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        private int poll() {
           if (isEmpty()) throw new IllegalArgumentException();

           Node node = tail.prev;

           Node prev = node.prev;

           tail.prev = prev;
           prev.next = tail;

           node.next = null;
           node.prev = null;

           size--;

           return node.val;
        }

        private int peek() {
            if (isEmpty()) throw new IllegalArgumentException();
            return head.next.val;
        }

        private boolean isEmpty() {
            return size == 0;
        }

        private boolean isFull() {
            return size == cap;
        }
    }

    public static class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
            prev = null;
            next = null;
        }
    }
}
