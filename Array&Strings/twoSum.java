import java.util.Scanner;
import java.util.HashMap;

public class twoSum {   
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array: ");
    int size = sc.nextInt();
    int nums[] = new int[size];

    System.out.println("Enter " + size + " elements in array.");
    for(int i = 0; i<size; i++ ){
        nums[i] = sc.nextInt();
    }     

    System.out.println("You have entered following elements: ");
    for(int num: nums){
        System.out.println(num + " ");
    }

    System.out.println("Enter the target: ");
    int target = sc.nextInt();

    // ---------------------------------BRUTE FORCE SOLUTION TC O(n^2)------------------------------------
    // int outputA = -1;
    // int outputB = -1;
    // for(int i = 0; i<size; i++){
    //     for(int j = i+1; j < size; j++){
    //         if (nums[i] + nums[j] == target) {
    //             outputA = i;
    //             outputB = j;
    //         }
    //     }
    // }
    // System.out.println("{" + outputA + ","+ outputB + "}");



    // ---------------------------------------------OPTIMIZED SOLUTION TC O(n)-------------------------------------------
    
    HashMap <Integer, Integer> myMap = new HashMap<>();
    
    for(int i=0; i<size; i++){

        int complement = target - nums[i];
        if (myMap.containsKey(complement)) {
            System.out.println("Indices of two numbers: "+ "{" + i + "," + myMap.get(complement) + "}");            
            return;
        }
        myMap.put(nums[i], i);
    }
    System.out.println("No solution found!");

    sc.close();
} }
