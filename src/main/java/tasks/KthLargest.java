package tasks;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;

public class KthLargest {
    private int k;
    private Map<Integer, Integer> mp;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        mp = new TreeMap<>(Comparator.comparing(Integer::intValue).reversed());

        for (int num : nums)
            mp.put(num, mp.getOrDefault(num, 0) + 1);
    }

    public int add(int val) {
        int count = this.k;
        int num;

//        LinkedList
        return -1;
    }
}


class Main {
    public static void main(String[] args) {

    }
}