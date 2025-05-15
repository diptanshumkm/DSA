package trie.example;

public class LngstWrdAllPrefix {

    public static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean flag = false;
    }

    public static class Trie{
        private static TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insertWord(String[] words){
            
            for(String word: words){
                TrieNode node = root;
                char[] wordArr = word.toCharArray();

                for(char c: wordArr){
                    int index = c - 'a';
                    if (node.children[index] == null) {
                        node.children[index] = new TrieNode();
                    }
                    node = node.children[index];
                }
                node.flag = true;
            }

        }

        public boolean allPrefixesExists(String word){
            TrieNode node = root;
            char[] wordArr = word.toCharArray();
            for(char c: wordArr){
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return node.flag;
        }
    
        public String solve(String[] words){
            insertWord(words);
            String longest = "";

            for(String word: words){
                if (allPrefixesExists(word)) {
                    if (longest.length() < word.length()) {
                        longest = word;
                    }
                }
            }
            
            return longest;
        }
    
    }

    public static void main(String[] args) {
        String[] words = {
            "n", "ni", "nin", "ninj", "ninja", "ninga", "a", "ap", "app", "appl", "apple", "apply"
        };

        Trie trie = new Trie();
        System.out.println(trie.solve(words));
    }


}
