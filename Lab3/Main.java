package Lab3;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Infix : ");
        String str = sc.nextLine();
        
        InfixToPostfix a = new InfixToPostfix();
        a.InfixToPostfixConversion(str);
        
        InfixToPrefix b = new InfixToPrefix();
        b.InfixToPrefixConversion(str);
        sc.close();
    }
}
//5 + 3 * 6 / ( 7 + 1 - 2 * 3 )
//10 + 3 * 5 / ( 16 - 4 )