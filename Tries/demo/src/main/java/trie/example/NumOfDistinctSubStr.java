/*
 * This function returns the number of **distinct non-empty substrings** of a given string.
 * We use a Trie to insert every possible substring starting from each index.
 * Every time we create a new node in the Trie, it means we found a new unique substring.
 * Time Complexity: O(N^2), where N is the length of the word.
 * Space Complexity: O(N^2) in the worst case (when all substrings are unique).
 */

package trie.example;

public class NumOfDistinctSubStr {
    
    public static class TrieNode{
        TrieNode[] children = new TrieNode[26];
    }

    public static class Trie{
        private static TrieNode root;
        
        public Trie(){
            root = new TrieNode();
        }

        public int numberOfDisSubStr(String word){
            int count = 0;
            for(int i = 0; i<word.length(); i++){
                TrieNode node = root;

                for(int j=i; j<word.length(); j++){
                    int index = word.charAt(j) - 'a';
                    if (node.children[index] == null) {
                        node.children[index] = new TrieNode();
                        count++;
                    }
                    node = node.children[index];
                }

            }
            return count + 1;

        }

    }

    public static void main(String[] args) {
        String word = "abab";
        Trie trie = new Trie();
        System.out.println(trie.numberOfDisSubStr(word));
    }
}
