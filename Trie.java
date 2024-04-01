

public class Trie 
{
    private TrieNode[] root;
    public Trie()
    {
        // first having a root that has 26 possible characters
        // but initially the array consists of all nulls
        // we can add that as we add characters and traverse 
        // through them
        root = new TrieNode[26];
    }

    // search returns true if word is in trie
    public boolean search(String word) {
        // changed TrieNode cur = root; to be TrieNode[] so we can acrtually iterate through that
        TrieNode[] cur = root;

        // only iterate for the length of the word
        // search would take O(n) time, where n is the length of the word
        for (int i = 0; i < word.length(); i++) {
            // index into the children to achieve O(1) time
        }

        return true;
    }
    
}
