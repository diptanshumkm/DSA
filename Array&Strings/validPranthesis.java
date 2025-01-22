import java.util.Scanner;
import java.util.Stack;

public class validPranthesis {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string that you want to identify valid prantheses: ");
        String s = scan.next();

        Stack<Character> myStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                myStack.push(s.charAt(i));
            } else {
                if (myStack.empty()) {
                    System.out.println("Invalid Sting");
                    return;
                }
                char c = myStack.peek();
                if ((s.charAt(i) == ')' && c == '(') || (s.charAt(i) == ']' && c == '[')
                        || (s.charAt(i) == '}' && c == '{')) {
                    myStack.pop();
                } else {
                    System.out.println("Invalid String");
                    return;
                }

            }

        }
        if (myStack.empty()) {
            System.out.println("Valid String");
        } else {
            System.out.println("Invalid String");
        }
        scan.close();

    }

}