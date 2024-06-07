package Trie;

import java.util.List;
import java.util.Objects;

public class ReplaceWords {

    Node root = new Node();

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String str : dictionary) {
            insert(str);
        }

        String[] arr = sentence.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String replace = search(arr[i]);

            if (Objects.equals(replace, "")) builder.append(arr[i]);
            else builder.append(replace);
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    public void insert(String str) {
        Node node = this.root;
        for (char c : str.toCharArray()) {
            int n = c - 'a';
            if (node.children[n] == null) {
                node.children[n] = new Node();
            }
            node = node.children[n];
        }
        node.isWord = true;
    }

    public String search(String str) {
        Node node = this.root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int n = c - 'a';
            if (node.children[n] == null) {
                return "";
            }
            node = node.children[n];
            if (node.isWord)
                return str.substring(0, i + 1);
        }
        return "";
    }

    static class Node {
        boolean isWord;
        Node[] children = new Node[26];
    }
}
