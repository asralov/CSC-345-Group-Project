
public class Main {

	public static void main(String[] args) {
	    Trie trie = new Trie();

	    // Test insertion
	    System.out.println("Inserting words...");
	    trie.insert("apple");
	    trie.insert("application");
	    trie.insert("bad");
	    trie.insert("bat");
	    trie.insert("cat");
	    trie.insert("car");
	    trie.insert("dog");
	    trie.insert("dogs");

	    // Test search
	    System.out.println("\nSearching words...");
	    System.out.println("apple: " + trie.search("apple"));     // true
	    System.out.println("app: " + trie.search("app"));       // false
	    System.out.println("application: " + trie.search("application")); // true
	    System.out.println("bad: " + trie.search("bad"));        // true
	    System.out.println("bat: " + trie.search("bat"));        // true
	    System.out.println("cat: " + trie.search("cat"));        // true
	    System.out.println("car: " + trie.search("car"));        // true
	    System.out.println("dog: " + trie.search("dog"));        // true
	    System.out.println("door: " + trie.search("door"));      // false

	    // Test removal
	    System.out.println("\nRemoving words...");
	    trie.remove("bat");
	    trie.remove("application");
	    trie.remove("app"); // Should have no effect as "app" wasn't inserted
	    trie.remove("dog");

	    // Test search again after removal
	    System.out.println("\nSearching words after removal...");
	    System.out.println("apple: " + trie.search("apple"));     // true
	    System.out.println("app: " + trie.search("app"));       // false
	    System.out.println("application: " + trie.search("application")); // false
	    System.out.println("bad: " + trie.search("bad"));        // true
	    System.out.println("bat: " + trie.search("bat"));        // false
	    System.out.println("cat: " + trie.search("cat"));        // true
	    System.out.println("car: " + trie.search("car"));        // true
	    System.out.println("dog: " + trie.search("dog"));        // false
	    System.out.println("dogs: " + trie.search("dogs"));        // true
	}

}

