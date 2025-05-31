// Question: Longest subArr with sum k

import java.util.HashMap;

public class PrefixSum {

    public static int longstSubArrWithSumK(int[] arr, int k){

        int sum =0;
        int maxLen = 0;

        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            sum += arr[i];

            if (prefixSum.containsKey(sum-k)) {
                int length = i - prefixSum.get(sum-k);
                maxLen = Math.max(length, maxLen);
            }

            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2,3, 1, 1, 1,1,4,2,3};
        int k = 3;

        int result = longstSubArrWithSumK(arr, k);
        System.out.println("Longest Subarray with Sum " + k + " = " + result);
    }

}
