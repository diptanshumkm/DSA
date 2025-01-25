import java.util.HashMap;
import java.util.Scanner;

public class twoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (myMap.containsKey(complement)) {
                return new int[]{myMap.get(complement), i};
            }
            myMap.put(nums[i], i);
        }
        
        return new int[]{-1, -1}; // No solution found
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int size = sc.nextInt();
        
        int[] nums = new int[size];
        
        System.out.println("Enter " + size + " array elements:");
        for(int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }
        
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();
        
        int[] result = twoSum(nums, target);
        
        if (result[0] != -1) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No solution found!");
        }
        
        sc.close();
    }
}