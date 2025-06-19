package tasks;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers386 {
    public static void main(String[] args) {
        LexicographicalNumbers386 main = new LexicographicalNumbers386();
//        System.out.println(main.lexicalOrder(13));
//        System.out.println(main.lexicalOrder(2));
        System.out.println(main.lexicalOrder(100));
    }

    @ToString
    class Trie {
        int val;
        Trie[] children;
        boolean isEnd;

        public Trie(int val) {
            this.val = val;
            this.children = new Trie[10];
        }
    }

    private Trie root = new Trie(0);

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i <= n; i++)
            insert(i);

        read(res, n, root, 0);

        return res;
    }

    private void read(List<Integer> res, int n, Trie temp, int prev) {
        if (res.size() == n)
            return;

        if (temp.isEnd)
            res.add(temp.val + prev);

        for (Trie child : temp.children) {
            if (child == null)
                continue;

            read(res, n, child, (temp.val + prev) * 10);
        }
    }

    private void insert(Integer num) {
        Trie temp = root;

        String strVal = num.toString();

        for (char c : strVal.toCharArray()) {
            int index = c - '0';

            if (temp.children[index] == null)
                temp.children[index] = new Trie(index);

            temp = temp.children[index];
        }

        temp.isEnd = true;
    }
}