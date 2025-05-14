/*
-------------------------------------------
📚 TRIE RECAP NOTES (Part 2)

🔹 TrieNode Basics (Enhanced Trie):
- Similar to Part 1 but with **additional tracking**:
    ➤ `children[]`: Array of 26 child nodes for 'a' to 'z'.
    ➤ `count_prefix`: Tracks how many words pass through this node (how many words share the current prefix).
    ➤ `ends_with`: Tracks how many times a word **exactly** ends at this node.

🔹 insert(String word):
- Inserts a word character by character, just like in Part 1.
    ✔ For each character:
        ➤ If the node doesn't exist, create it.
        ➤ Update the `count_prefix` at each node to indicate how many words use this prefix.
    ✔ At the end of the word, increment `ends_with` to track how many times the word ends here.

🔹 countWordsEqualTo(String word):
- Counts how many times a specific word was inserted in the Trie.
    ✔ Traverse each character of the word.
    ✔ If any character is missing, return `0` (word doesn't exist).
    ✔ Return the `ends_with` value of the final node. This will show how many times the word ends at that node.

🔹 countWordsStartingWith(String prefix):
- Counts how many words **start** with the given prefix.
    ✔ Traverse the Trie based on the prefix.
    ✔ If the prefix is found, return the `count_prefix` at the last node of the prefix. This shows how many words have this prefix.

🔹 erase(String word):
- Erases a word from the Trie.
    ✔ Check if the word exists by using `countWordsEqualTo(word)`.
    ✔ If it exists, decrement `count_prefix` at each node as you backtrack through the word.
    ✔ At the end node, decrement `ends_with` to remove the word.
    ✔ If the word is not present, do nothing.

🎯 Why use `count_prefix` and `ends_with`?
- **`count_prefix`** allows you to count how many words start with a certain prefix efficiently.
- **`ends_with`** helps track exact word frequencies, allowing for accurate word deletion and count retrieval.

🧠 Key Insights:
- **Efficient deletion**: You can remove words without leaving unnecessary nodes behind.
- **Multiple word insertions**: Handle duplicate words, and track how many times each word has been added.
- **Prefix counting**: Can count how many words start with a specific prefix, not just check for existence.

-------------------------------------------
*/


package trie.example;

public class Part2 {
 
    public static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int count_prefix = 0;
        int ends_with = 0;
    }


    public static class Trie{
        private static TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            TrieNode node = root;
            char[] wordArr = word.toCharArray();

            for(char c: wordArr){
                int index = c - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                
                node = node.children[index];
                node.count_prefix++;
                
            }   

            node.ends_with++;
        }

        public int countWordsEqualTo(String word){
            TrieNode node = root;
            char[] wordArr = word.toCharArray();
            
            for(char c: wordArr){
                int index = c - 'a';

                if (node.children[index] == null) {
                    return 0;
                }
                node = node.children[index];
            }
            return node.ends_with;


        }

        public int countWordsStartingWith(String prefix){
            TrieNode node = root;
            char[] prefixArr = prefix.toCharArray();

            for(char c: prefixArr){
                int index = c - 'a';
                if (node.children[index] == null) {
                    return 0;
                }

                node = node.children[index];
            }

            return node.count_prefix;

        }

        public void erase(String word){
            if (countWordsEqualTo(word) == 0) {
                return;
            }

            TrieNode node = root;
            char[] wordArr = word.toCharArray();

            for(char c: wordArr){
                int index = c - 'a';
                if (node.children[index] == null) {
                    return;
                }
                
                node = node.children[index];
                node.count_prefix--;
            }

            node.ends_with--;
        }


    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apt");
        trie.insert("apply");

        System.out.println("Words equal to 'apple': " + trie.countWordsEqualTo("apple")); // 2
        System.out.println("Words starting with 'app': " + trie.countWordsStartingWith("app")); // 4

        trie.erase("apple");
        System.out.println("Words equal to 'apple' after erase: " + trie.countWordsEqualTo("apple")); // 1

        trie.erase("apple");
        System.out.println("Words equal to 'apple' after erase: " + trie.countWordsEqualTo("apple")); // 0

        trie.erase("apple"); //should do nothing (word not present)
        System.out.println("Words equal to 'apple' after erase: " + trie.countWordsEqualTo("apple")); // 0

        System.out.println("Words starting with 'ap': " + trie.countWordsStartingWith("ap")); // 3 (app, apt, apply)
        System.out.println("Words starting with 'z': " + trie.countWordsStartingWith("z")); // 0

    }   

}
