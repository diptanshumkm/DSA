import java.util.*;

public class missingNumber {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the size: ");
        int size = scan.nextInt();
        

        System.out.println("Enter the elements: ");

        int inputArr[] = new int[size];
        for(int i=0; i<size; i++){
            inputArr[i] = scan.nextInt();
        }

        // ---------------------------------------------------------Better solution TC->O(2N) SC->O(N) --------------------------------------------------------
        /*                                                    HASHING                                                        */
        // int hashArr[]= new int[size+1];
        // for(int j=0; j<(size); j++){
        //     hashArr[inputArr[j]] ++;
        // }
        // for(int k=0; k<(size+1); k++){
        //     if (hashArr[k]==0) {
        //         System.out.println("Missing number: "+k);
        //         break;
        //     }
        // }

        // --------------------------------------------------------OPTIMAL SOLUTION----------------------------------------------
        //       Sum of n natural number TC -> O(N) SC -> O(1)

        int sum = (size)*((size+1)/2);
        int inputSum = 0;
        for(int i =0; i<size; i++){
            inputSum = inputSum+inputArr[i];
        }
        int missingNumber = sum - inputSum;
        System.out.println("Missing number: " + missingNumber);
        scan.close();

    }
    
}
