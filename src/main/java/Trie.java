



/*
 * Authors : Abrorjon Asralov, Alex Scherer, Jin Kim, Pulat Uralov
 */

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

		// extra attributes for AhoCorasick
		cur.pattern = lower; // store the word in the node
    	return true;
    }
    public TrieNode remove(String word) {   
		return removeHelp(root, word.toLowerCase(), 0); // Start deletion from the root with depth 0
	}

	private TrieNode removeHelp(TrieNode root, String key, int depth) {
	    if (root == null) {
	        return null;
	    }
	    
	    // if it's the last character of the word
	    if (depth == key.length()) {
	        // set the word to false
	        if (root.isWord()) {
	            root.setIsWord(false);
	        }

	        // If given is not prefix of any other word, remove it
	        if (isEmpty(root)) {
	            return null; // Return null to indicate removal
	        }

	        return root; // Return the current node (not removed)
	    }

	    // if not last character, recur for the child
	    int index = key.charAt(depth) - 'a';
	    
	    root.children()[index] = removeHelp(root.children()[index], key, depth + 1);

	    // Only remove the current node if it's empty AND it's not the end of another word
	    if (isEmpty(root) && !root.isWord()) {
	        return null; // Return null to indicate removal
	    }

	    return root; // Return the current node
	}

	// checks if a TrieNode is empty (has no children)
	private static boolean isEmpty(TrieNode node) {
		for (TrieNode child : node.children()) {
			if (child != null) {
				return false;
			}
		}
		return true;
	}

	public TrieNode root() {
		return root;
	}
	
	/*This method takes a string input and searches for strings in the Trie that are
	 *3 letters or less away from the given string (only strings bigger than the given)
	 *
	 *suggestions and curString are arguments that help recurse the function to check children nodes
	 *currIndex is required to add the new word into the array at the proper spot 
	 *Returns Null if given string has no suggestions in the Trie
	 *AutoFill does NOT contain the given string as you are looking for other words*/
	public String[] autofill(String string, String[] suggestions, String curString, int currIndex) {
		suggestions = new String[20];
		
		TrieNode cur = root;
        String wordLower = string.toLowerCase();
        if (curString == null) {
			curString = wordLower;
		}

        // First use the search algo to locate the node for the final char
        // in the string to begin searching (null if not in Trie)
        for (int i = 0; i < curString.length(); i++) {
            int index = curString.charAt(i) - 'a';
            
            if (cur.children()[index] == null) {
                // character not found
                return null;
            } else {
                cur = cur.children()[index];
            }
        }
        
        // Then loop through the node's children and find ones within 3 chars that are words
        for(TrieNode child : cur.children()) {
        	if (child != null) {
        		if (child.isWord()) {
            		suggestions[currIndex]=(curString + child.letter());
            		currIndex++;
            	}
        		if (curString.length() < string.length() + 2 ) {
        			// recurse to repeat the process for the children nodes
        			String[] moreSuggestions = autofill(wordLower, suggestions, curString+child.letter(),currIndex);
        			// add the recursed words into the current array
        			for( String word : moreSuggestions) {
        				if(word != null) {
        					suggestions[currIndex] = word;
        					currIndex++;
        				}
        			}
        		}
        	}
        }
		return suggestions;
	}
	
	//helper function that is used when printing the autofill suggestions as a string instead of as a String[]
	public String suggestionsToString(String[] suggestions) {
		String retval = "";
		if (suggestions == null) {
			return null;
		}
		for (int i = 0; i < suggestions.length; i++) {
			if(suggestions[i] !=null) {
				retval += suggestions[i];
				if(suggestions[i+1] != null) {
					retval+=", ";
				}
			}
			
		}
		return retval;
	}
}
