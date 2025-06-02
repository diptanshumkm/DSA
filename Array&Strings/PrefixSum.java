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

    public static int optimizedSlidingWindow(int[] arr, int k){
        int right =0;
        int left = 0;
        int sum = 0;
        int maxLen = 0;

        while (right < arr.length) {
            
            sum+=arr[right];

            while(sum > k) {
                sum-=arr[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right-left+1);
            }

            right++;

        }

        return maxLen;
    }



    public static void main(String[] args) {
        int[] arr = {1,2,1,0,1,1,0};
        int k = 4;

        int result = optimizedSlidingWindow(arr, k);
        System.out.println("Longest Subarray with Sum " + k + " = " + result);
    }

}
