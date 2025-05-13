package trie.example;

public class Create {
    
    //Structure of a trie
    public static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean flag = false;
    }


    public static class Trie{
        private static TrieNode root;

        //Root node initialization
        public Trie(){
            root = new TrieNode(); 
        }

        public static void insert(String word){

            TrieNode node = root;
            char[] wordArr = word.toCharArray();

            for(char c: wordArr){
                int index = c - 'a'; //Calculate the index

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
            }
            node.flag = true;
        }


    }




}
