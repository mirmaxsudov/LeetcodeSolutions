package tasks;

public class FindTheLengthOfTheLongestCommonPrefix3043 {
    public static void main(String[] args) {

    }

    class Trie {
        Trie[] children;
        boolean isEnd;
        int len;

        public Trie() {
            this.children = new Trie[10];
            this.len = 0;
        }
    }

    int maxLen = 0;

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie root = new Trie();

        for (int num : arr1)
            insert(root, String.valueOf(num));

        for (int num : arr2)
            searchAndGetLen(String.valueOf(num), root);

        return maxLen;
    }

    private void searchAndGetLen(String val, Trie root) {
        Trie temp = root;
        for (char c : val.toCharArray()) {
            if (temp.children[c - '0'] == null)
                return;
            else {
                if (temp.children[c - '0'].isEnd)
                    maxLen = Math.max(maxLen, temp.children[c - '0'].len);

                temp = temp.children[c - '0'];
            }
        }
    }

    private void insert(Trie root, String val) {
        Trie temp = root;
        for (int i = 0; i < val.length(); i++) {
            char c = val.charAt(i);
            if (temp.children[c - '0'] == null)
                temp.children[c - '0'] = new Trie();

            temp = temp.children[c - '0'];
            temp.len = i + 1;
        }
        temp.isEnd = true;
        temp.len = val.length();
    }
}
