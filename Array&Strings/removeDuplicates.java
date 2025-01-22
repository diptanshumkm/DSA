import java.util.*;

public class removeDuplicates {
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size = scan.nextInt();
        
        int arr[] = new int[size];
        System.out.println("Enter elements of array: ");

        for(int i = 0; i<size; i++){
            arr[i] = scan.nextInt();
        }

        // ------------------------------------------------------------BRUTE FORCE SOLUTION --------------------------------------------------------------
        // HashSet<Integer> st = new HashSet<>();
        // for(int i =0; i<size; i++){
        //     st.add(arr[i]);
        // }

        // for(Integer v: st){
        //     System.out.print(v + ", ");
        // }
        // System.out.println( "Size " + st.size());


        // ------------------------------------------------------------Optimal solution--------------------------------------------------------------------------------
        int i = 0;
        for(int j = i+1; j < size; j++){
            if (arr[j] != arr[i]) {
                arr[i+1] = arr[j];
                i++;                
            }
        }

        for(int k =0; k <=i; k++){
            System.out.print(arr[k] + " ");
        }

        scan.close();
    }
}
