import java.util.*;

public class mergeSortedArr {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the size of arr1: ");
        int n = scan.nextInt();
        System.out.println("Enter the size of arr2: ");
        int m = scan.nextInt();

        int[] arr1 = new int[n+m];
        int[] arr2 = new int[m];
        System.out.println("Enter the elements of arr1:");
        for (int i = 0; i < n; i++) {
            arr1[i] = scan.nextInt();
        }

        System.out.println("Enter the elements of arr2:");
        for (int i = 0; i < m; i++) {
            arr2[i] = scan.nextInt();
        }

        mergeSrtArr(arr1, arr2, n, m);
        System.out.println("Merged array:");
        for (int i = 0; i < n + m; i++) {
            System.out.print(arr1[i] + " ");
        }

    }
    public static void mergeSrtArr(int[] arr1, int[] arr2, int n, int m){
        
        int i = n-1;
        int k = m+n-1;
        int j = m-1;

        while (j>=0 && i>=0) {
            
            if (arr1[i] < arr2[j] ) {
                arr1[k] = arr2[j];
                k--;
                j--;
            }else{
                arr1[k] = arr1[i];
                k--;
                i--;
            }
            
        }
        while (j >= 0) {
            arr1[k] = arr2[j];
            j--;
            k--;
        }

    }
}

