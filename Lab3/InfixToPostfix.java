package Lab3;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
public class InfixToPostfix {
    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static boolean isNumeric(String strNum) {
        if (strNum == null) 
            return false; 
        return pattern.matcher(strNum).matches();
    }
    public static void InfixToPostfixConversion(String infix){
        MyQueueL que = new MyQueueL();
        MyStackLString stk = new MyStackLString();
        StringTokenizer st = new StringTokenizer(infix);
        while(st.hasMoreTokens()) {
            String t = st.nextToken();
            if(isNumeric(t)) {
                que.enqueue(t);
            }  
            else {
                if(t.equals("(")) {
                    stk.push(t);
                }
                else if(t.equals(")")) {
                    do {
                        que.enqueue(stk.pop());
                    } while (!stk.top().equals("("));
                    stk.pop();
                }
                else if(stk.isEmpty()){
                    stk.push(t);
                }
                else {
                    if(compareOperator(stk.top()) < compareOperator(t)){
                        stk.push(t);
                    }
                    else if(compareOperator(stk.top()) >= compareOperator(t)){
                        que.enqueue(stk.pop());
                        stk.push(t);
                    }
                }
            }
        }
        while(!stk.isEmpty()){
            que.enqueue(stk.pop());
        }
        System.out.print("Postfix : ");
        while(!que.isEmpty()){
            System.out.print(que.dequeue()+" ");
        }
    }
    public static int compareOperator(String ope){
        if(ope.equals("+") || ope.equals("-")){
            return 1;
        }
        else if(ope.equals("*") || ope.equals("/")){
            return 2;
        }
        else if(ope.equals("^")){
            return 3;
        }
        return 0;
    }
}

