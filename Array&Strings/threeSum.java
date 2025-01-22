import java.util.*; 

public class threeSum {
    public static void main(String[] args){

        HashSet<List<Integer>> st = new HashSet<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size = scan.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter the elements of array: ");
        for(int i=0; i < size; i++){
            arr[i] = scan.nextInt();
        }

        
        // -------------------------------------------BRUTE FORCE O(N^3)---------------------------------------------
        // for(int i=0; i<size; i++){
        //     for(int j=i+1; j<size; j++){
        //         for(int k=j+1; k< size; k++){
        //             if (arr[i] + arr[j] + arr[k] == 0) {
        //                 ArrayList<Integer> triplets =new ArrayList<>();
        //                 triplets.add(arr[i]);
        //                 triplets.add(arr[j]);
        //                 triplets.add(arr[k]);

        //                 Collections.sort(triplets);
        //                 st.add(triplets);
        //             }
        //         }
        //     }
        // }
        // System.out.println("Unique elements: " + st);

        // ----------------------------------------------------BETTER SOLUTION O(N^2)------------------------------------------------------
        // for(int i =0; i< size; i++){

        //     HashSet<Integer> set = new HashSet<>();
        //     for(int j=i+1; j<size; j++){
        //         int num = -(arr[i] + arr[j]);
        //         if(set.contains(num)){
        //             ArrayList<Integer> triplets = new ArrayList<>();
        //             triplets.add(arr[i]);
        //             triplets.add(arr[j]);
        //             triplets.add(num);

        //             Collections.sort(triplets);
        //             st.add(triplets);
        //         }else{
        //             set.add(arr[j]);
        //         }
        //     }
        // }

        // System.out.println(st);

        // -------------------------------------------------------------OPTIMIZED SOLUTION--------------------------------------
        Arrays.sort(arr);
        for(int i=0; i<size; i++){

            if(i>0 && arr[i]==arr[i-1]){
                continue;
            }

            int j = i+1;
            int k = size-1;
            while (j < k) {                
                int sum = arr[i] +arr[j]+arr[k];

                if (sum >0) {
                    k--;
                }else if(sum <0){
                    j++;
                }else if (sum == 0) {
                    ArrayList<Integer> triplets = new ArrayList<>();
                    triplets.add(arr[i]);
                    triplets.add(arr[j]);
                    triplets.add(arr[k]);
                    st.add(triplets);
                    j++;
                    k--;
                }
                while (j < k && arr[j] == arr[j-1]) {
                    j++;
                }
                while (j < k && arr[k] == arr[k-1]) {
                    k--;
                }

            }


        }
        System.out.println("Unique triplets: " + st);
        scan.close();
    }
}
