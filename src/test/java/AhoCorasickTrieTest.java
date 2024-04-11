import org.junit.jupiter.api.Test;
import src.main.java.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/*
 * Authors : Jin Kim

 */

public class AhoCorasickTrieTest {

    @Test
    @DisplayName("Failure Link Test 1")
    public void testFailureLinks1() {
        String[] patterns = {"acc", "atc", "cat", "gcg"};
        AhoCorasickTrie ac = new AhoCorasickTrie();
        ac.build(patterns);

        /*
         * root - a - c - c
         *          - t - c
         *      - c - a - t
         *      - g - c - g
         */

        TrieNode root = ac.getRoot();

        TrieNode aNode = root.children()['a' - 'a'];

        TrieNode acNode = aNode.children()['c' - 'a'];
        TrieNode accNode = acNode.children()['c' - 'a'];

        TrieNode atNode = aNode.children()['t' - 'a'];
        TrieNode atcNode = atNode.children()['c' - 'a'];

        TrieNode cNode = root.children()['c' - 'a'];
        TrieNode caNode = cNode.children()['a' - 'a'];
        TrieNode catNode = caNode.children()['t' - 'a'];

        TrieNode gNode = root.children()['g' - 'a'];
        TrieNode gcNode = gNode.children()['c' - 'a'];
        TrieNode gcgNode = gcNode.children()['g' - 'a'];

        assertEquals(root.fail, root);
        assertEquals(aNode.fail, root);
        assertEquals(acNode.fail, cNode);
        assertEquals(accNode.fail, cNode);
        assertEquals(atNode.fail, root);
        assertEquals(atcNode.fail, cNode);

        assertEquals(cNode.fail, root);
        assertEquals(caNode.fail, aNode);
        assertEquals(catNode.fail, atNode);

        assertEquals(gNode.fail, root);
        assertEquals(gcNode.fail, cNode);
        assertEquals(gcgNode.fail, gNode);
    }

    @Test
    @DisplayName("Failure Link Test 2")
    public void testFailureLinks2() {
        String[] patterns = {"abc", "bcd", "cde", "def", "efg"};
        AhoCorasickTrie ac = new AhoCorasickTrie();
        ac.build(patterns);

        /*
         * root - a - b - c
         *      - b - c - d
         *      - c - d - e
         *      - d - e - f
         *      - e - f - g
         */

        TrieNode root = ac.getRoot();

        TrieNode aNode = root.children()['a' - 'a'];
        TrieNode abNode = aNode.children()['b' - 'a'];
        TrieNode abcNode = abNode.children()['c' - 'a'];

        TrieNode bNode = root.children()['b' - 'a'];
        TrieNode bcNode = bNode.children()['c' - 'a'];
        TrieNode bcdNode = bcNode.children()['d' - 'a'];

        TrieNode cNode = root.children()['c' - 'a'];
        TrieNode cdNode = cNode.children()['d' - 'a'];
        TrieNode cdeNode = cdNode.children()['e' - 'a'];

        TrieNode dNode = root.children()['d' - 'a'];
        TrieNode deNode = dNode.children()['e' - 'a'];
        TrieNode defNode = deNode.children()['f' - 'a'];

        TrieNode eNode = root.children()['e' - 'a'];
        TrieNode efNode = eNode.children()['f' - 'a'];
        TrieNode efgNode = efNode.children()['g' - 'a'];

        // finding efg should output ef, de, cde, bcde, abcde
        assertEquals(abNode.fail, bNode);
        assertEquals(bcNode.fail, cNode);
        assertEquals(cdNode.fail, dNode);
        assertEquals(deNode.fail, eNode);
        assertEquals(efNode.fail, root);

        assertEquals(abcNode.fail, bcNode);
        assertEquals(bcdNode.fail, cdNode);
        assertEquals(cdeNode.fail, deNode);
        assertEquals(defNode.fail, efNode);
        assertEquals(efgNode.fail, root);
    }

    @Test
    @DisplayName("Output Link Test 1")
    public void testOutputLinks1() {
        String[] patterns = {"he", "she", "his", "hers", "her"};
        AhoCorasickTrie ac = new AhoCorasickTrie();
        ac.build(patterns);

        /*
         * root - h - [e] - [r] - [s]
         *          -  i  - [s]
         *      - s -  h  - [e]
         * 
         * [ ] indicates word
         */

        TrieNode root = ac.getRoot();

        TrieNode hNode = root.children()['h' - 'a'];
        TrieNode heNode = hNode.children()['e' - 'a'];
        TrieNode herNode = heNode.children()['r' - 'a'];
        TrieNode hersNode = herNode.children()['s' - 'a'];
        TrieNode hiNode = hNode.children()['i' - 'a'];
        TrieNode hisNode = hiNode.children()['s' - 'a'];
        TrieNode sNode = root.children()['s' - 'a'];
        TrieNode shNode = sNode.children()['h' - 'a'];
        TrieNode sheNode = shNode.children()['e' - 'a'];

        // finding she should also output he
        assertEquals(sheNode.out, heNode);
    }

    @Test
    @DisplayName("Output Link Test 2")
    public void testOutputLinks2() {
        String[] patterns = {"a", "ab", "abc", "abcd", "abcde"};
        AhoCorasickTrie ac = new AhoCorasickTrie();
        ac.build(patterns);

        /*
         * root - [a] - [b] - [c] - [d] - [e]
         * 
         * [ ] indicates word
         */

        TrieNode root = ac.getRoot();
        TrieNode aNode = root.children()['a' - 'a'];
        TrieNode abNode = aNode.children()['b' - 'a'];
        TrieNode abcNode = abNode.children()['c' - 'a'];
        TrieNode abcdNode = abcNode.children()['d' - 'a'];
        TrieNode abcdeNode = abcdNode.children()['e' - 'a'];

        assertEquals(abcdeNode.out, null);
        assertEquals(abcdNode.out, null);
        assertEquals(abcNode.out, null);
        assertEquals(abNode.out, null);
        assertEquals(aNode.out, null);
    }

    @Test
    @DisplayName("Failure and Output Link Test")
    public void testFailureAndOutputLinks() {
        String[] patterns = {"e", "de", "cde", "bcde", "abcde"};
        AhoCorasickTrie ac = new AhoCorasickTrie();
        ac.build(patterns);
        /*
         * root - a - b - c - d - e
         *      - b - c - d - e
         *      - c - d - e
         *      - d - e
         *      - e
         */

        TrieNode root = ac.getRoot();
        TrieNode aNode = root.children()['a' - 'a'];
        TrieNode abNode = aNode.children()['b' - 'a'];
        TrieNode abcNode = abNode.children()['c' - 'a'];
        TrieNode abcdNode = abcNode.children()['d' - 'a'];
        TrieNode abcdeNode = abcdNode.children()['e' - 'a'];
        TrieNode bNode = root.children()['b' - 'a'];
        TrieNode bcNode = bNode.children()['c' - 'a'];
        TrieNode bcdNode = bcNode.children()['d' - 'a'];
        TrieNode bcdeNode = bcdNode.children()['e' - 'a'];
        TrieNode cNode = root.children()['c' - 'a'];
        TrieNode cdNode = cNode.children()['d' - 'a'];
        TrieNode cdeNode = cdNode.children()['e' - 'a'];
        TrieNode dNode = root.children()['d' - 'a'];
        TrieNode deNode = dNode.children()['e' - 'a'];
        TrieNode eNode = root.children()['e' - 'a'];

        // finding abcde should output a, ab, abc, abcd, abcde
        assertEquals(eNode.fail, root);
        assertEquals(deNode.fail, eNode);
        assertEquals(cdeNode.fail, deNode);
        assertEquals(bcdeNode.fail, cdeNode);
        assertEquals(abcdeNode.fail, bcdeNode);

        assertEquals(eNode.out, null);
        assertEquals(deNode.out, eNode);
        assertEquals(cdeNode.out, deNode);
        assertEquals(bcdeNode.out, cdeNode);
        assertEquals(abcdeNode.out, bcdeNode);
    }


    // // Moved to Main.java
    // @Test
    // @DisplayName("Aho-Corasick Empty Pattern Test")
    // public void testEmptyPattern() {
    //     String[] emptyPattern = {};
    //     String text = "test";
    //     AhoCorasickTrie ac = new AhoCorasickTrie();
    //     ac.build(emptyPattern);
    //     ac.search(text);
    // }

    // @Test
    // @DisplayName("Aho-Corasick Empty String Test")
    // public void testEmptyString() {
    //     String[] patterns = {"a"};
    //     String text = "";
    //     AhoCorasickTrie ac = new AhoCorasickTrie();
    //     ac.build(patterns);
    //     ac.search(text);
    // }
}
