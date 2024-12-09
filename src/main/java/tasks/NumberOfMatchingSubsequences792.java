package tasks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfMatchingSubsequences792 {
    public static void main(String[] args) {
        System.out.println(numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        Trie trie = new Trie();

        char[] charArray = s.toCharArray();

        Arrays.sort(charArray);

        String sorted = new String(charArray);

        trie.insert(sorted);

        int count = 0;

        for (String word : words)
            if (trie.search(word))
                count++;

        return count;
    }
}

class Trie {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            current = current.children.get(ch);

            if (current == null) {
                return false;
            }
        }

        return current.isEndOfWord;
    }
}