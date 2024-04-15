import org.junit.jupiter.api.Test;
import src.main.java.Trie;  
import src.main.java.WildCardSearch;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 * Authors: Abrorjon Asralov
 */
public class WildCardSearchTest 
{
    @Test
    public void testWildcardSearch1() {
        Trie trie = new Trie();
        trie.insert("at");
        trie.insert("an");
        trie.insert("bed");
        WildCardSearch wildCardSearch = new WildCardSearch(trie);
        assertEquals(true, wildCardSearch.wildcardSearch("at*"));
    }

    @Test
    public void testWildcardSearch2() {
        Trie trie = new Trie();
        trie.insert("at");
        trie.insert("an");
        trie.insert("bed");
        WildCardSearch wildCardSearch = new WildCardSearch(trie);
        assertEquals(true, wildCardSearch.wildcardSearch("b*d"));
    }

    @Test
    public void testWildcardSearch3() {
        Trie trie = new Trie();
        trie.insert("at");
        trie.insert("an");
        trie.insert("bed");
        WildCardSearch wildCardSearch = new WildCardSearch(trie);
        assertEquals(false, wildCardSearch.wildcardSearch("ab*"));
    }

    @Test
    public void testWildcardSearch4() {
        Trie trie = new Trie();
        trie.insert("at");
        trie.insert("an");
        trie.insert("bed");
        WildCardSearch wildCardSearch = new WildCardSearch(trie);
        assertEquals(false, wildCardSearch.wildcardSearch("b*e"));
    }

    @Test
    public void testWildcardSearch5() {
        Trie trie = new Trie();
        trie.insert("at");
        trie.insert("an");
        trie.insert("bed");
        WildCardSearch wildCardSearch = new WildCardSearch(trie);
        assertEquals(true, wildCardSearch.wildcardSearch("at*"));
    }

    @Test
    public void testWildcardSearch6() {
        Trie trie = new Trie();
        trie.insert("at");
        trie.insert("pan");
        trie.insert("bed");
        WildCardSearch wildCardSearch = new WildCardSearch(trie);
        assertEquals(true, wildCardSearch.wildcardSearch("*an"));
    }

    @Test
    public void testWildcardSearch7() {
        Trie trie = new Trie();
        trie.insert("at");
        trie.insert("an");
        trie.insert("bed");
        WildCardSearch wildCardSearch = new WildCardSearch(trie);
        assertEquals(true, wildCardSearch.wildcardSearch("**"));
    }

    @Test
    public void testWildcardSearch8() {
        Trie trie = new Trie();
        trie.insert("at");
        trie.insert("an");
        trie.insert("bed");
        WildCardSearch wildCardSearch = new WildCardSearch(trie);
        assertEquals(false, wildCardSearch.wildcardSearch("*m*"));
    }
}
