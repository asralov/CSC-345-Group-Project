import org.junit.jupiter.api.Test;
// import org.junit.*;
// import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import src.main.java.*;

/*
 * Authors : Abrorjon Asralov
 */

public class TrieTest {

    @Test
    public void testInsertAndSearch() {
        Trie trie = new Trie();
        assertTrue(trie.insert("apple"));
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("app"));
        assertFalse(trie.search("banana"));
        System.out.print("PASSED");
    }

    @Test
    public void testInsertDuplicateWord() {
        Trie trie = new Trie();
        assertTrue(trie.insert("apple"));
        assertFalse(trie.insert("apple")); // Should return false for duplicates
        System.out.print("PASSED");

    }

    @Test
    public void testCaseInsensitiveSearch() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.search("Apple"));
        assertTrue(trie.search("aPpLe"));
        System.out.print("PASSED");

    }

    @Test
    public void testRemoveWord() {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        assertTrue(trie.remove("apple") != null);
        assertFalse(trie.search("apple"));
        assertTrue(trie.search("app")); // Ensure "app" is still present
        System.out.print("PASSED");

    }

    @Test
    public void testRemoveNonexistentWord() {
        Trie trie = new Trie();
        assertNull(trie.remove("apple")); // Should return null for non-existent word
        System.out.print("PASSED");

    }

    @Test
    public void testRemoveWordWithPrefix() {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("application");
        assertTrue(trie.remove("apple") != null);
        assertFalse(trie.search("apple"));
        assertTrue(trie.search("application")); // Ensure prefix remains
        System.out.print("PASSED");

    }
}