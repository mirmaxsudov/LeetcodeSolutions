package tasks;

import java.util.HashMap;
import java.util.Map;

public class AllOOneDataStructure432 {
    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
        allOne.inc("leet");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }

    static class AllOne {
        private Map<String, Integer> mp = new HashMap<>();
        private int max = 0;
        private String maxkey = "";
        private int min = -1;
        private String minKey = "";

        public AllOne() {
        }

        public void inc(String key) {
            Integer value = mp.put(key, mp.getOrDefault(key, 0) + 1);

            if (value == null) {
                if (maxkey.isEmpty()) {
                    max = 1;
                    maxkey = key;
                }
            } else if (value + 1 > max) {
                max = value;
                maxkey = key;
            }

            if (min == -1) {
                min = value == null ? 1 : value;
                minKey = key;
            } else if (mp.get(minKey) > (value == null ? 1 : value)) {
                min = value == null ? 1 : value;
                minKey = key;
            }
        }

        public void dec(String key) {
            int value = mp.get(key);

            if (min == -1) {
                min = value;
                minKey = key;
                return;
            }

            if (value - 1 == 0) {
                mp.remove(key);
                min = Integer.MAX_VALUE;

                for (Map.Entry<String, Integer> entry : mp.entrySet())
                    if (entry.getValue() < min) {
                        min = entry.getValue();
                        minKey = entry.getKey();
                    }
            } else {
                mp.put(key, value - 1);

                if (value - 1 < min) {
                    min = value - 1;
                    minKey = key;
                }
            }
        }

        public String getMaxKey() {
            return maxkey;
        }

        public String getMinKey() {
            return minKey;
        }
    }
}
