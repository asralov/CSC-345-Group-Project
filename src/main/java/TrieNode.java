package src.main.java;

/*
 * Authors : Abrorjon Asralov, Jin Kim
 */

public class TrieNode 
{
    // private attributes
    private char letter; // letter of from the word
    private TrieNode[] children; // other possible words those are TrieNodes in array
    private int numOfChildren = 0; // for keeping the count for indexing array
    private boolean isWord = false; // for checking if we've reached the end of the word

    // extra atrributes for AhoCorasick
    public TrieNode fail;  // simulates failure link
    public TrieNode out;   // simulates output link
    public String pattern; // pattern that node represents
    private int wordCount = 0; // Count of the word

    // Constructor
    public TrieNode(char character)
    {
        this.letter = character;
        this.children = new TrieNode[26]; // 26 possible combos with letters

        this.fail = null;
        this.out = null;
    }

    // Constructor for root
    public TrieNode()
    {
        this.children = new TrieNode[26]; // 26 possible combos with letters

        this.fail = null;
        this.out = null;
    }

    /**
     * This is a getter method that returns this TrieNode's character that
     * is a letter for the possible word
     * @return char
     */
    public char letter()
    {
        return this.letter;
    }

    /**
     * This is a setter method that appends children collection of this TrieNode
     * @param trieNode
     */
    public void appendChild(TrieNode trieNode)
    {
        children[numOfChildren] = trieNode;
        numOfChildren++;
    }

    // setter for isWord
    public void setIsWord(boolean isWord)
    {
        this.isWord = isWord;
    }

    // getter for isWord
    public boolean isWord()
    {
        return this.isWord;
    }

    // getter for children
    public TrieNode[] children()
    {
        return this.children;
    }
    
    // getter for wordCount
    public int getWordCount() {
        return wordCount;
    }
    
    // increments wordCount
    public void incrementWordCount() {
        this.wordCount++;
    }

    // added a toString for debugging and printing purposes
    public String toString() {
        if (numOfChildren == 0) {
            return ""; // No children to print
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numOfChildren; i++) {
            sb.append(children[i].letter()); // Append child's letter
        }
        return sb.toString();
    }
    
}
