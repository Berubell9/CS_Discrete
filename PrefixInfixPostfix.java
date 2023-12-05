import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
class Node{
    String data;
    Node left,right;
    public Node(String data){
        this.data = data;
        left = right = null;
    }
}
public class PrefixInfixPostfix {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false; 
        }
        return pattern.matcher(strNum).matches();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Queue<String> postfix = convertInfixToPostfix(str);
        Node tree = expressionTree(postfix);
        System.out.print("Infix : ");
        inorder(tree);
        sc.close();
    }

    public static int compareOperator(String ope){
        if(ope.equals("+") || ope.equals("-")){
            return 1;
        }
        else if(ope.equals("*") || ope.equals("/")){
            return 2;
        }
        return 0;
    }
    public static Queue<String> convertInfixToPostfix(String str) {
        Stack<String> stk = new Stack<>();
        Queue<String> que = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens()) {
            String t = st.nextToken();
            if(isNumeric(t))
                que.add(t);  
            else {
                if(t.equals("(")) {
                    stk.push(t);
                }
                else if(t.equals(")")) {
                    do {
                        que.add(stk.pop());
                    } while (!stk.peek().equals("("));
                    stk.pop();
                }
                else if(stk.isEmpty()){
                    stk.push(t);
                }
                else {
                    if(compareOperator(stk.peek()) < compareOperator(t)){
                        stk.push(t);
                    }
                    else if(compareOperator(stk.peek()) >= compareOperator(t)){
                        que.add(stk.pop());
                        stk.push(t);
                    }
                }
            }
        }
        while(!stk.isEmpty()){
            que.add(stk.pop());
        }
        return que;
    }
    public static boolean isOperator(char ch){
        if(ch=='+' || ch=='-'|| ch=='*' || ch=='/' || ch=='^'){
            return true;
        }
        return false;
    }
    public static Node expressionTree(Queue<String> postfix){
        Stack<Node> st = new Stack<Node>();
        Node t1,t2,temp;
        while(!postfix.isEmpty()){
            if(!isOperator(postfix.peek().charAt(0))){
                temp = new Node(postfix.remove());
                st.push(temp);
            }
            else{
                temp = new Node(postfix.remove());
                t1 = st.pop();
                t2 = st.pop();
                temp.left = t2;
                temp.right = t1;
                st.push(temp);
            }
        }
        temp = st.pop();
        return temp;
    }
    public static void inorder(Node root){
        if(root==null) return;
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
//5 + 3 * 6 / ( 7 + 1 - 2 * 3 )
//10 + 3 * 5 / ( 16 - 4 )
