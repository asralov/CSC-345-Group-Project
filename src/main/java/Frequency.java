/**
 * Author: Pulat Uralov
 * This class count how many times a word has been written in a text
 * and displays top N frequent words
 */

package src.main.java;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Frequency {
    private Trie trie;

    /**
     * Constructor for Frequency class.
     * Initializes the Trie data structure.
     */
    public Frequency() {
        this.trie = new Trie();
    }

    /**
     * Builds the frequency map of words from a given text file.
     *
     * @param textFile The path to the text file to be processed.
     */
    public void buildFrequency(String textFile) {
        try {
            Scanner fileScanner = new Scanner(new FileReader(textFile));

            // Read the file word by word
            while (fileScanner.hasNext()) {
            	
                String word = fileScanner.next().replaceAll("[^a-zA-Z]", ""); // Remove non-alphabetic characters
                
                if (!word.isEmpty()) { // Check if the word is not empty after removing punctuation

                    // Insert the word into the Trie if it doesn't exist
                    if (!trie.search(word)) {
                        trie.insert(word);
                    }

                    // Increment the word count in the Trie
                    TrieNode nodeToIncrement = trie.searchNode(word);
                    nodeToIncrement.incrementWordCount();
                }
            }

            fileScanner.close();

        } catch (IOException e) {
            System.out.println("error occurred while reading the file: " + e.getMessage());
        }
    }

    /**
     * Retrieves the N most frequent words from the Trie data structure and prints them.
     *
     * @param N The number of most frequent words to retrieve and print.
     */
    public void NMostFrequentWords(int N) {
    	
        // Array to store words and their frequencies 
        String[][] wordFreqArray = new String[100][2]; 
        
        int[] wordCount = {0}; // Use an array to wrap the count

        // Collect words and frequencies into the array
        wordFreqArray = collectWordsAndFrequencies(trie.root(), "", wordFreqArray, wordCount);

        // Sort the array based on frequencies (bubble sort)
        for (int i = 0; i < wordCount[0] - 1; i++) {
            for (int j = 0; j < wordCount[0] - i - 1; j++) {
                if (Integer.parseInt(wordFreqArray[j][1]) < Integer.parseInt(wordFreqArray[j + 1][1])) {
                    // Swap rows
                    String[] temp = wordFreqArray[j];
                    wordFreqArray[j] = wordFreqArray[j + 1];
                    wordFreqArray[j + 1] = temp;
                }
            }
        }
        
        // Print the top N most frequent words
        for (int i = 0; i < N && i < wordCount[0]; i++) { // Use wordCount[0] for loop condition
            System.out.println(wordFreqArray[i][0] + " " + wordFreqArray[i][1]);
        }
    }

    /**
     * Recursively collects words and their frequencies from the Trie into the given array.
     *
     * @param node         The current TrieNode being processed.
     * @param prefix       The prefix string built from previous TrieNodes.
     * @param wordFreqArray The array storing words and their frequencies.
     * @param wordCount    The array storing the count of words processed.
     * @return The updated wordFreqArray after collecting words and frequencies.
     */
    public String[][] collectWordsAndFrequencies(TrieNode node, String prefix, String[][] wordFreqArray, int[] wordCount) {
    	
        if (node == null) {
            return wordFreqArray;
        }
        
        if (node.isWord()) {
        	
            // Check if resizing is needed BEFORE adding the word
            if (wordCount[0] == wordFreqArray.length) {
                wordFreqArray = resizeArray(wordFreqArray);
            }
            
            wordFreqArray[wordCount[0]][0] = prefix;
            wordFreqArray[wordCount[0]][1] = String.valueOf(node.getWordCount());
            wordCount[0]++;
        }
        for (TrieNode child : node.children()) {
            if (child != null) {
                wordFreqArray = collectWordsAndFrequencies(child, prefix + child.letter(), wordFreqArray, wordCount);
            }
        }
        return wordFreqArray;
    }

    /**
     * Resizes the given 2D array by doubling its size.
     *
     * @param originalArray The original 2D array to be resized.
     * @return The resized 2D array.
     */
    private String[][] resizeArray(String[][] originalArray) {
        int newSize = originalArray.length * 2;
        String[][] newArray = new String[newSize][2];
        
        // Copy elements from the original array to the new array
        for (int i = 0; i < originalArray.length; i++) { 
            newArray[i] = originalArray[i]; 
        }
        return newArray;
    }

    // public static void main(String[] args) {
        
    // }
}
