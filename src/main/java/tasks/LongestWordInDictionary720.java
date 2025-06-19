package tasks;

import java.util.Arrays;

public class LongestWordInDictionary720 {
    public static void main(String[] args) {
        LongestWordInDictionary720 main = new LongestWordInDictionary720();
        System.out.println(main.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
    }

    public Trie root = new Trie('0');

    public String longestWord(String[] words) {
        Arrays.sort(words);

        for (String word : words)
            insert(word);

        String longest = "";

        for (String word : words)
            if (isValid(word))
                if (word.length() > longest.length() || (longest.length() == word.length() && word.compareTo(longest) < 0))
                    longest = word;

        return longest;
    }

    private boolean isValid(String word) {
        Trie temp = root;

        for (char c : word.toCharArray()) {
            temp = temp.children[c - 'a'];
            if (temp == null || !temp.isEnd)
                return false;
        }

        return true;
    }

    private void insert(String word) {
        Trie temp = root;
        for (char c : word.toCharArray()) {
            if (temp.children[c - 'a'] == null)
                temp.children[c - 'a'] = new Trie(c);

            temp = temp.children[c - 'a'];
        }

        temp.isEnd = true;
    }

    class Trie {
        char symbol;
        Trie[] children;
        boolean isEnd;

        public Trie(char ch) {
            this.symbol = ch;
            this.children = new Trie[26];
        }
    }
}