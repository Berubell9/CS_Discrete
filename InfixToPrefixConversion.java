import java.util.*;

public class InfixToPrefixConversion {
    public static int compareOperator(char op) {
        // switch (op) {
        //     case '+':
        //     case '-':
        //         return 1;
        //     case '*':
        //     case '/':
        //     case '%':
        //         return 2;
        //     case '^':
        //         return 3;
        // }
        // return -1;
        if(op == '+' || op == '-' ){
            return 1;
        }
        else if(op == '*' || op == '/' ){
            return 2;
        }
        else if(op == '^'){
            return 3;
        }
        return -1;
    }

    public static String infixToPrefix(String infix) {
        String prefix = "";
        Stack<Character> operators = new Stack<>();
        for (int i = infix.length() - 1; i >= 0; --i) {
            char ch = infix.charAt(i);
            if (compareOperator(ch) > 0) {
                while (operators.isEmpty() == false && compareOperator(operators.peek()) > compareOperator(ch)) {
                    prefix += operators.pop();
                }
                operators.push(ch);
            }else if (ch == '(') {
                char x = operators.pop();
                while (x != ')') {
                    prefix += x;
                    x = operators.pop();
                }
            } else if (ch == ')') {
                operators.push(ch);
            } else {
                prefix += ch;
            }
        }
        while (!operators.isEmpty()) {
            prefix += operators.pop();
        }
        String reversedPrefix = "";
        for (int i = prefix.length() - 1; i >= 0; i--) {
            reversedPrefix += prefix.charAt(i);
        }
        return reversedPrefix;
    }

    public static void main(String[] args) {
        String exp = "5 + 3 * 6 / ( 7 + 1 - 2 * 3 )";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Prefix Expression:" + infixToPrefix(exp));
    }

}
