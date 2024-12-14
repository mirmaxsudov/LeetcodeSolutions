package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IncreasingDecreasingString1370 {
    public static void main(String[] args) {
//        System.out.println(sortString("rat") + " = " + "art");
        System.out.println(sortString("leetcode") + " = " + "cdelotee");
//        System.out.println(sortString("ggggggg") + " = " + "ggggggg");
//        System.out.println(sortString("spo") + " = " + "ops");
//        System.out.println(sortString("aaaabbbbcccc") + " = " + "abccbaabccba");
    }

    public static String sortString(String s) {
        Map<Character, Integer> mp = new TreeMap<>();

        for (int i = 0; i < s.toCharArray().length; i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int size = mp.size();
        int min = 0;

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(mp.entrySet());
        boolean isDescending = true;

        System.out.println("list = " + list);

        while (size > 0) {
            Map.Entry<Character, Integer> entry = list.get(min);

            if (isDescending) {
                if (entry.getValue() > 0) {
                    sb.append(entry.getKey());
                    entry.setValue(entry.getValue() - 1);

                    if (entry.getValue() == 0) {
                        size--;
                    }

                }
                min++;

                if (min == list.size()) {
                    isDescending = false;
                    min--;
                }
            } else {
                if (entry.getValue() > 0) {
                    sb.append(entry.getKey());
                    entry.setValue(entry.getValue() - 1);

                    if (entry.getValue() == 0) {
                        size--;
                    }

                }
                min--;

                if (min <= -1) {
                    isDescending = true;
                    min++;
                }
            }
        }

        return sb.toString();
    }
}
