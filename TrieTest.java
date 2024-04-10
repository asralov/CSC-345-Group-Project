import org.junit.*;


public class TrieTest {

    @Test
    public void testInsertAndSearch() {
        Trie trie = new Trie();
        Assert.assertTrue(trie.insert("apple"));
        Assert.assertTrue(trie.search("apple"));
        Assert.assertFalse(trie.search("app"));
        Assert.assertFalse(trie.search("banana"));
        System.out.print("PASSED");
    }

    @Test
    public void testInsertDuplicateWord() {
        Trie trie = new Trie();
        Assert.assertTrue(trie.insert("apple"));
        Assert.assertFalse(trie.insert("apple")); // Should return false for duplicates
        System.out.print("PASSED");

    }

    @Test
    public void testCaseInsensitiveSearch() {
        Trie trie = new Trie();
        trie.insert("apple");
        Assert.assertTrue(trie.search("Apple"));
        Assert.assertTrue(trie.search("aPpLe"));
        System.out.print("PASSED");

    }

    @Test
    public void testRemoveWord() {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        Assert.assertTrue(trie.remove("apple") != null);
        Assert.assertFalse(trie.search("apple"));
        Assert.assertTrue(trie.search("app")); // Ensure "app" is still present
        System.out.print("PASSED");

    }

    @Test
    public void testRemoveNonexistentWord() {
        Trie trie = new Trie();
        Assert.assertNull(trie.remove("apple")); // Should return null for non-existent word
        System.out.print("PASSED");

    }

    @Test
    public void testRemoveWordWithPrefix() {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("application");
        Assert.assertTrue(trie.remove("apple") != null);
        Assert.assertFalse(trie.search("apple"));
        Assert.assertTrue(trie.search("application")); // Ensure prefix remains
        System.out.print("PASSED");

    }
}