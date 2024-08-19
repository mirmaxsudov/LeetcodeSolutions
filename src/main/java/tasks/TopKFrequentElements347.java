package tasks;

import java.util.*;

public class TopKFrequentElements347 {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums)
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();

            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

//
//    public static int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> mps = new TreeMap<>();
//
//        for (int num : nums)
//            mps.put(num, mps.getOrDefault(num, 0) + 1);
//
//        int[] res = new int[k];
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> mps.get(b) - mps.get(a));
//
//        for (Map.Entry<Integer, Integer> entry : mps.entrySet()) {
//            pq.add(entry.getKey());
//        }
//
//        for (int i = 0; i < k; i++) {
//            res[i] = pq.poll();
//        }
//
//        return res;
//    }
}
