package src.main.java;
/*
Authors : Jin Kim

Aho-Corasick algorithm is an efficient pattern matching algorithm that can search for
all occurences of a set of patterns within a given text.

*/

public class AhoCorasickTrie {
    /*
     * AhoCorasickTrie class build upon the Trie implementation.
     */
    Trie trie;

    // constructor
    public AhoCorasickTrie() {
        trie = new Trie();
    }

    // builds the Trie with the given patterns
    // Time Complexity: O(M * K) where M is the number of patterns and K is the average length of the patterns.
    public void build(String[] patterns) {
        for (String pattern : patterns) {
            trie.insert(pattern);
        }

        buildlLinks();
    }

    // uses BFS to build failure links and output links for each TrieNode
    // failure link points to the longest proper suffix of the pattern that is also a prefix of some other pattern.
    // output link points to the next node represents a pattern that is a suffix of the current node's pattern
    // Time Complexity: O(M * K) where M is the number of patterns and K is the average length of the patterns.
    private void buildlLinks() {
        Queue queue = new Queue();
        TrieNode root = trie.root();
        root.fail = root;  // root's fail points to itself
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            TrieNode cur = queue.dequeue();

            // iterate through 26 possible children
            for (int i = 0; i < 26; i++) {
                TrieNode child = cur.children()[i];

                // if the child doesn't exist, skip
                if (child == null) {
                    continue;
                }
                if (cur == root) {
                    // root's children fail to root because longest suffix is ""
                    child.fail = root;
                } else {
                    // follow the fail link of the current node
                    TrieNode failNode = cur.fail;
                    while (failNode != root && failNode.children()[i] == null) {
                        failNode = failNode.fail;
                    }

                    // if the fail node has a child with the current character
                    // follow the child
                    if (failNode.children()[i] != null) {
                        child.fail = failNode.children()[i];
                    } else {
                        child.fail = root;
                    }
                }

                // if the fail node is a word, the current node is also a word
                if (child.fail.isWord()) {
                    child.out = child.fail;
                } else {
                    child.out = child.fail.out;
                }

                queue.enqueue(child);
            }
        }
    }

    // searches for the pattern in the text
    // and prints out the index of the pattern in the text
    // Time Complexity: O(N + M) where N is the length of the text and M is the number of patterns.
    public void search(String text) {
        // lowecase text assumed
        TrieNode cur = trie.root();

        for (int i = 0; i < text.length(); i++) {
            int index = text.charAt(i) - 'a';

            // if the current node has no child with the current character
            // follow the fail link
            while (cur != trie.root() && cur.children()[index] == null) {
                cur = cur.fail;
            }

            // if the current node has a child with the current character
            // follow the child
            if (cur.children()[index] != null) {
                cur = cur.children()[index];

                if (cur.isWord()) {
                    System.out.println("Found '" + cur.pattern + "' at index " + (i - cur.pattern.length() + 1));
                }

                TrieNode output = cur.out;
                while (output != null) {
                    System.out.println("Found '" + output.pattern + "' at index " + (i - output.pattern.length() + 1));
                    output = output.out; 
                }
            }
        }
    }

    // returns the root of the Trie
    // Runtime Complexity: O(1)
    public TrieNode getRoot() {
        return trie.root();
    }

    // public static void main(String[] args) {
    //     // lowercase patterns and strings assumed
    //     String[] patterns = {"he", "she",  "his", "hers", "her" };
    //     AhoCorasickTrie ac = new AhoCorasickTrie();
    //     ac.build(patterns);

    //     String text = "hersheyshishe";
    //     ac.search(text);
    // }

}