package src.main.java;
/*
Authors : Jin Kim
*/

public class AhoCorasickTrie {
    Trie trie;

    // takes in an array of patterns to build the Trie
    public AhoCorasickTrie() {
        trie = new Trie();
    }

    public void build(String[] patterns) {
        for (String pattern : patterns) {
            trie.insert(pattern);
        }

        buildlLinks();
    }

    // uses BFS to build failure links and output links for each TrieNode
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

                if (child == null) {
                    continue;
                }
                if (cur == root) {
                    // root's children fail to root because longest suffix is ""
                    child.fail = root;
                } else {
                    TrieNode failNode = cur.fail;
                    while (failNode != root && failNode.children()[i] == null) {
                        failNode = failNode.fail;
                    }

                    if (failNode.children()[i] != null) {
                        child.fail = failNode.children()[i];
                    } else {
                        child.fail = root;
                    }
                }

                if (child.fail.isWord()) {
                    child.out = child.fail;
                } else {
                    child.out = child.fail.out;
                }

                queue.enqueue(child);
            }
        }
    }

    public void search(String text) {
        TrieNode cur = trie.root();

        for (int i = 0; i < text.length(); i++) {
            int index = text.charAt(i) - 'a';

            while (cur != trie.root() && cur.children()[index] == null) {
                cur = cur.fail;
            }

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