

public class Trie 
{
    private TrieNode root;
    public Trie()
    {
        // first having a root that has 26 possible characters
        // but initially the array consists of all nulls
        // we can add that as we add characters and traverse 
        // through them

        // the root of the Trie would not have any character associated with it
        // root will still have children, which is array of 26 TrieNodes
        root = new TrieNode();
    }

    // search returns true if word is in trie
    // case insensitive search
    public boolean search(String word) {
        TrieNode cur = root;
        String wordLower = word.toLowerCase();

        // only iterate for the length of the word
        // search would take O(n) time, where n is the length of the word
        for (int i = 0; i < wordLower.length(); i++) {
            // index into the children to achieve O(1) time
            int index = wordLower.charAt(i) - 'a';
            
            if (cur.children()[index] == null) {
                // character not found
                return false;
            } else {
                // change cur pointer to the next TrieNode (next character)
                cur = cur.children()[index];
            }
        }

        // to determine if we've reached the end of the word
        return cur.isWord();
    }

    //inserts the word one letter at a time into the trie
    //returns true if word is inserted
    public boolean insert(String word) {
    	//only insert lowercase letters
    	String lower = word.toLowerCase();
    	TrieNode cur = root;
    	//if word already in trie, don't insert
    	if (search(lower)) {
    		return false;
    	}
    	for (int i = 0; i < lower.length(); i++) {
            int index = lower.charAt(i) - 'a';
            
            if (cur.children()[index] == null) {
                // add the letter as a child of the current node
                cur.children()[index] = new TrieNode(lower.charAt(i));
            } 
            cur = cur.children()[index];
            
    	}
    	cur.setIsWord(true); // mark end of word
    	return true;
    }
}
