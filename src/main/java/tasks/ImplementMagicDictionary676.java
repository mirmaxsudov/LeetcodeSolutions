package tasks;

public class ImplementMagicDictionary676 {
    public static void main(String[] args) {

    }

    class MagicDictionary {
        class Trie {
            Trie[] children;
            boolean isEndOfWord;

            public Trie() {
                this.children = new Trie[26];
            }
        }

        Trie root;

        public MagicDictionary() {
            root = new Trie();
        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                Trie temp = root;
                for (char c : word.toCharArray()) {
                    if (temp.children[c - 'a'] == null)
                        temp.children[c - 'a'] = new Trie();
                    temp = temp.children[c - 'a'];
                }
                temp.isEndOfWord = true;
            }
        }

        public boolean search(String searchWord) {
            Trie temp = root;
            for (char i = 'a'; i <= 'z'; i++) {
                char[] chars = searchWord.toCharArray();
                for (int j = 0; j < searchWord.length(); j++) {
                    if (searchWord.charAt(j) == i)
                        continue;
                    char prev = chars[j];
                    chars[j] = i;
                    if (searchFromTrie(new String(chars)))
                        return true;
                    chars[j] = prev;
                }
            }

            return false;
        }

        private boolean searchFromTrie(String word) {
            Trie temp = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (temp.children[ch - 'a'] == null)
                    return false;
                else
                    temp = temp.children[ch - 'a'];
            }

            return temp.isEndOfWord;
        }
    }
}