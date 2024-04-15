package src.main.java;
/**
 * Authors: Abrorjon Asralov
 */
public class WildCardSearch 
{
    // Trie we want to have a searching on
    private Trie trie;

    /**
     * This is a constructor for our WildCardSearch class. As a 
     * parameter we pass already created trie with words. Then
     * we can actually start searching.
     * 
     * @param trie
     */
    public WildCardSearch(Trie trie) 
    {
        this.trie = trie;
    }

    /**
     * This is a method that returns a boolean that shows whether we are
     * able to find the given pattern of the words in our trie.
     * 
     * @param pattern is a string with * char that replaces some letters in the string
     *        to make that pattern.
     * @return a boolean that shows whether we are able to find the pattern in our trie.
     */
    public boolean wildcardSearch(String pattern) 
    {
        return wildcardSearch(trie.root(), pattern.toLowerCase(), 0);
    }
    
    /**
     * This is a private helper method for our searching. It is called by the method
     * above but with extra parameters. Those are the root, the actual pattern that is
     * converted to lower case in case when user wants to search for B**k*. It will search
     * for possible words those can be in pattern b**k*. Then third parameter is an integer
     * that shows a starting index.
     * 
     * @param node is a root of Trie
     * @param pattern is a string that is a pattern with * char in it.
     * @param index is an integer for indexing other children when we have * char
     * @return a boolean that shows whether we have a word with pattern or no.
     */
    private boolean wildcardSearch(TrieNode node, String pattern, int index) 
    {
        // base case
        if (node == null) 
        {
            return false;
        }
        // If we reach the end of the pattern, check if the current node represents a word
        if (index == pattern.length()) 
        {
            return node.isWord();
        }
        char currentChar = pattern.charAt(index);
        // If the current character is a wildcard, recursively search all children
        if (currentChar == '*') 
        {
            // If this is the last character in the pattern, any remaining node represents a valid word
            if (index == pattern.length() - 1) 
            {
                return true;
            }
            // Recursively search all children nodes
            for (TrieNode child : node.children()) 
            {
                if (child != null && wildcardSearch(child, pattern, index + 1)) 
                {
                    return true;
                }
            }
            return false;
        }
        // If the current character is not a wildcard, continue normal search
        int charIndex = currentChar - 'a';
        // If the current character doesn't exist in the children, return false
        if (currentChar != '*' && node.children()[charIndex] == null) 
        {
            return false;
        }
        // making next recursive call
        return wildcardSearch(node.children()[charIndex], pattern, index + 1);
    }
    
}
