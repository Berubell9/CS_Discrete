package Lab3;
// 64050152 Piyawach Muensri
public class MyStackLString {
    Node top = null;
    public class Node {
        String data;
        Node next;
        public Node(String d) {
            data = d;
        }
    }

    public void push(String d) {
        Node p = new Node(d);
        p.next= top;
        top = p;
    }

    public String pop() {
        String d = top.data;
        top = top.next;
        return d;
    }

    public String top() {
        return top.data;
    }

    public boolean isFull() {
        return false;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("top ");
        Node p = top;
        while (p!=null) {
            sb.append("--> [");
            sb.append(p.data);
            sb.append("] ");
            p = p.next;
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        MyStackLString stk = new MyStackLString();
        System.out.println("Stack is Empty ? : "+stk.isEmpty());
        stk.push("9");
        stk.push("5");
        stk.push("1");
        stk.push("3");
        System.out.println("Stack is Empty ? : "+stk.isEmpty());
        System.out.println("Stack is Full ? : "+stk.isFull());
        System.out.println("Stack have : "+stk.toString());
        System.out.println("Pop #1 : "+stk.pop());
        System.out.println("Top ? : "+stk.top());
        System.out.println("Stack have : "+stk.toString());
    }
}