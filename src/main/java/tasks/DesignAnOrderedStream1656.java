package tasks;

import java.util.*;

public class DesignAnOrderedStream1656 {
    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc"));
        System.out.println(os.insert(1, "aaaaa"));
        System.out.println(os.insert(2, "bbbbb"));
        System.out.println(os.insert(5, "eeeee"));
        System.out.println(os.insert(4, "ddddd"));
    }

    static class OrderedStream {
        private final Map<Integer, String> mp;
        private final boolean[] indexes;

        public OrderedStream(int n) {
            indexes = new boolean[n + 1];
            mp = new HashMap<>();
        }

        public List<String> insert(int idKey, String value) {
            mp.put(idKey, value);
            indexes[idKey] = true;

            List<String> res = new ArrayList<>();

            for (int i = idKey; i < indexes.length; i++) {
                if (!indexes[i])
                    break;

                res.add(mp.get(i));
            }

            return res;
        }

//            "insert",       "insert",    "insert",         "insert",       "insert"
//            [3, "ccccc"], [1, "aaaaa"],  [2, "bbbbb"],         [5, "eeeee"],   [4, "ddddd"]
//            [],             ["aaaaa"],   ["bbbbb", "ccccc"],  [],             ["ddddd", "eeeee"]]
    }
}