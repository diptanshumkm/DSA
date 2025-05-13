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

        public void insert(String word){

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

        //Search the entire word
        public boolean search(String word){

            TrieNode node = root;
            char[] wordArr = word.toCharArray();
            
            for(char c: wordArr){
                int index = c - 'a';

                if(node.children[index] == null){
                    return false;
                }
                node = node.children[index];
            }
            return node.flag;
        }


        // starts with
        public boolean startsWith(String prefix){

            TrieNode node = root;
            char[] prefixArr = prefix.toCharArray();
            for(char c: prefixArr){
                int index = c - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }

            return true;
        }

    }

    public static void main(String[] args) {
         Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app"));     // true
    }


}
