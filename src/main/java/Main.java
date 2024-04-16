package src.main.java;

import java.util.Scanner;

/*
 * Authors: Abrorjon Asralov, Jin Kim, Pulat Uralov, Alex Scherer
 */

public class Main {
	public static String DIVIDER = "-------------------------------";

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int choice;

		System.out.println(DIVIDER);
		System.out.println("Group 23 Final Project");
		System.out.println(DIVIDER);

		do {
			System.out.println("Simulation options:");
			System.out.println("1. Trie");
			System.out.println("2. Aho-Corasick algorithm");
			System.out.println("3. Autofill");
			System.out.println("4. WildCard Search");

			System.out.print("\nEnter your choice: ");
			choice = keyboard.nextInt();
			
			System.out.println();
		} while (choice != 1 && choice != 2 && choice != 3 && choice != 4);

		switch (choice) {
			case 1:
				testTrie();
				break;
			case 2:
				ACSimulation.run();
				break;
			case 3:
				testAutofill();
				break;
			case 4:
				testWildCardSearch();
				break;
		}

		keyboard.close();
	}

	private static void testTrie() {
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

	private static void testAutofill() {
		System.out.println("Adding words: apple, app, apps, banana, ball, cat");
		Trie trie = new Trie();
        // Insert words into the trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apps");
        trie.insert("banana");
        trie.insert("ball");
        trie.insert("cat");
        // use suggestionsToString on autofill to print as a string
        System.out.println("Autofill suggestions for 'ap': " + trie.suggestionsToString(trie.autofill("ap", null,null,0))); 
        System.out.println("Autofill suggestions for 'ba': " + trie.suggestionsToString(trie.autofill("ba", null,null,0)));
        System.out.println("Autofill suggestions for 'ban': " + trie.suggestionsToString(trie.autofill("ban", null,null,0)));
        System.out.println("Autofill suggestions for 'app': " + trie.suggestionsToString(trie.autofill("app", null,null,0)));
        System.out.println("Autofill suggestions for 'y': " + trie.suggestionsToString(trie.autofill("y", null,null,0)));
	}
	
	private static void testWildCardSearch() {
		System.out.println("Adding words: apple, app, apps, banana, ball, cat");
		Trie trie = new Trie();
        // Insert words into the trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apps");
        trie.insert("banana");
        trie.insert("ball");
        trie.insert("cat");
		
		WildCardSearch wildcardSearch = new WildCardSearch(trie);
		System.out.println("WildCardSearch for 'a*p': "+ wildcardSearch.wildcardSearch("a*p"));
		System.out.println("WildCardSearch for 'b*': "+ wildcardSearch.wildcardSearch("b*"));
		System.out.println("WildCardSearch for 'y*': "+ wildcardSearch.wildcardSearch("y*"));
		System.out.println("WildCardSearch for '*at': "+ wildcardSearch.wildcardSearch("*at"));
		System.out.println("WildCardSearch for 'ab*': "+ wildcardSearch.wildcardSearch("ab*"));
		System.out.println("WildCardSearch for '*a*': "+ wildcardSearch.wildcardSearch("*a*"));
	}
}

