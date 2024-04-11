// import static org.junit.Assert.assertFalse;
// import static org.junit.Assert.assertTrue;
import src.main.java.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TrieNodeTest 
{
    // public static void main(String[] args) {
    //     test1();
    //     System.out.println();
    //     test2();
    //     System.out.println();
    //     test3();
    // }

    @Test
    public void test1()
    {
        TrieNode trie = new TrieNode();
        TrieNode a = new TrieNode('a');
        TrieNode p = new TrieNode('p');
        TrieNode p2 = new TrieNode('p');
        TrieNode l = new TrieNode('l');
        TrieNode e = new TrieNode('e');
        trie.appendChild(a);
        trie.appendChild(p);
        trie.appendChild(p2);
        trie.appendChild(l);
        trie.appendChild(e);
        System.out.print("Trie Word: ");
        System.out.println(trie);
        System.out.print("Actual Word: ");
        System.out.println("apple");
    }

    @Test
    public void test2() 
    {
        // root
        TrieNode trie = new TrieNode();
        trie.appendChild(new TrieNode('b'));
        trie.appendChild(new TrieNode('a'));
        trie.appendChild(new TrieNode('t'));
        trie.appendChild(new TrieNode('t'));
        trie.appendChild(new TrieNode('e'));
        trie.appendChild(new TrieNode('r'));
        trie.appendChild(new TrieNode('y'));
        System.out.print("Trie Word: ");
        System.out.println(trie);
        System.out.print("Actual Word: ");
        System.out.println("battery");
    }

    @Test
    public void test3()
    {
        // root
        TrieNode trie = new TrieNode();
        trie.appendChild(new TrieNode('a'));
        assertFalse(trie.isWord());
        trie.appendChild(new TrieNode('p'));
        trie.appendChild(new TrieNode('p'));
        trie.setIsWord(true);
        assertTrue(trie.isWord());
        System.out.println(trie);
    }
}