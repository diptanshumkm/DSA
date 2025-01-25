import java.util.*;
public class plusOne {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size = scan.nextInt();
        int arr[] = new int[size];

        System.out.println("Enter the elements of the array: ");
        for(int i=0; i< size; i++){
            arr[i] = scan.nextInt();
        }
        // Update array by adding one
        int[] result = addOne(arr, size);

        // Print the resulting array
        System.out.println("Resulting array after adding one:");
        for (int num : result) {
            System.out.print(num + " ");
        }

        
        scan.close();
    }

    public static int[] addOne(int arr[], int size){

        for(int i=(size-1); i>=0; i--){
            if (arr[i] <9) {
                arr[i]++;
                return arr;
            }else{
                arr[i] = 0;
            }
        }
        int newArr[] = new int[size+1];
        newArr[0] = 1;
        return newArr;

    }
}
