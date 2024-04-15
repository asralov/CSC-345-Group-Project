

public class WildCardSearch 
{
    private Trie trie;

    public WildCardSearch(Trie trie) {
        this.trie = trie;
    }

    public boolean wildcardSearch(String pattern) {
        return wildcardSearch(trie.root(), pattern.toLowerCase(), 0);
    }

    private boolean wildcardSearch(TrieNode node, String pattern, int index) {
        if (node == null)
            return false;

        // If we reach the end of the pattern, check if the current node represents a word
        if (index == pattern.length())
            return node.isWord();

        char currentChar = pattern.charAt(index);

        // If the current character is a wildcard, recursively search all children
        if (currentChar == '*') {
            // If this is the last character in the pattern, any remaining node represents a valid word
            if (index == pattern.length() - 1)
                return true;

            // Recursively search all children nodes
            for (TrieNode child : node.children()) {
                if (child != null && wildcardSearch(child, pattern, index + 1))
                    return true;
            }
            return false;
        }

        // If the current character is not a wildcard, continue normal search
        int charIndex = currentChar - 'a';
        return (node.children()[charIndex] != null && wildcardSearch(node.children()[charIndex], pattern, index + 1));
    }

    
}
