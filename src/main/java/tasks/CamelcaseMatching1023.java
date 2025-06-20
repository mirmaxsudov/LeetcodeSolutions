package tasks;

import java.util.*;

public class CamelcaseMatching1023 {
    public static void main(String[] args) {
        System.out.println(camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FB"));
        System.out.println(camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBa"));
        System.out.println(camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBaT"));
        System.out.println(camelMatch(new String[]{"CompetitiveProgramming", "CounterPick", "ControlPanel"}, "CooP"));
    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>(queries.length);

        for (String query : queries)
            res.add(isMatch(query, pattern));

        return res;
    }

    private static boolean isMatch(String query, String pattern) {
        int fi, si;
        fi = si = 0;

        upper:
        while (fi < query.length() && si < pattern.length()) {
            char patternChar = pattern.charAt(si);

            if (Character.isUpperCase(patternChar) && Character.isUpperCase(query.charAt(fi))) {
                if (query.charAt(fi) != patternChar)
                    return false;

                fi++;
                si++;
                continue;
            }

            if (Character.isUpperCase(patternChar) && Character.isLowerCase(query.charAt(fi))) {
                while (fi < query.length()) {
                    if (Character.isUpperCase(query.charAt(fi)))
                        continue upper;
                    fi++;
                }

                continue;
            }

            int fii = fi;

            Map<Character, Integer> mp = new HashMap<>();

            while (fii < query.length()) {
                if (Character.isUpperCase(query.charAt(fii)))
                    break;

                mp.put(query.charAt(fii), mp.getOrDefault(query.charAt(fii), 0) + 1);
                fii++;
            }

            if (mp.getOrDefault(patternChar, 0) <= 0)
                return false;

            int sii = si + 1;

            mp.put(patternChar, mp.getOrDefault(patternChar, 0) - 1);

            while (sii < pattern.length()) {
                if (Character.isUpperCase(pattern.charAt(sii)))
                    break;

                int val = mp.getOrDefault(pattern.charAt(sii), 0);

                if (val <= 0)
                    return false;

                mp.put(pattern.charAt(sii), val - 1);

                sii++;
            }

            fi = fii;
            si = sii;
        }

        if (si != pattern.length())
            return false;

        if (fi != query.length())
            // Make sure not exists upper case letters. If exists return false;
            while (fi < query.length())
                if (Character.isUpperCase(query.charAt(fi++)))
                    return false;

        return true;
    }
}