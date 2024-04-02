/**
 * This is a TrieNode class
 */
public class TrieNode 
{
    // private attributes
    private char letter; // letter of from the word
    private TrieNode[] children; // other possible words those are TrieNodes in array
    private int numOfChildren = 0; // for keeping the count for indexing array
    private boolean isWord = false; // for checking if we've reached the end of the word

    // Constructor
    public TrieNode(char character)
    {
        this.letter = character;
        this.children = new TrieNode[26]; // 26 possible combos with letters
    }

    // Constructor for root
    public TrieNode()
    {
        this.children = new TrieNode[26]; // 26 possible combos with letters
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
    
}
