package tasks;

import java.util.*;

public class SearchSuggestionsSystem1268 {
    public static void main(String[] args) {
        SearchSuggestionsSystem1268 main = new SearchSuggestionsSystem1268();
//        System.out.println(main.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
        System.out.println(main.suggestedProducts(new String[]{"havana"}, "havana"));
    }

    class Trie {
        int count;
        boolean isEnd;
        Trie[] children;
        char ch;

        public Trie(char ch) {
            count = 0;
            this.ch = ch;
            children = new Trie[26];
        }
    }

    Trie root = new Trie('0');
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for (String product : products)
            insert(product);

        PriorityQueue<String> pq = new PriorityQueue<>(String::compareTo);

        for (int i = 0; i < searchWord.length(); i++) {
            String sub = searchWord.substring(0, i + 1);
            pq.clear();

            for (Trie child : root.children)
                search(sub, 0, pq, child);

            List<String> child = new ArrayList<>();

            if (pq.size() > 3)
                for (int j = 0; j < 3; j++) {
                    String poll = pq.poll();

                    if (poll != null)
                        child.add(poll);
                }
            else {
                while (!pq.isEmpty())
                    child.add(pq.poll());
            }

            res.add(child);
        }

        return res;
    }

    private void search(String sub, int index, PriorityQueue<String> pq, Trie temp) {
        if (temp == null)
            return;

        if (sub.length() == index) {
            getAllWords(pq, temp, sub);
            return;
        }

        if (temp.isEnd)
            pq.add(sub);

        if (sub.charAt(index) == temp.ch)
            for (Trie child : temp.children)
                search(sub, index + 1, pq, child);
    }

    private void getAllWords(PriorityQueue<String> pq, Trie temp, String prefix) {
        if (temp == null)
            return;

        if (temp.isEnd)
            pq.add(prefix + temp.ch);

        for (Trie child : temp.children)
            getAllWords(pq, child, prefix + temp.ch);
    }

    private void insert(String product) {
        Trie temp = root;
        for (char c : product.toCharArray()) {
            int index = c - 'a';
            if (temp.children[index] == null)
                temp.children[index] = new Trie(c);

            temp = temp.children[index];
        }

        if (temp.isEnd)
            temp.count++;

        temp.isEnd = true;
    }
}