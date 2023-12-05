import java.util.Scanner;
import java.util.Stack;
class InfixToPostfix {
    private String infix;
    private String postfix = "";

    public void convertString(String a) {
        String str = "";
        infix = a;
        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < infix.length(); i++) {
            str = infix.substring(i, i + 1);
            if (str.matches("[a-zA-Z]|\\d"))
                postfix += str;
            else if (isOperator(str)) {
                if (stack.isEmpty()) {
                    stack.push(str);
                } else {
                    String stackTop = stack.peek();
                    while (getPrecedence(stackTop, str).equals(stackTop) && !(stack.isEmpty())) {
                        postfix += stack.pop();
                        if (!(stack.isEmpty()))
                            stackTop = stack.peek();
                    }
                    stack.push(str);
                }
            }
        }
        while (!(stack.isEmpty()))
            postfix += stack.pop();
        System.out.println("Postfix of the expression is: " +postfix+" ");
    }

    private boolean isOperator(String ch) {
        String operators = "^*/%+-";
        if (operators.indexOf(ch) != -1)
            return true;
        else
            return false;
    }

    private String getPrecedence(String op1, String op2) {
        String multiplicativeOps = "^*/%";
        String additiveOps = "+-";
        if ((multiplicativeOps.indexOf(op1) != -1) && (additiveOps.indexOf(op2) != -1))
            return op1;
        else if ((multiplicativeOps.indexOf(op2) != -1) && (additiveOps.indexOf(op1) != -1))
            return op2;
        else if ((multiplicativeOps.indexOf(op1) != -1) && (multiplicativeOps.indexOf(op2) != -1))
            return op1;
        else
            return op1;
    }

    public static void main(String[] args) {

        System.out.println("Enter an expression in the Infix form:");
        Scanner sc = new Scanner(System.in);

        String expression = sc.nextLine();
        new InfixToPostfix().convertString(expression);
        sc.close();
    }
}