package tasks;

public class MapSumPairs677 {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("apple"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }

    static class MapSum {
        class Trie {
            int sum;
            int val;
            Trie[] children;
            boolean isEndOfWord;

            public Trie() {
                this.children = new Trie[26];
                this.sum = 0;
                this.val = 0;
            }
        }

        Trie root;

        public MapSum() {
            this.root = new Trie();
        }

        public void insert(String key, int val) {
            Trie temp = root;
            for (char c : key.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new Trie();
                }
                temp = temp.children[c - 'a'];
                Trie word = getWord(key);
                if (word != null)
                    temp.sum -= word.val;

                temp.sum += val;
            }
            temp.isEndOfWord = true;
            temp.val = val;
        }

        private Trie getWord(String key) {
            Trie temp = root;

            for (char c : key.toCharArray()) {
                if (temp.children[c - 'a'] == null)
                    return null;
                temp = temp.children[c - 'a'];
            }

            return temp.isEndOfWord ? temp : null;
        }

        public int sum(String prefix) {
            Trie temp = root;

            for (char c : prefix.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    return 0;
                } else {
                    temp = temp.children[c - 'a'];
                }
            }

            return temp.sum;
        }
    }
}