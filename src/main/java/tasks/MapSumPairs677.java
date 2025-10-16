package tasks;

public class MapSumPairs677 {
    public static void main(String[] args) {

    }

    class MapSum {
        class Trie {
            int val;
            Trie[] children;
            boolean isEndOfWord;

            public Trie() {
                this.children = new Trie[26];
            }
        }

        Trie root;

        public MapSum() {
            this.root = new Trie();
            this.root.val = 0;
        }

        public void insert(String key, int val) {
            Trie temp = root;
            for (int i = 0; i < key.length(); i++) {
                char cha = key.charAt(i);

                if (temp.children[cha - 'a'] == null)
                    temp.children[cha - 'a'] = new Trie();

                temp = temp.children[cha - 'a'];
            }

            temp.isEndOfWord = true;
            temp.val = val;
        }

        public int sum(String prefix) {
            int sum = 0;

            Trie temp = root;

            for (char c : prefix.toCharArray()) {
                sum += temp.val;

                if (temp.children[c - 'a'] != null) {
                    temp = temp.children[c - 'a'];
                    sum += temp.val;
                } else
                    break;
            }

            return sum;
        }
    }
}