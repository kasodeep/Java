package Trie;

public class InsertSearch {

    static void insert(TrieNode root, String key) {
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (int level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) pCrawl.children[index] = new TrieNode();
            pCrawl = pCrawl.children[index];
        }

        pCrawl.isEndOfWord = true;
    }

    static boolean search(TrieNode root, String key) {
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (int level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) return false;
            pCrawl = pCrawl.children[index];
        }

        return (pCrawl.isEndOfWord);
    }
}
