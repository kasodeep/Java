package Trie;

import java.util.Arrays;

public class TrieNode {

    static final int ALPHABET_SIZE = 26;

    TrieNode[] children = new TrieNode[ALPHABET_SIZE];

    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        Arrays.fill(children, null);
    }
}
