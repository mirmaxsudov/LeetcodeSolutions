package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ReplaceWords648 {
    public static void main(String[] args) {
        ReplaceWords648 main = new ReplaceWords648();
        System.out.println(main.replaceWords(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        System.out.println(main.replaceWords(List.of("a", "b", "c"), "aadsfasf absbs bbab cadsfafs"));
    }

    class Trie {
        Trie[] children;
        boolean isEndOfWord;

        public Trie() {
            this.children = new Trie[28];
            this.isEndOfWord = false;
        }
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        StringJoiner sj = new StringJoiner(" ", "", "");
        Trie root = new Trie();

        for (String word : dictionary)
            insertToRoot(root, word);

        String[] words = sentence.split(" ");

        for (String word : words) {
            String res = searchAndGet(word, root);
            sj.add(res);
        }

        return sj.toString();
    }

    private String searchAndGet(String word, Trie root) {
        Trie temp = root;

        for (int i = 0; i < word.length(); i++) {
            char cha = word.charAt(i);

            if (temp.children[cha - 'a'] != null) {
                if (temp.children[cha - 'a'].isEndOfWord)
                    return word.substring(0, i + 1);
                else {
                    temp = temp.children[cha - 'a'];
                }
            } else {
                break;
            }
        }

        return word;
    }

    private void insertToRoot(Trie root, String word) {
        Trie temp = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (temp.children[index] == null)
                temp.children[index] = new Trie();

            temp = temp.children[index];
        }
        temp.isEndOfWord = true;
    }
}