package Lab3;
import java.util.*;
public class InfixToPrefix {
    public static void InfixToPrefixConversion(String infix){
        String prefix = "";
        Stack<Character> operators = new Stack<>();
        for (int i = infix.length() - 1; i >= 0; --i) {
            char ch = infix.charAt(i);
            if (precedence(ch) > 0) {
                while (operators.isEmpty() == false 
                && precedence(operators.peek()) >= precedence(ch)) {
                    prefix += operators.pop();
                }
                operators.push(ch);
            }else if (ch == '(') {
                char bracket = operators.pop();
                while (bracket != ')') {
                    prefix += bracket;
                    bracket = operators.pop();
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
        System.out.println();
        System.out.println("Prefix : "+reversedPrefix);
    }
    public static int precedence(char ope) {
        if(ope == '+' || ope == '-' ){
            return 1;
        }
        else if(ope == '*' || ope == '/' ){
            return 2;
        }
        else if(ope == '^'){
            return 3;
        }
        return -1;
    }
}
