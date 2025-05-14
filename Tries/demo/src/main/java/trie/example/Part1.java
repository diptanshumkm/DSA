/*
-------------------------------------------
📚 TRIE RECAP NOTES (Part 1)

🔹 TrieNode Basics (Simple Trie):
- Represents a node in the Trie.
- Each node has:
    ➤ `children[]`: An array of size 26, one for each letter of the alphabet (lowercase a-z).
    ➤ `flag`: A boolean flag that marks whether a word ends at this node (used for "end of word").

🔹 insert(String word):
- Inserts a word character by character into the Trie.
    ✔ For each character in the word, we calculate the index (using `c - 'a'` to map 'a' to 0, 'b' to 1, etc.).
    ✔ If the corresponding child node does not exist, we create it.
    ✔ After processing the entire word, the last node's `flag` is set to `true`, indicating the end of the word.

🔹 search(String word):
- Searches for an exact word in the Trie.
    ✔ It traverses each character of the word and checks if the corresponding child node exists.
    ✔ If we find the word and the last node's `flag` is `true`, we return `true` (word exists).
    ✔ If any character is missing or the `flag` is `false`, the word doesn't exist, and we return `false`.

🔹 startsWith(String prefix):
- Checks if there is any word in the Trie that starts with the given prefix.
    ✔ It traverses the Trie based on the prefix characters, just like `search()`.
    ✔ If all characters are found in the Trie, it returns `true`, indicating words starting with the prefix exist.
    ✔ If any character is missing, it returns `false`.

🧠 Why use `flag`?
- The `flag` is simple and effective for marking whether a word exists.
- It’s ideal for **checking exact words** (using `search()`).
- **Doesn't track frequencies** or allow for deletions.

🎯 When should you use `flag` (End of Word)?
- If you are just checking if a word exists in the Trie.
- It’s **memory efficient** for this purpose, as it’s a **binary flag** (`true` or `false`).

-------------------------------------------
*/


package trie.example;

public class Part1 {
    
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
