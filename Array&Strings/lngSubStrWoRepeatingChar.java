import java.util.*;

public class lngSubStrWoRepeatingChar {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string that you want to identify valid prantheses: ");
        String s = scan.next(); 



        // --------------------------------------------------------Sliding Window--------------------------------------------------
        HashSet<Character> set= new HashSet<>();

        int start = 0; 
        int end = 0;
        int maxLength = 0;

        while (end < s.length()) {
            
            while (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            maxLength = Math.max(maxLength, (end-start+1));
            end++;
        }

        System.out.println("Length of the longest substring: " + maxLength);
        scan.close();
    }
}
