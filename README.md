# CSC-345-Group-Project
Language: ![Java](https://img.shields.io/badge/-Java-007396?logo=java&logoColor=white)<br>
Tools: ![VS Code](https://img.shields.io/badge/-VS%20Code-007ACC?logo=visual-studio-code&logoColor=white) ![GitHub](https://img.shields.io/badge/-GitHub-181717?logo=github&logoColor=white) ![Gradle](https://img.shields.io/badge/-Gradle-02303A?logo=gradle&logoColor=white) ![JUnit](https://img.shields.io/badge/-JUnit-25A162?logo=junit5&logoColor=white)<br>

## Presentation
Youtube Link: https://youtu.be/15-Ndt-nNWo
If that link does not work, video can also be found here: https://drive.google.com/drive/folders/1iAqQcsz4UaZ8b-GwPZzaTV1BY5yIazWO?usp=sharing

## Description

Trie is a tree-based data structure that is used for efficient information retrieval. This project provides an implementation of the Trie data structure in Java, along with additional features such as autofill, wildcard search, word frequency, and Aho-Corasick algorithm.

#### Autofill
The autofill method returns a list of words close to a string that was entered.

#### Wildcard Search
The Wildcard Search method returns a boolean depending on user's provided parameter. It can be a string pattern with * characters instead of some letters in the word (As an example we can see a pattern: b**). And if there are words such as: "bee", "bed", "bad". And after calling this search we are able to get True output which means we have words with b** pattern. However, if we are looking for "bu*" pattern, it should return false because we do not have any words with bu* pattern.

#### Word Frequency
Word Frequency return N most frequent words in a text

#### Aho-Corasick Algorithm
Implements Aho-Corasick Algorithm to efficiently search all occurrences of a set of patterns within a given text.

## File Structure

#### Main.java
The Main class contains the demonstration of the basic functionalities of Trie. It provides a command-line interface for the user to choose between multiple Trie-based implementations.

#### TrieNode.java
The TrieNode class represents a single node in the Trie data structure. It stores information such as the character it represents, its children nodes, and whether it marks the end of a word.

#### Trie.java
The Trie class is the main implementation of the Trie data structure. It contains methods for inserting, searching, and removing words from the Trie. It also has an extra autofill method that suggests words based on the input string.

#### AhoCorasickTrie.java
The AhoCorasickTrie class implements the Aho-Corasick algorithm, which builds a Trie of all the patterns to search for and links the nodes to efficiently search for multiple patterns in a given text.

#### Queue.java
The Queue class is a custom implementation of a queue data structure to be used in the Aho-Corasick algorithm.

#### WildCardSearch.java
The WildCardSearch class implements the WildCardSearch algorithm. It should get a Trie with words as a paramater inside of the constructor. And it should return a boolean after asked pattern in the trie. If there are words with similar pattern, it should return true, false otherwise.

#### Frequency.java
The Frequency class implements the Word Frequency algorithm that reads a text, calculates the count of each word, and displays N most frequent words in the text. This class uses a Trie to implement the algorithm.

## Simulation
To simulate the project, run the following command in the terminal in the root directory.

In macOS or Linux:
```shell
./gradlew run
```

In Windows:

```shell
gradlew.bat run
```

To compile and run manually, run this command instead:
```shell
javac src/main/java/*.java && java src/main/java/Main.java
```

<br />

User is prompted to choose between the three options as shown below:
```shell
-------------------------------
Group 23 Final Project
-------------------------------
Simulation options:
1. Trie
2. Aho-Corasick algorithm
3. Autofill
4. WildCard Search
5. Frequency

Enter your choice:
```


## Testing
To run the tests, run the following command in the terminal in the root directory.

In macOS or Linux:
```shell
./gradlew clean test
```

In Windows:

```shell
gradlew.bat clean test
```

<br />

User is able to see the test results as shown below:
```shell
TrieTest > Autofill Test PASSED

TrieTest > Insert and Search Test PASSED

TrieTest > Remove Word with Prefix Test PASSED

TrieTest > Case Insensitive Search Test PASSED

TrieTest > Insert Duplicate Word Test PASSED

TrieTest > Remove Word Test PASSED

TrieTest > Remove Nonexistent Word Test PASSED

.
.
.
```

## Contributors
- Abrorjon Asralov
- Alex Scherer
- Jin Kim
- Pulat Uralov
