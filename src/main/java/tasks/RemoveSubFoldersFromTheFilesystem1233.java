package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFoldersFromTheFilesystem1233 {
    public static void main(String[] args) {

    }

    class Trie {
        boolean isEndWord;
        Trie[] children;

        public Trie() {
            this.children = new Trie[26];
        }
    }

    Trie root = new Trie();

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        List<String> r = new ArrayList<>();

        for (String str : folder) {
            // We will check, is it sub folder
            if (isSub(str)) {
            }

            // If not, we will insert
            for (char ch : str.toCharArray()) {

            }
        }

        return r;
    }

    private boolean isSub(String str) {
        Trie temp = root;

        for (char c : str.toCharArray()) {
            if (temp.children[c - 'a'] == null) {
                return false;
            }
        }

        return false;
    }
}
