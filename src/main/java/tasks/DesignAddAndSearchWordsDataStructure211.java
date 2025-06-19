package tasks;

import lombok.ToString;

public class DesignAddAndSearchWordsDataStructure211 {
    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        dictionary.addWord("pad");
        dictionary.addWord("bad");

        System.out.println(dictionary.search("b.d"));
    }

    static class WordDictionary {
        private Trie root;

        public WordDictionary() {
            this.root = new Trie('0');
        }

        public void addWord(String word) {
            Trie temp = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (temp.children[index] == null)
                    temp.children[index] = new Trie(c);

                temp = temp.children[index];
            }

            temp.isEnd = true;
        }

        public boolean search(String word) {
            for (Trie child : root.children)
                if (dfs(word, 0, child, root))
                    return true;

            return false;
        }

        private boolean dfs(String word, int index, Trie root, Trie parent) {
            if (word.length() == index) {
                if (word.charAt(index - 1) == '.')
                    return parent.isEnd;
                return parent.ch == word.charAt(index - 1) && parent.isEnd;
            }

            if (root == null)
                return false;

            if ((word.charAt(index)) != '.')
                if (root.ch != word.charAt(index))
                    return false;

            for (Trie child : root.children)
                if (dfs(word, index + 1, child, root))
                    return true;

            return false;
        }
    }

    @ToString
    static class Trie {
        char ch;
        Trie[] children;
        boolean isEnd;

        public Trie(char ch) {
            this.ch = ch;
            children = new Trie[26];
        }
    }
}