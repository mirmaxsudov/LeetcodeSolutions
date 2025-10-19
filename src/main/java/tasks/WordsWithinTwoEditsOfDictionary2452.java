package tasks;

import java.util.ArrayList;
import java.util.List;

public class WordsWithinTwoEditsOfDictionary2452 {
    public static void main(String[] args) {

    }

    class Trie {
        Trie[] children;
        boolean isEndOfWord;

        public Trie() {
            this.children = new Trie[26];
        }
    }

    Trie root = new Trie();

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        insertToWords(dictionary);

        List<String> res = new ArrayList<>();

        for (String query : queries) {
            for (int q = 'a'; q <= 'z'; q++) {
                for (int i = 0; i < query.length(); i++) {
                    if (query.charAt(i) == q)
                        continue;
                }
            }
        }

        return res;
    }

    private void insertToWords(String[] dictionary) {
        for (String word : dictionary) {
            Trie temp = root;

            for (char ch : word.toCharArray()) {
                if (temp.children[ch - 'a'] == null) {
                    temp.children[ch - 'a'] = new Trie();
                }
                temp = temp.children[ch - 'a'];
            }

            temp.isEndOfWord = true;
        }
    }
}