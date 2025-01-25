import java.util.*;

public class grpAnagram {

    public static String sortString(String val) {
        char[] chars = val.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static ArrayList<ArrayList<String>> groupAnagram(String[] arr){
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<ArrayList<String>> answer = new ArrayList<>();

        for (String val : arr) {
            if (val.equals("")) {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(val);
                answer.add(temp);
                continue; // Skip further processing for empty strings
            }

            String sortedStr = sortString(val);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(val);
            } else {
                map.put(sortedStr, new ArrayList<>());
                map.get(sortedStr).add(val);
            }
        }

        // Add all groups from the map to the answer list
        for (Map.Entry<String, ArrayList<String>> e : map.entrySet()) {
            answer.add(e.getValue());
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size = scan.nextInt();
        String arr[] = new String[size];

        System.out.println("Enter the elements of the array: ");
        for(int i=0; i< size; i++){
            arr[i] = scan.next();
        }

        ArrayList<ArrayList<String>> result = groupAnagram(arr);


        System.out.println("Grouped anagram: "+result);

        scan.close();
    }
}
