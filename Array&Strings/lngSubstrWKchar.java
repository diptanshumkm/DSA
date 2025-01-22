import java.util.*;

public class lngSubstrWKchar {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = scan.next();

        System.out.println("Enter the k: ");
        int k = scan.nextInt();

        HashMap <Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        // ------------------------------------------------------------BRUTE FORCE ------------------------------------------

        // for(int i =0; i < (s.length()); i++){
        //     map.clear();
        //     for(int j=i; j<(s.length()); j++){
                
        //         if (map.containsKey(s.charAt(j))) {
        //             map.put(s.charAt(j) , map.get(s.charAt(j))+1);
        //         }else{
        //             map.put(s.charAt(j), 1);
        //         }


        //         if(map.size() <= k){
        //             maxLength = Math.max(maxLength, (j-i+1));
        //         }else{
        //             break;
        //         }
        //     }
        // }
        // System.out.println("Length of longest subStr: " + maxLength);

        // ----------------------------------------------------------------------Optimized Solution------------------------------

        int start =0; 
        int end =0;

        while (end < s.length()) {
            
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);

            while (map.size() > k) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1); 
                if (map.get(startChar) == 0) { 
                    map.remove(startChar);
                }
                start++; 
            }

            if (map.size() <= k) {
                maxLength = Math.max(maxLength, end-start+1);
            }

            end++;
        }
        System.out.println("answer: "+maxLength);


        scan.close();
    }
    
}