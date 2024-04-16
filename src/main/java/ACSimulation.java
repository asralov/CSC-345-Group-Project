package src.main.java;
/*
 * Authors : Jin Kim
 */

public class ACSimulation {
    public static String DIVIDER = "-------------------------------";

	public ACSimulation() {
		// Empty constructor
	}

    public static void run() {
		System.out.println(DIVIDER);
        System.out.println("Aho-Corasick algorithm");

		String[] patterns;
		String text;

		System.out.println(DIVIDER);

		// Simulation 1
		// lowercase patterns and strings assumed
		patterns = new String[]{"he", "she",  "his", "hers", "her", "is"};
		text = "hersheyshishe";
		simulate(1, patterns, text);

		// Simulation 2
		patterns = new String[]{"abc", "bcd",  "cde", "def", "efg"};
		text = "abcdefg";
		simulate(2, patterns, text);

		// Simulation 3
		patterns = new String[]{"aba", "abab",  "bab"};
		text = "ababababab";
		simulate(3, patterns, text);

		// Simulation 4
		patterns = new String[]{"a", "ab",  "abc", "abcd", "abcde"};
		text = "abcde";
		simulate(4, patterns, text);

		// Simulation 5
		patterns = new String[]{"abc", "bcd",  "a", "ab", "c", "d", "e", "bc"};
		text = "abcde";
		simulate(5, patterns, text);

		// Simulation 6
		patterns = new String[]{"hello", "world", "foo", "bar", "baz"};
		text = "nopatternshere";
		simulate(6, patterns, text);

		// Simulation 7
		patterns = new String[]{"acc", "atc", "cat", "gcg"};
		text = "gcatcg";
		simulate(7, patterns, text);

		// Simulation 8
		/*
		 * root - a - b - c - d - e
		 *      - b - c - d - e
		 *      - c - d - e
		 *      - d - e
		 *      - e
		 */
		patterns = new String[]{"e", "de", "cde", "bcde", "abcde"};
		text = "abcde";
		simulate(8, patterns, text);

		// Simulation 9
		// Empty pattern
		patterns = new String[]{};
		text = "test";
		simulate(9, patterns, text);

		// Simulation 10
		// Empty string
		patterns = new String[]{"a"};
		text = "";
		simulate(10, patterns, text);		
	}

	public static void simulate(int i, String[] patterns, String text) {
		// lowercase patterns and strings assumed

		System.out.println("[Simulation " + i + "]");
		ACPrint(patterns, text);

		AhoCorasickTrie ac = new AhoCorasickTrie();
		ac.build(patterns);
		ac.search(text);

		System.out.println();
		System.out.println(DIVIDER);

	}

	private static void ACPrint(String[] patterns, String text) {
		System.out.print("Patterns: ");
		for (String pattern : patterns) {
			System.out.print(pattern + " ");
		}
		System.out.println();
		System.out.println("Text:     " + text);
		System.out.println();
	}
    
}
