package com.example;

import java.util.ArrayList;
import java.util.List;

public class PartitionPalindrome {
    
    public static boolean isPalindrome(String s, int start, int end){
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void generatePalindrome(int index, String s, List<String> ds, List<List<String>> answer){

        if (index == s.length()) {
            answer.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index; i<s.length(); i++){
            
            if (isPalindrome(s, index, i)) {
                ds.add(s.substring(index, i+1));
                generatePalindrome(index+1, s, ds, answer);
                ds.remove(ds.size()-1);
            }

        }


    }

    public static List<List<String>> partition(String s){

        List<List<String>> answer = new ArrayList<>();

        generatePalindrome(0, s, new ArrayList<>(), answer);
        return answer;


    }

    public static void main(String[] args) {
        String s = "aabb";

        System.out.println(partition(s));
    }
}
