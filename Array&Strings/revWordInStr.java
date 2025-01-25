import java.util.*;
public class revWordInStr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the str to be reversed");
        String dum = scan.nextLine();
        // reversed Input string
        String ipRevrsdStr = new StringBuilder(dum).reverse().toString();
        StringBuilder answer = new StringBuilder("");
        StringBuilder word = new StringBuilder("");
        for(int i=0; i < ipRevrsdStr.length(); i++){

            while (i < ipRevrsdStr.length() && ipRevrsdStr.charAt(i)!= ' ') {
                word.append(ipRevrsdStr.charAt(i));
                i++;
            }
            word = word.reverse();

            if (word.length() > 0) {
                answer.append(" "+ word);
                word.setLength(0);
            }


        }
        System.out.println("Answer: " + answer.toString().trim());

        scan.close();
}}