import src.main.java.Trie;
import src.main.java.WildCardSearch;

public class WildCardSearchTest 
{
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("cherry");

        WildCardSearch wildcardSearch = new WildCardSearch(trie);

        System.out.println(wildcardSearch.wildcardSearch("a*e")); // Output: true (matches "apple")
        System.out.println(wildcardSearch.wildcardSearch("*e*")); // Output: true (matches "apple" and "cherry")
        System.out.println(wildcardSearch.wildcardSearch("a*c")); // Output: false
    }
}
