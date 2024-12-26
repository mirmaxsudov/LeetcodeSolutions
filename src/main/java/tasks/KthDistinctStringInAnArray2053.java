package tasks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KthDistinctStringInAnArray2053 {
    public static void main(String[] args) {
        System.out.println(kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2));
        System.out.println(kthDistinct(new String[]{"aaa", "aa", "a"}, 1));
        System.out.println(kthDistinct(new String[]{"a", "b", "a"}, 3));
    }

    public static String kthDistinct(String[] arr, int k) {
        Set<String> c = new HashSet<>();
        List<String> strs = new ArrayList<>();

        for (String s : arr) {
            if (c.contains(s)) {
                strs.remove(s);
                continue;
            }

            c.add(s);
            strs.add(s);
        }

        return strs.size() < k ? "" : strs.get(k - 1);
    }
}