import java.util.*;

public class containerWater {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size = scan.nextInt();

        System.out.println("Enter the elements of array: ");
        int height [] = new int[size];
        
        for(int i=0; i <size; i++){
            height[i] = scan.nextInt();
        }

        // -------------------------------------------------------BRUTE FORCE O(n^2)--------------------------------------
        int maxArea = 0;
        for(int i = 0; i< size; i++){
            
            for(int j = i+1; j<size; j++){
                
                int len = (j - i);
                int breadth = Math.min(height[j], height[i]);
                int area = (len*breadth);
                maxArea = Math.max(area, maxArea);
            }
        }

        System.out.println("Maximum area: " + maxArea);


        // --------------------------------------------------------OPTIMIZED SOLUTION O(N)---------------------------------------------
        // int left = 0;
        // int right = (size-1);
        // int maxArea = 0;

        // while (left < right) {

        //     int len = (right - left);
        //     int breadth = Math.min(height[left], height[right]);
        //     int area = (len * breadth);

        //     maxArea = Math.max(area, maxArea);
            
        //     if (height[left] < height[right]) {
        //         left++;
        //     }else {
        //         right--;
        //     }
        // }
        // System.out.println("Maximum area: " + maxArea);



        scan.close();
    }
}