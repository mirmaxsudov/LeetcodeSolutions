package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityFrequencyCharacters3692 {
    public static void main(String[] args) {
        // pfpfgi
        // p => 2
        // f => 2
        // g => 1
        // i => 1
        MajorityFrequencyCharacters3692 mc = new MajorityFrequencyCharacters3692();
        System.out.println(mc.majorityFrequencyGroup("pfpfgi"));
        System.out.println(mc.majorityFrequencyGroup("aaabbbccdddde"));
    }

    public String majorityFrequencyGroup(String s) {
        Map<Character, Integer> mp = new HashMap<>();

        for (char ch : s.toCharArray())
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

        Map<Integer, List<Character>> collector = new HashMap<>();

        for (Map.Entry<Character, Integer> en : mp.entrySet()) {
            collector.putIfAbsent(en.getValue(), new ArrayList<>());
            collector.get(en.getValue()).add(en.getKey());
        }

        int max = -1, key = -1, size = 0;

        for (Map.Entry<Integer, List<Character>> en : collector.entrySet())
            if (en.getKey() > max) {
                if (size <= en.getValue().size()) {
                    size = en.getValue().size();
                    max = en.getKey();
                }
            }

        if (max == -1)
            return "";

        StringBuilder sb = new StringBuilder();

        for (Character ch : collector.get(max))
            sb.append(ch);

        return sb.toString();
    }
}
