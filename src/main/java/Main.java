package src.main.java;
import java.util.Arrays;
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

			System.out.print("\nEnter your choice: ");
			choice = keyboard.nextInt();
			
			System.out.println();
		} while (choice != 1 && choice != 2 && choice != 3);

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

        String[] suggestions = trie.autofill("ap", null,null);
        System.out.println("Autofill suggestions for 'ap': " + Arrays.toString(suggestions));
        suggestions = trie.autofill("ba", null,null);
        System.out.println("Autofill suggestions for 'ba': " + Arrays.toString(suggestions));
        suggestions = trie.autofill("ban", null,null);
        System.out.println("Autofill suggestions for 'ban': " + Arrays.toString(suggestions));
        suggestions = trie.autofill("app", null,null);
        System.out.println("Autofill suggestions for 'app': " + Arrays.toString(suggestions));
        suggestions = trie.autofill("y", null,null);
        System.out.println("Autofill suggestions for 'y': " + Arrays.toString(suggestions));
	}
}

