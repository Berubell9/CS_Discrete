import java.util.Scanner;
import java.util.Stack;

public class Lab3 {
    public void InfixToPostfix(String infix){
       
        System.out.println("Infix : "+infix);
        String[] infixSub = infix.split(" ");
        for(String s : infixSub){
            System.out.println(s);
        }
        Stack<Character> stack = new Stack<>();
        StringBuffer buffer = new StringBuffer();
        for(String s : infixSub){

        }
    }
    public  void InfixToPrefix(){
        
    }
    public  void InfixToExpressionTree(String infix){
        
    }
}
