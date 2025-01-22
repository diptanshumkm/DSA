import java.util.*;

public class validPalindrome {

    public static void main(String[] args) {
// --------------------------------------------------------------Optimal O(n) ----------------------------------------------------
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string of which you have to check palindrome: ");
        String s = scan.nextLine();
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        char words[] = s.toCharArray();
        char dummy[] = new char[words.length];
        int j = 0;
        for (int i = (words.length - 1); i >= 0; i--) {
            dummy[i] = words[j];
            j++;
        }
        System.out.println("Reversed string: " + new String(dummy));

        if (Arrays.equals(words, dummy)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
        scan.close();

    }

}
