import java.util.*;

public class intToRoman {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the integer: ");
        int intValue = scan.nextInt();
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        String result = "";
        for(int key: map.keySet()){

            while (intValue >= key) {
                intValue = intValue-key;
                result= result.concat(map.get(key));
            }

        }

        System.out.println("Roman value: "+ result);

        scan.close();


    }
}
