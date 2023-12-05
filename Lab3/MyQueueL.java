package Lab3;
public class MyQueueL {
    Node head = null, tail = null;
    public class Node {
        String data;
        Node next;
        public Node(String d) {
            data = d;
        }
    }

    public void enqueue(String d) {
        Node p = new Node(d);
        if(head == null) {
            head = tail = p;
        }
        else {
            tail.next = p;
            tail = tail.next;
        }
    }

    public String dequeue() {
        String d = head.data;
        head = head.next;
        return d;
    }

    public String front() {
        return head.data;
    }

    public boolean isFull() {
        return false;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("top ");
        Node p = head;
        while (p!=null) {
            sb.append("--> [");
            sb.append(p.data);
            sb.append("] ");
            p = p.next;
        }
        sb.append("--> tail");
        return new String(sb);
    }

    public static void main(String[] args) {
        MyQueueL que = new MyQueueL();
        System.out.println("Queue is Empty ? : "+que.isEmpty());
        que.enqueue("5");
        que.enqueue("2");
        que.enqueue("9");
        que.enqueue("-1");
        System.out.println("Queue is Empty ? : "+que.isEmpty());
        System.out.println("Queue is Full ? : "+que.isFull());
        System.out.println("Queue have : "+que.toString());
        System.out.println("Dequeue #1 : "+que.dequeue());
        System.out.println("Dequeue #2 : "+que.dequeue());
        System.out.println("Front ? : "+que.front());
        que.enqueue("15");
        System.out.println("Queue have : "+que.toString());
    }
}
